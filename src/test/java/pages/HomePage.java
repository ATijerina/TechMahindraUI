
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    private WebDriver driver;

    // Locators
    private By roomsLink = By.cssSelector("a.nav-link[href='/#rooms']");
    private By bookingLink = By.cssSelector("a.nav-link[href='/#booking']");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // ----- Métodos de acción -----
    public void clickRooms() {
        driver.findElement(roomsLink).click();
    }

    public void clickBooking() {
        driver.findElement(bookingLink).click();
    }

    // ----- Getters de elementos -----
    public WebElement getRoomsLink() {
        return driver.findElement(roomsLink);
    }

    public WebElement getBookingLink() {
        return driver.findElement(bookingLink);
    }
}

