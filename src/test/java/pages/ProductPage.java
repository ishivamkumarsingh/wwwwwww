package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public ProductPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public String getProductPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"product-details-form\"]/div/div[1]/div[2]/div[5]/div/span"))).getText();
    }
    
    public void clickAddToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"add-to-cart-button-43\"]"))).click();
    }
    public String getCartQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.cart-qty"))).getText();
    }

}
