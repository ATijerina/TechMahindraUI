package ui.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.maps.HomeMaps;

import java.util.List;
import org.openqa.selenium.WebElement;

public class AvailabilityTest extends BaseUITest {

    @Test
    public void testRoomsDisplayed() throws InterruptedException {
        HomeMaps homeMaps = new HomeMaps(driver);
        homeMaps.goToHomePage();

        // Ir a Booking
        homeMaps.clickNavbarBooking();

        // Click en Check Availability
        homeMaps.clickCheckAvailability();

        // Obtener habitaciones disponibles
        List<WebElement> rooms = homeMaps.getAvailableRooms();

        // Verificar que haya habitaciones
        Assert.assertFalse(rooms.isEmpty(), "No hay habitaciones disponibles");
    }
}
