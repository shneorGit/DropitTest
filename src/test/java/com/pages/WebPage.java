package com.pages;

import com.setup.ReusableFunctions;
import org.openqa.selenium.By;

public class WebPage extends ReusableFunctions {
    public By password = By.id("password");
    public By enterButton = By.xpath("//button[@type = 'submit']");
    public By welcomeMessage = By.xpath("//p[contains(text(), 'Welcome to our store')]");
    public By catalogButton = By.xpath("//span[contains(text(), 'Catalog')]");
    public By searchButton = By.xpath("//summary[contains(@class, 'icon--search')]");
    public By searchField = By.id("Search-In-Modal");
    public By searchResult = By.xpath("//h3[contains(text(), 'Dropit Hamburger (QA Automation)')]");
    public By hamburgerPageTitle = By.xpath("//h1[contains(text(), 'Dropit Hamburger (QA Automation)')]");
    public By mediumButton = By.xpath("//label[contains(text(), 'Medium')]");
    public By plusButton = By.xpath("//button[@name = 'plus']");
    public By minusButton = By.xpath("//button[@name = 'minus']");
    public By addToCartButton = By.xpath("//span[contains(text(), 'Add to cart')]");
    public By continueShoppingButton = By.xpath("//button[contains(text(), 'Continue shopping')]");
    public By hamburgerSoLargeButton = By.xpath("//label[contains(text(), \"So large you can't eat it\")]");
    public By itemsInCart = By.xpath("//span[contains(text(), 'items')]");
    public By cartButton = By.cssSelector(".icon.icon-cart");
    public By searchChipsResult = By.xpath("//h3[contains(text(), 'Dropit Chips (QA Automation)')]");
    public By chipsPageTitle = By.xpath("//h1[contains(text(), 'Dropit Chips (QA Automation)')]");
    public By largeButton = By.xpath("//label[contains(text(), 'Large')]");
    public By chipsTooMuchForYouButton = By.xpath("//label[contains(text(), \"Too much for you to handle\")]");
    public By checkoutButton = By.id("checkout");
    public By totalPrice = By.xpath("//strong[contains(text(), '£')]");
    public By emailField = By.id("email");
    public By firstNameField = By.name("firstName");
    public By lastNameField = By.name("lastName");
    public By addressField = By.name("address1");
    public By cityField = By.xpath("//input[@placeholder = 'City']");
    public By cardNumberField = By.xpath("//input[@placeholder = 'Card number']");
    public By expirationDateField = By.xpath("//input[@placeholder = 'Expiration date (MM / YY)']");
    public By securityCodeField = By.xpath("//input[@placeholder = 'Security code']");
    public By nameOnCardField = By.xpath("//input[@placeholder = 'Name on card']");
    public By payButton = By.id("checkout-pay-button");
    public By iframeCardNumber = By.xpath("//iframe[contains(@title, 'Card number')]");
    public By iframeExpirationDate = By.xpath("//iframe[contains(@title, 'Expiration date')]");
    public By iframeSecurityCode = By.xpath("//iframe[contains(@title, 'Security code')]");
    public By iframeNameOnCard = By.xpath("//iframe[contains(@title, 'Name on card')]");
    public By clearTextButton = By.xpath("//button[@aria-label = 'Clear']");
    public By messageAfterOrdering = By.xpath("//h2[contains(text(), 'Thank you, Shneor!')]");
    public By emailErrorMessage = By.xpath("//input[@id = 'email']//following::p[contains(text(), 'Enter a valid email')]");
    public By cardNumberErrorMessage = By.xpath("//div[@id= 'number']//following::p[contains(text(), 'Enter a card number')]");
}
