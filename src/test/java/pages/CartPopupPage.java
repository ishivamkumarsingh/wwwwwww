package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPopupPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public CartPopupPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void hoverOverCart() {
        
        WebElement cartElement = driver.findElement(By.cssSelector("span.cart-qty"));
        Actions actions = new Actions(driver);
        actions.moveToElement(cartElement).perform();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flyout-cart\"]/div")));
    }
    
    public String getProductName() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flyout-cart\"]/div/div[2]/div/div[2]/div[1]"))).getText();
    }
    
    public String getUnitPrice() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flyout-cart\"]/div/div[2]/div/div[2]/div[2]"))).getText();
    }
    
    public String getQuantity() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"flyout-cart\"]/div/div[2]/div/div[2]/div[3]"))).getText();
    }
}
