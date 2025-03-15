package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    
    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void navigateToElectronics() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Electronics"))).click();
    }
    
    public void selectCellPhones() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Cell phones"))).click();
    }
    
    public String getShoppingCartText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.cart-qty"))).getText();
    }
    
    public void goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Shopping cart"))).click();
    }
}
