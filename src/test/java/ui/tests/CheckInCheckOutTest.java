package ui.tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.pages.HomePage;

import java.util.List;

public class CheckInCheckOutTest extends BaseUITest {

    @Test
    public void testCheckAvailabilityWithDates() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        HomePage homePage = new HomePage(driver);

        homePage.goToHomePage();
        homePage.clickNavbarBooking();

        // Me traigo mi metodo de HomePage
        homePage.setCheckInAndCheckOut("20/08/2025", "27/08/2025");

        homePage.clickCheckAvailability();

        // Validamos que aparezcan habitaciones
        Assert.assertTrue(homePage.getAvailableRooms().size() > 0);

        driver.quit();
    }
}