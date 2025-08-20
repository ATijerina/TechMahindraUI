


package tests.ui;

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

public class BookingTest {

    @Test
    public void submitBooking() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationintesting.online/#booking");

        //Buscar y mapper los elementos
        //Button suite room

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
        checkin.sendKeys("19/08/2025");
        checkout.sendKeys("20/08/2025");

        // 5️ Click en Check Availability
        WebElement checkAvailabilityBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("button.btn.btn-primary"))
        );
        checkAvailabilityBtn.click();

        WebElement bookbutton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now']"))
        );

        List<WebElement> rooms = driver.findElements(By.xpath("//a[text()='Book now']"));
        WebElement suiteRoom = rooms.get(2); // índice 2 → tercer elemento (Suite Room)


        Actions actionsUno = new Actions(driver);
        actions.moveToElement(suiteRoom);
        actions.perform();

        suiteRoom.click();

        WebElement reserveNowButton = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("doReservation")));
        actions.moveToElement(reserveNowButton);
        actions.perform();
        reserveNowButton.click();

        //  Llenar formulario de booking

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("firstname"))).sendKeys("Andrea");
        driver.findElement(By.xpath("//input[@placeholder='Lastname']")).sendKeys("Tijerina");
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("Andrea.Test@live.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone']")).sendKeys("844323125512");


        WebElement reserveNow = wait.until(
        ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Reserve Now']")));
        actions.moveToElement(reserveNow);
        actions.perform();
        reserveNow.click();

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

        WebElement messagesBtn = driver.findElement(By.xpath("//a[contains(text(), 'Messages')]"));
        messagesBtn.click();
        Thread.sleep(3000);

        WebElement bookIn = driver.findElement(By.xpath("//p[text()='You have a new booking!']"));
        bookIn.click();
        Thread.sleep(3000);



        WebElement alert = wait.until(
                (ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='You have a new booking!']"))));
        Assert.assertTrue(alert.isDisplayed(), "El booking no fue enviado correctamente");

       // driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("aadmin");
        //Pasword
        WebElement passwordTxtBoxD = driver.findElement(By.id("password"));
        passwordTxtBoxD.sendKeys("password");

        //Sing in button
        WebElement submitBtnn = driver.findElement(By.id("doLogin"));
        //click summit
        submitBtnn.click();
        //esperamos
        Thread.sleep(3000);

        WebElement messagesBtnn = driver.findElement(By.xpath("//a[contains(text(), 'Messages')]"));
        messagesBtnn.click();
        Thread.sleep(3000);



    }

}