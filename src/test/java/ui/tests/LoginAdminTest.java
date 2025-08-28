package ui.tests;

import org.testng.annotations.Test;
import ui.base.BaseUITest;
import ui.pages.LoginPage;

public class LoginAdminTest extends BaseUITest {

    @Test
    public void loginWithValidCredentials() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.goToLoginPage();
        loginPage.enterUsername("admin");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        Thread.sleep(3000); // luego lo cambiao por un waits
    }
}
