package ui.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginMaps {
    private WebDriver driver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("doLogin");

    public LoginMaps(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void goToLoginPage() {
        driver.get("https://automationintesting.online/admin");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
}
