package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.pages.HomePage;

import java.util.List;
import org.openqa.selenium.WebElement;

public class AvailabilityTest extends BaseUITest {

    @Test
    public void testRoomsDisplayed() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.goToHomePage();

        // Ir a Booking
        homePage.clickNavbarBooking();

        // Click en Check Availability
        homePage.clickCheckAvailability();

        // Obtener habitaciones disponibles
        List<WebElement> rooms = homePage.getAvailableRooms();

        // Verificar que haya habitaciones
        Assert.assertFalse(rooms.isEmpty(), "No hay habitaciones disponibles");
    }
}
