
package ui.pages;

import org.openqa.selenium.By;

public class HomePage {
    // Navbar links

    public By roomsLink = By.cssSelector("a.nav-link[href='/#rooms']");
    public By bookingLink = By.cssSelector("a.nav-link[href='/#booking']");
    public By amenitiesLink = By.cssSelector("a.nav-link[href='/#amenities']");
    public By locationLink = By.cssSelector("a.nav-link[href='/#location']");
    public By contactLink = By.cssSelector("a.nav-link[href='/#contact']");
    public By adminLink = By.cssSelector("a.nav-link[href='/admin']");

    // Hamburger menu (para dispositivos móviles o para usar como Home)
    public By hamburgerMenu = By.cssSelector(".navbar-toggler");

    // Check Availability
    public By checkAvailabilityButton = By.xpath("//button[text()='Check Availability']");



    public By checkinInput = By.id("checkin");   // campo de check-in
    public By checkoutInput = By.id("checkout"); // campo de check-out
    public By dateInputs = By.cssSelector(".react-datepicker__input-container .form-control");


    // Lista de habitaciones disponibles
    public By availableRooms = By.cssSelector(".room-card");
}
