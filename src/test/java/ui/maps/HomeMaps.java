package ui.maps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeMaps {
    private WebDriver driver;
    private WebDriverWait wait;
    private ui.pages.HomePage map;

    public HomeMaps(WebDriver driver) {
        this.driver = driver;
        this.map = new ui.pages.HomePage();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void goToHomePage() {
        driver.get("https://automationintesting.online/");
    }

    public void openHamburgerMenuIfNeeded() throws InterruptedException {
        try {
            WebElement menuButton = driver.findElement(map.hamburgerMenu);
            if (menuButton.isDisplayed()) {
                menuButton.click();
                Thread.sleep(500);
            }
        } catch (Exception ignored) {}
    }

    public void clickNavbarBooking() throws InterruptedException {
        openHamburgerMenuIfNeeded();
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(map.bookingLink));
        link.click();
        Thread.sleep(500);
    }

    // Méetodos para mis links del navbar
    public void clickNavbarLink(By linkLocator) throws InterruptedException {
        openHamburgerMenuIfNeeded();
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(linkLocator));
        link.click();
        Thread.sleep(500);
    }

    // Check Availability
    public void clickCheckAvailability() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(map.checkAvailabilityButton));
        button.click();

    }

    public List<WebElement> getAvailableRooms() {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(map.availableRooms));
    }

//    //  Getter para HomePageMap, metodo de acceso
//    public ui.pages.HomePage getMap() {
//        return map;
//    }

    public void setCheckInAndCheckOut(String checkInDate, String checkOutDate) {
        List<WebElement> inputs = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(map.dateInputs)
        );

        WebElement checkin = inputs.get(0);
        WebElement checkout = inputs.get(1);

        checkin.clear();
        checkout.clear();

        checkin.sendKeys(checkInDate);
        checkout.sendKeys(checkOutDate);
    }
}
