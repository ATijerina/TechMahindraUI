

package tests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import tests.base.BaseUITest;

import java.time.Duration;
import java.util.List;


public class SelectSuiteRoom extends BaseUITest {

    @Test
    public void verifySuiteFeatures() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://automationintesting.online/#booking");
        //Buscar y mapper los elementos
        //Button suite room

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement bookbutton = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Book now']"))
        );

        List<WebElement> rooms = driver.findElements(By.xpath("//a[text()='Book now']"));
        WebElement suiteRoom = rooms.get(2); // índice 2 → tercer elemento (Suite Room)



        Actions actions = new Actions(driver);
        actions.moveToElement(suiteRoom);
        actions.perform();

        suiteRoom.click();

        driver.quit();
        }

    }



