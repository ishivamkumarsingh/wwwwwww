package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElectronicsPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public ElectronicsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void selectProductByName(String productName) {
        String xpath = "//h2[@class='product-title']/a[contains(text(),'" + productName + "')]";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath))).click();
    }
}
