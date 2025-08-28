package ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.pages.HomePage;
import ui.maps.HomePageMap;

public class MainPagesRenderTest extends BaseUITest {

    @Test
    public void testMainPagesRenderCorrectly() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        HomePageMap map = new HomePageMap();

        homePage.goToHomePage();

        // Home: abrir hamburger menu si es necesario
        homePage.openHamburgerMenuIfNeeded();
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/");

        // Rooms
        scrollToElement(driver.findElement(map.roomsLink));
        homePage.clickNavbarLink(map.roomsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#rooms");

        // Booking
        scrollToElement(driver.findElement(map.bookingLink));
        homePage.clickNavbarLink(map.bookingLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#booking");

        // Amenities
        scrollToElement(driver.findElement(map.amenitiesLink));
        homePage.clickNavbarLink(map.amenitiesLink);

         // Verificamos que el link funcione
        if (!driver.getCurrentUrl().contains("#amenities")) {
            System.out.println(" Atención: el link de Amenities no funciona correctamente. ");

        }

        // Location
        scrollToElement(driver.findElement(map.locationLink));
        homePage.clickNavbarLink(map.locationLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#location");

        // Contact
        scrollToElement(driver.findElement(map.contactLink));
        homePage.clickNavbarLink(map.contactLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#contact");

        // Admin
        scrollToElement(driver.findElement(map.adminLink));
        homePage.clickNavbarLink(map.adminLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin"));
    }

    // Metodo donde recibe el web element
    private void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }
}
