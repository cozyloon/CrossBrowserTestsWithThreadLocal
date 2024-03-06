package tests;

import org.testng.annotations.Test;
import page.LoginPage;
import util.BaseTest;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class CrossBrowserTestsWithThreadLocal extends BaseTest {
    @Test
    void testLoginPage() {
        DRIVER.get().navigate().to("https://the-internet.herokuapp.com/login");
        final var loginPage = new LoginPage(DRIVER.get());
        assertEquals(loginPage.pageHeader(), "Login Page");

        final var secureAreaPage = loginPage.performLogin("tomsmith", "SuperSecretPassword!");
        assertTrue(secureAreaPage.isLogoutBtnDisplayed());
    }

}
