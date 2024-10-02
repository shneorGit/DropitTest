package com.cucumber.steps;

import com.pages.WebPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WebSteps extends WebPage {
    @Given("navigate to junk food website")
    public void navigateToJunkFoodWebsite() {
        navigateToUrl("junkFoodUrl");
    }

    @And("insert password")
    public void insertPassword() {
        insertText(password, "giclao");
    }

    @When("click on enter")
    public void clickOnEnter() {
        clickOnElement(enterButton);
    }

    @Then("verify welcome message is appear")
    public void verifyWelcomeMessageIsAppear() {
        elementIsDisplay(welcomeMessage);
    }

    @When("click on catalog button")
    public void clickOnCatalogButton() {
        clickOnElement(catalogButton);
    }

    @And("click on search button")
    public void clickOnSearchButton() {
        clickOnElement(searchButton);
    }

    @Then("insert {string} to search")
    public void insertTextToSearch(String text) {
        insertText(searchField, text);
    }

    @When("result is appears")
    public void resultIsAppears() {
        elementIsDisplay(searchResult);
    }

    @And("click on the result")
    public void clickOnTheResult() {
        clickOnElement(searchResult);
    }

    @And("verify you got to hamburger page")
    public void verifyYouGotToHamburgerPage() {
        elementIsDisplay(hamburgerPageTitle);
    }

    @Then("add hamburgers to cart")
    public void addHamburgersToCart() {
        clickOnElement(mediumButton);
        clickOnElement(plusButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
        clickOnElement(continueShoppingButton);
        waitUntilElementClickable(hamburgerSoLargeButton);
        waitUntil(2);
        clickOnElement(hamburgerSoLargeButton);
        clickOnElement(minusButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
    }

    @And("verify cart is with {string} items")
    public void verifyCartIsWithThreeItems(String number) {
        if (getTextFromElement(itemsInCart).contains(number)) {
            addPassLog("hamburgers have been added");
        }
        else {
            addFailLog("Hamburgers were not added");
        }
    }

    @When("result of chips is appears")
    public void resultOfChipsIsAppears() {
        elementIsDisplay(searchChipsResult);
    }

    @And("click on the chips result")
    public void clickOnTheChipsResult() {
        clickOnElement(searchChipsResult);
    }

    @And("verify you got to chips page")
    public void verifyYouGotToChipsPage() {
        elementIsDisplay(chipsPageTitle);
    }

    @Then("add chips to cart")
    public void addChipsToCart() {
        clickOnElement(largeButton);
        clickOnElement(plusButton);
        waitUntilElementClickable(addToCartButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
        clickOnElement(continueShoppingButton);
        waitUntilElementClickable(chipsTooMuchForYouButton);
        waitUntil(3);
        clickOnElement(chipsTooMuchForYouButton);
        clickOnElement(minusButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
    }

    @When("click on bag icon")
    public void clickOnBagIcon() {
        clickOnElement(cartButton);
    }
    @When("click on check out button")
    public void clickOnCheckOutButton() {
        scrollToElement(checkoutButton);
        clickOnElement(checkoutButton);
    }
    @Then("verify the price is correct")
    public void verifyThePriceIsCorrect() {
        scrollToElement(totalPrice);
        if (getTextFromElement(totalPrice).contains("56.99")) {
            addPassLog("the price is correct");
        }
        else {
            addFailLog("the price is NOT correct!");
        }
    }
    @When("filing fields")
    public void filingFields() {
        insertText(emailField, "shneorzi77017@gmail.com");
        insertText(firstNameField, "Shneor");
        insertText(lastNameField, "Izenberger");
        insertText(addressField, "dropit");
        insertText(cityField, "Tel Aviv");
        switchToIframe(iframeCardNumber);
        insertText(cardNumberField, "1");
        switchToDefaultIframe();
        switchToIframe(iframeExpirationDate);
        insertText(expirationDateField, "12/26");
        switchToDefaultIframe();
        switchToIframe(iframeSecurityCode);
        insertText(securityCodeField, "777");
        switchToDefaultIframe();
        scrollToElement(iframeNameOnCard);
        clickOnElement(clearTextButton);
        switchToIframe(iframeNameOnCard);
        insertText(nameOnCardField, "Bogus Gateway");
        switchToDefaultIframe();
    }

    @When("click on pay now")
    public void clickOnPayNow() {
        scrollToElement(payButton);
        clickOnElement(payButton);
    }
    @Then("verify the order was received")
    public void verifyTheOrderWasReceived() {
        elementIsDisplay(messageAfterOrdering);
    }

    @Then("add one hamburgers to cart")
    public void addOneHamburgersToCart() {
        clickOnElement(mediumButton);
        waitUntilElementClickable(addToCartButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
        clickOnElement(continueShoppingButton);
    }

    @And("add one chips to cart")
    public void addOneChipsToCart() {
        clickOnSearchButton();
        insertTextToSearch("Dropit Chips (QA Automation)");
        resultOfChipsIsAppears();
        clickOnTheChipsResult();
        clickOnElement(largeButton);
        waitUntilElementClickable(addToCartButton);
        scrollToElement(addToCartButton);
        clickOnElement(addToCartButton);
        waitUntilElementVisible(continueShoppingButton);
    }

    @Then("add non valid email")
    public void addNonValidEmail() {
        insertText(emailField, "shneorzi77017");
    }

    @And("add non valid card number")
    public void addNonValidCardNumber() {
        switchToIframe(iframeCardNumber);
        insertText(cardNumberField, "shneor");
        switchToDefaultIframe();
    }

    @Then("verify error message appears")
    public void verifyErrorMessageAppears() {
        elementIsDisplay(emailErrorMessage);
        elementIsDisplay(cardNumberErrorMessage);
    }





}
