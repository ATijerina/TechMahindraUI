package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.base.BaseUITest;

import java.time.Duration;
import java.util.List;

public class CheckInCheckOutTest extends BaseUITest {

    @Test
    public void fillDatesAndCheckAvailability() {
        // 1️⃣ Ir directamente a la sección booking
        driver.get("https://automationintesting.online/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bookingLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#booking']"))
        );

        WebElement bookingSection = driver.findElement(By.id("booking"));
        Actions actions = new Actions(driver);
        actions.moveToElement(bookingSection);
        actions.perform();


        List<WebElement> dateInputs = driver.findElements(By.cssSelector(".react-datepicker__input-container"));

        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));

        //Tarde hrs en esta parte
        // No olvidar que tienes que hacer click en la cajita y ahi cambia el elemento no es el mismo
        //en la cajita son 2 elemntos que se enlistan in y out al estar dentro podemos tener el mismo selector

        WebElement divCheckIn = dateInputs.get(0);//cajita de check in ya estoy dentro del contexto
        WebElement checkin = divCheckIn.findElement(By.cssSelector(".form-control"));
        WebElement divChout = dateInputs.get(1);
        WebElement checkout = divChout.findElement(By.cssSelector(".form-control"));

        // 3️ Limpiar fechas predefinidas
        checkin.clear();
        checkout.clear();

        // 4️ Escribir nuevas fechas
        checkin.sendKeys("20/08/2025");
        checkout.sendKeys("27/08/2025");

        // 5️ Click en Check Availability
        WebElement checkAvailabilityBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))
        );
        checkAvailabilityBtn.click();

        driver.quit();
    }
}


