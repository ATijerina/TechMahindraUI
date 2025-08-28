package ui.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.maps.HomeMaps;

public class CheckInCheckOutTest extends BaseUITest {

    @Test
    public void testCheckAvailabilityWithDates() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        HomeMaps homeMaps = new HomeMaps(driver);

        homeMaps.goToHomePage();
        homeMaps.clickNavbarBooking();

        // Me traigo mi metodo de HomePage
        homeMaps.setCheckInAndCheckOut("17/08/2025", "20/08/2025");

        homeMaps.clickCheckAvailability();

        // Validamos que aparezcan habitaciones
        Assert.assertTrue(homeMaps.getAvailableRooms().size() > 0);

        driver.quit();
    }
}