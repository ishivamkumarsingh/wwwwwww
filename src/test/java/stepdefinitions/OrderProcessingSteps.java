package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.HomePage;
import pages.ElectronicsPage;
import pages.ProductPage;
import pages.CartPage;
import pages.CartPopupPage;
import pages.CheckoutPage;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class OrderProcessingSteps {
    WebDriver driver;
    WebDriverWait wait;
    HomePage homePage;
    ElectronicsPage electronicsPage;
    ProductPage productPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    
    @Before
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\eclipse-workspace\\MA3_JavaSelenium_YashbeerSingh_24NAG5098_29570557\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    
    @Given("I open the Demowebshop application")
    public void openApplication() {
        driver.get("http://demowebshop.tricentis.com/");
        homePage = new HomePage(driver, wait);
    }
    
    @Then("I verify the page title contains {string}")
    public void verifyTitle(String titleFragment) {
        Assert.assertTrue(driver.getTitle().contains(titleFragment), "Title verification failed");
    }
    
    @When("I navigate to Electronics -> Cell phones")
    public void navigateToCellPhones() {
        homePage.navigateToElectronics();
        homePage.selectCellPhones();
    }
    
    @When("I select the {string} item and verify its price is {string}")
    public void selectItemAndVerifyPrice(String productName, String expectedPrice) {
        electronicsPage = new ElectronicsPage(driver, wait);
        electronicsPage.selectProductByName(productName);
        productPage = new ProductPage(driver, wait);
        Assert.assertEquals(productPage.getProductPrice(), expectedPrice, "Product price mismatch");
    }
    
    @When("I verify that the shopping cart shows {string}")
    public void verifyShoppingCartCount(String expectedText) {
        String actualText = "";
        if (productPage != null) {
            actualText = productPage.getCartQuantity();
        } else {
            actualText = homePage.getShoppingCartText();
        }
        boolean isUpdated = wait.until(ExpectedConditions.textToBe(By.cssSelector("span.cart-qty"), expectedText));
        Assert.assertTrue(isUpdated, "Shopping cart count mismatch expected [" + expectedText + "] but found [" + actualText + "]");
    }

    
    @When("I click on {string}")
    public void clickOnElement(String elementName) {
        if(elementName.equalsIgnoreCase("Add to cart")) {
            productPage.clickAddToCart();
        } else if(elementName.equalsIgnoreCase("Go to cart")) {
            homePage.goToCart();
            cartPage = new CartPage(driver, wait);
        } else if(elementName.equalsIgnoreCase("Checkout")) {
            if(cartPage == null) {
                cartPage = new CartPage(driver, wait);
            }
            cartPage.clickCheckout();
        } else if(elementName.equalsIgnoreCase("Terms of service")) {
            cartPage.clickTermsOfService();
        }
    }
    
    @When("I verify the product details: unit price {string}, product name {string}, and quantity {string}")
    public void verifyProductDetails(String expectedUnitPrice, String expectedProductName, String expectedQuantity) {
        // Create an instance of CartPopupPage and hover to display the popup
        CartPopupPage cartPopup = new CartPopupPage(driver, wait);
        cartPopup.hoverOverCart();
        
        String actualUnitPrice = cartPopup.getUnitPrice();
        String actualProductName = cartPopup.getProductName();
        String actualQuantity = cartPopup.getQuantity();
        
        Assert.assertEquals(actualUnitPrice, expectedUnitPrice, "Unit price mismatch in popup");
        Assert.assertEquals(actualProductName, expectedProductName, "Product name mismatch in popup");
        Assert.assertEquals(actualQuantity, expectedQuantity, "Quantity mismatch in popup");
    }
    
    @Then("I verify that an error message appears and close the popup")
    public void verifyErrorMessageAndClosePopup() {
        checkoutPage = new CheckoutPage(driver, wait);
        Assert.assertTrue(checkoutPage.isErrorMessageDisplayed(), "Error message not displayed during checkout");
        checkoutPage.closeErrorPopup();
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
}
