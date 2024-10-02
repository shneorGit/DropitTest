package com.cucumber.steps;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class Hooks {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ExtentReports extent;
    public static ExtentTest test;

    @Before
    public static void beforeTest(Scenario scenario) throws IOException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        ExtentSparkReporter spark = new ExtentSparkReporter("/test-output/SparkReport/spark.html");
        spark.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        extent = new ExtentReports();
        extent.attachReporter(spark);
        test = extent.createTest(scenario.getName());
        driver.manage().window().maximize();
    }

    @After
    public static void afterTest() {
        driver.close();
        driver.quit();
        extent.flush();
    }
}
