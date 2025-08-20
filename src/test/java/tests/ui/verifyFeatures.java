package tests.ui;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.List;


public class verifyFeatures {

    @Test
    public void verifySuiteFeatures() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationintesting.online/#booking");
        //Buscar y mapper los elementos
        //Button suite room

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bookbutton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now']"))
        );

        List<WebElement> rooms = driver.findElements(By.xpath("//a[text()='Book now']"));
        WebElement suiteRoom = rooms.get(2); // índice 2 → tercer elemento (Suite Room)


        Actions actions = new Actions(driver);
        actions.moveToElement(suiteRoom);
        actions.perform();

        suiteRoom.click();


        // Esperar la sección de features
        WebElement featuresSection = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='row g-3 d-flex flex-wrap']"))
        );

        actions.moveToElement(featuresSection);
        actions.perform();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'bi-speaker')]")).isDisplayed(), "Radio no visible");
        softAssert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'bi-wifi')]")).isDisplayed(), "Wifi no visible");
        softAssert.assertTrue(driver.findElement(By.xpath("//i[contains(@class,'bi-safe')]")).isDisplayed(), "Safe no visible");

        driver.quit();


    }
}


