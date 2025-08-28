package ui.tests;

import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.maps.LoginMaps;

public class LoginAdminTest extends BaseUITest {

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        LoginMaps loginMaps = new LoginMaps(driver);

        loginMaps.goToLoginPage();
        loginMaps.enterUsername("admin");
        loginMaps.enterPassword("password");
        loginMaps.clickLogin();

        Thread.sleep(3000); // luego lo cambiao por un waits
    }
}
