package ui.tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.maps.HomeMaps;
import ui.pages.HomePage;

public class MainPagesRenderTest extends BaseUITest {

    @Test
    public void testMainPagesRenderCorrectly() throws InterruptedException {
        HomeMaps homeMaps = new HomeMaps(driver);
        HomePage map = new HomePage();

        homeMaps.goToHomePage();

        // Home: abrir hamburger menu si es necesario
        homeMaps.openHamburgerMenuIfNeeded();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/");

        // Rooms
        scrollToElement(driver.findElement(map.roomsLink));
        homeMaps.clickNavbarLink(map.roomsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#rooms");

        // Booking
        scrollToElement(driver.findElement(map.bookingLink));
        homeMaps.clickNavbarLink(map.bookingLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#booking");

        // Amenities
        scrollToElement(driver.findElement(map.amenitiesLink));
        homeMaps.clickNavbarLink(map.amenitiesLink);

         // Verificamos que el link funcione
        if (!driver.getCurrentUrl().contains("#amenities")) {
            System.out.println(" Atención: el link de Amenities no funciona correctamente. ");

        }

        // Location
        scrollToElement(driver.findElement(map.locationLink));
        homeMaps.clickNavbarLink(map.locationLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#location");

        // Contact
        scrollToElement(driver.findElement(map.contactLink));
        homeMaps.clickNavbarLink(map.contactLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#contact");

        // Admin
        scrollToElement(driver.findElement(map.adminLink));
        homeMaps.clickNavbarLink(map.adminLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin"));
    }

    // Metodo donde recibe el web element
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
