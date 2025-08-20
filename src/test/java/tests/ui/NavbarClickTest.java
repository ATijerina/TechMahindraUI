package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import tests.base.BaseUITest;



import java.time.Duration;

public class NavbarClickTest extends BaseUITest {

    public void openMenu() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement menuButton = driver.findElement(By.cssSelector(".navbar-toggler"));
        menuButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online");
    }



    @Test
    public void testRoomsLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement roomsLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#rooms']"))
        );
        roomsLink.click();
        //Lo puse solo para que observemos que se da click
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#rooms");
    }

    @Test
    public void testBookingLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement bookingLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#booking']"))
        );
        bookingLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#booking");
    }

    @Test
    public void testAmenitiesLink() throws InterruptedException { //recordemos que amenities no me arroja menu

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement amenitiesLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#amenities']"))
        );
        amenitiesLink.click();
        Thread.sleep(1000);
        Assert.assertTrue(driver.getCurrentUrl().contains("#amenities"),
                "El link de Amenities debería llevar a la sección #amenities");
    }

    @Test
    public void testLocationLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement locationLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#location']"))
        );
        locationLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#location");
    }

    @Test
    public void testContactLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement contactLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/#contact']"))
        );
        contactLink.click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#contact");
    }

    @Test
    public void testAdminLink() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement adminLink = wait.until(
                ExpectedConditions.elementToBeClickable(By.cssSelector("a.nav-link[href='/admin']"))
        );
        adminLink.click();
    }
}






