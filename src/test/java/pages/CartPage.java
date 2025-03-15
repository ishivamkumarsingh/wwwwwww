package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public String getUnitPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.product-unit-price"))).getText();
    }
    
    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("td.product a"))).getText();
    }
    
    public String getQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]"))).getAttribute("value");
    }
    
    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout\"]"))).click();
    }
    
    public void clickTermsOfService() {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("termsofservice"))).click();
    }
}
