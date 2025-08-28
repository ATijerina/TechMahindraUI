package ui.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.pages.HomePage;
import ui.maps.HomePageMap;

public class NavbarLinksNavigationTest extends BaseUITest {

    @Test
    public void testNavbarLinks() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        HomePageMap map = new HomePageMap();

        homePage.goToHomePage();

        // Rooms
        homePage.clickNavbarLink(map.roomsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#rooms");

        // Booking
        homePage.clickNavbarLink(map.bookingLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#booking");

        // Amenities
        homePage.clickNavbarLink(map.amenitiesLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("#amenities"));

        // Location
        homePage.clickNavbarLink(map.locationLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#location");

        // Contact
        homePage.clickNavbarLink(map.contactLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#contact");

        // Admin
        homePage.clickNavbarLink(map.adminLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin"));
    }
}


