package tests.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;


public class VerifyBooking {
    @Test


    public void logingWithValidCredentials() throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://automationintesting.online/admin");

        //Buscar y mapper los elementos
        //user name
//        driver.findElement(By.id("username")).sendKeys("admin");
//        //Pasword
//        WebElement passwordTxtBox = driver.findElement(By.id("password"));
//        passwordTxtBox.sendKeys("password");
//
//        //Sing in button
//        WebElement submitBtn = driver.findElement(By.id("doLogin"));
//        //click summit
//        submitBtn.click();
//        //esperamos
//        Thread.sleep(3000);
//
//        WebElement messagesBtn = driver.findElement(By.xpath("//a[contains(text(), 'Messages')]"));
//        messagesBtn.click();
//        Thread.sleep(3000);

//        WebElement bookIn = driver.findElement(By.xpath("//p[text()='You have a new booking!']"));
//        bookIn.click();
//        Thread.sleep(3000);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        WebElement alert = wait.until(
//                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have a new booking!']"))));
//        Assert.assertTrue(alert.isDisplayed(), "El booking no fue enviado correctamente");



        driver.quit();
    }
}