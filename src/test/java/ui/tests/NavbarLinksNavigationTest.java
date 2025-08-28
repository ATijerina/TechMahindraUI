package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.maps.HomeMaps;
import ui.pages.HomePage;

public class NavbarLinksNavigationTest extends BaseUITest {

    @Test
    public void testNavbarLinks() throws InterruptedException {
        HomeMaps homeMaps = new HomeMaps(driver);
        HomePage map = new HomePage();

        homeMaps.goToHomePage();

        // Rooms
        homeMaps.clickNavbarLink(map.roomsLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#rooms");

        // Booking
        homeMaps.clickNavbarLink(map.bookingLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#booking");

        // Amenities
        homeMaps.clickNavbarLink(map.amenitiesLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("#amenities"));

        // Location
        homeMaps.clickNavbarLink(map.locationLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#location");

        // Contact
        homeMaps.clickNavbarLink(map.contactLink);
        Assert.assertEquals(driver.getCurrentUrl(), "https://automationintesting.online/#contact");

        // Admin
        homeMaps.clickNavbarLink(map.adminLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin"));
    }
}


