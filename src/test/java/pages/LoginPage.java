package pages;

import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    
    public void login(String username, String password) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys(username);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]"))).click();
        } catch (TimeoutException e) {
            System.out.println("Captcha or delay detected. Please manually solve the captcha in the browser and then press Enter to continue...");
            new Scanner(System.in).nextLine();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email"))).sendKeys(username);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password"))).sendKeys(password);
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Log in')]"))).click();
        }
    }
    
    public boolean verifyLoginSuccessful() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))).isDisplayed();
    }
}
