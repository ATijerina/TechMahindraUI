package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class EndToEndBookingTest {

    @Test
    public void completeBookingFlow() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Actions actions = new Actions(driver);

        // 1️⃣ Abrir la página principal
        driver.get("https://automationintesting.online/");

        // 2️⃣ Ir a la sección booking
        WebElement bookingSection = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#booking']"))
        );
        actions.moveToElement(bookingSection).perform();

        WebElement bookingDiv = driver.findElement(By.id("booking"));
        actions.moveToElement(bookingDiv).perform();

        // 3️⃣ Completar fechas
        List<WebElement> dateInputs = driver.findElements(By.cssSelector(".react-datepicker__input-container"));

        WebElement checkinInput = dateInputs.get(0).findElement(By.cssSelector(".form-control"));
        WebElement checkoutInput = dateInputs.get(1).findElement(By.cssSelector(".form-control"));

        checkinInput.clear();
        checkinInput.sendKeys("28/09/2025");

        checkoutInput.clear();
        checkoutInput.sendKeys("29/09/2025");

        // 4️⃣ Click en Check Availability
        WebElement checkAvailabilityBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))
        );
        checkAvailabilityBtn.click();

        // 5️⃣ Seleccionar Suite Room → Book now
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Book now']")));
        List<WebElement> bookNowButtons = driver.findElements(By.xpath("//a[text()='Book now']"));
        WebElement suiteRoomBtn = bookNowButtons.get(2); // tercer botón = Suite Room
        actions.moveToElement(suiteRoomBtn).perform();
        suiteRoomBtn.click();

        // 6️⃣ Click en Reserve Now
        WebElement reserveNowBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("doReservation"))
        );
        actions.moveToElement(reserveNowBtn).perform();
        reserveNowBtn.click();

        // 7️⃣ Llenar formulario de booking
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("Andrea");
        driver.findElement(By.xpath("//input[@placeholder='Lastname']")).sendKeys("Tijerina");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Andrea.Test@live.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("844323125512");

        WebElement finalReserveBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Reserve Now']"))
        );
        actions.moveToElement(finalReserveBtn).perform();
        finalReserveBtn.click();

        // 8️⃣ Login como admin para verificar booking
        driver.get("https://automationintesting.online/admin");

        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.id("doLogin")).click();

        // 9️⃣ Abrir Messages y validar nuevo booking
        WebElement messagesBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Messages')]"))
        );
        messagesBtn.click();

        WebElement newBookingAlert = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have a new booking!']"))
        );
        Assert.assertTrue(newBookingAlert.isDisplayed(), "El booking no fue enviado correctamente");

        driver.quit();
    }
}
