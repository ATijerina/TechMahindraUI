package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseUITest;

import java.time.Duration;
import java.util.List;

public class AvailabilityTest extends BaseUITest {

    @Test
    public void testRoomsDisplayed() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement bookingLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#booking']"))
        );
        bookingLink.click();
        Thread.sleep(1000);

        // Buscamos el botón "Check Availability" por sus clases

        WebElement checkButton = driver.findElement(By.xpath("//button[text()='Check Availability']"));
        checkButton.click();

        // Esperamos 2 segundos para que se carguen las habitaciones
        Thread.sleep(2000);
         //
        List<WebElement> rooms = driver.findElements(By.cssSelector(".room-card"));
        //si hago mi test con true quiero decir que esta vacia y el test falla porque me diria que si hay hab dispo
        Assert.assertFalse(rooms.isEmpty(), "Hay habitaciones disponibles");
    }

    }


