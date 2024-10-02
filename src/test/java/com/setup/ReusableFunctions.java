package com.setup;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import static com.cucumber.steps.Hooks.*;

public class ReusableFunctions {
    public static Properties properties = new Properties();
    public static String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "TestMethod");

    public void setPropertiesFile() {
        try {
            FileInputStream input = new FileInputStream("src/test/resources/settings.properties");
            properties.load(input);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void navigateToUrl(String url) {
        setPropertiesFile();
        driver.navigate().to(properties.getProperty(url));
        addPassLog("successes navigate to url: \n" + url);
    }

    public void addPassLog(String description) {
        test.log(Status.PASS, description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public void addFailLog(String description) {
        test.log(Status.FAIL, description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public void addInfoLog(String description) {
        test.log(Status.INFO, description, MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    public void waitUntilElementVisible(By element) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public void waitUntilElementClickable(By element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void insertText(By element, String text) {
        waitUntilElementVisible(element);
        scrollToElement(element);
        driver.findElement(element).sendKeys(text);
        addInfoLog("insertText: " + text + " to element: " + element);
    }

    public void clickOnElement(By element) {
        waitUntilElementVisible(element);
        driver.findElement(element).click();
        addInfoLog("clickOnElement: " + element);
    }

    public void elementIsDisplay(By element) {
        waitUntilElementVisible(element);
        if (driver.findElement(element).isDisplayed()) {
            addPassLog("element is display: " + element);
        }
        else {
            addFailLog("element is not display! " + element);
        }
    }

    public void scrollToElement(By element) {
        Actions actions = new Actions(driver);
        actions.scrollToElement(driver.findElement(element)).build().perform();
        addInfoLog("scroll to element: " + element);
    }

    public String getTextFromElement(By element) {
        return driver.findElement(element).getText();
    }

    public void waitUntil(int second) {
        try {
            int milliseconds = second * 1000;
            Thread.sleep(milliseconds);
        }
        catch (Exception e) {
            addFailLog(Arrays.toString(e.getStackTrace()));
        }
    }

    public void switchToIframe(By element) {
        driver.switchTo().frame(driver.findElement(element));
        addInfoLog("switch to iframe: " + element);
    }

    public void switchToDefaultIframe() {
        driver.switchTo().defaultContent();
        addInfoLog("switch to default iframe");
    }
}
