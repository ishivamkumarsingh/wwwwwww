package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public boolean isErrorMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"terms-of-service-warning-box\"]"))).isDisplayed();
    }
    
    public void closeErrorPopup() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[5]/div[1]/button/span[1]"))).click();
    }
}
