
package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

    public class PruebaCasos {

        WebDriver driver;
        WebDriverWait wait;
        Actions actions;

        @BeforeMethod
        public void setup() {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            actions = new Actions(driver);
            driver.get("https://automationintesting.online/#booking");
        }

        @AfterMethod
        public void tearDown() {
            driver.quit();
        }

        @Test(groups = {"smoke"})
        public void testCheckAvailability() {
            // Seleccionar fechas
            List<WebElement> dateInputs = driver.findElements(By.cssSelector(".react-datepicker__input-container"));
            WebElement checkin = dateInputs.get(0).findElement(By.cssSelector(".form-control"));
            WebElement checkout = dateInputs.get(1).findElement(By.cssSelector(".form-control"));

            checkin.clear();
            checkout.clear();
            checkin.sendKeys("19/08/2025");
            checkout.sendKeys("20/08/2025");

            WebElement checkAvailabilityBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))
            );
            checkAvailabilityBtn.click();

            List<WebElement> rooms = driver.findElements(By.xpath("//a[text()='Book now']"));
            Assert.assertTrue(rooms.size() > 0, "No se listaron habitaciones disponibles.");
        }

        @Test(groups = {"smoke"})
        public void testSelectSuiteRoom() {
            List<WebElement> rooms = driver.findElements(By.xpath("//a[text()='Book now']"));
            WebElement suiteRoom = rooms.get(2);
            actions.moveToElement(suiteRoom).perform();
            suiteRoom.click();

            WebElement reserveNowButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("doReservation"))
            );
            Assert.assertTrue(reserveNowButton.isDisplayed(), "No se pudo seleccionar Suite Room.");
        }

        @Test(groups = {"regression"})
        public void testSubmitBooking() {
            // Ir directo a reservar suite (atajo por URL)
            driver.get("https://automationintesting.online/#/reservation/3?checkin=2025-08-17&checkout=2025-08-18");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("Andrea");
            driver.findElement(By.xpath("//input[@placeholder='Lastname']")).sendKeys("Tijerina");
            driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Andrea.Test@live.com");
            driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("844323125512");

            WebElement reserveNow = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Reserve Now']"))
            );
            actions.moveToElement(reserveNow).perform();
            reserveNow.click();

            // Validar en admin
            driver.get("https://automationintesting.online/admin");
            driver.findElement(By.id("username")).sendKeys("admin");
            driver.findElement(By.id("password")).sendKeys("password");
            driver.findElement(By.id("doLogin")).click();

            WebElement alert = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have a new booking!']"))
            );
            Assert.assertTrue(alert.isDisplayed(), "El booking no fue enviado correctamente");
        }
    }

