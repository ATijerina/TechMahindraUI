package tests.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LoginAdmin {
    @Test
    public void logingWithValidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationintesting.online/admin");

        //Buscar y mapper los elementos
        //user name
        driver.findElement(By.id("username")).sendKeys("admin");
        //Pasword
        WebElement passwordTxtBox = driver.findElement(By.id("password"));
        passwordTxtBox.sendKeys("password");

        //Sing in button
        WebElement submitBtn = driver.findElement(By.id("doLogin"));

        //click summit
        submitBtn.click();

        //esperamos
        Thread.sleep(3000);

        driver.quit();
    }
}