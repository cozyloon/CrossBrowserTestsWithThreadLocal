package util;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;


public class BaseTest {
    protected static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();
    public SoftAssert softAssert;

    @BeforeMethod
    @Parameters("browser")
    public void setup(final String browser) {
        this.softAssert = new SoftAssert();
        if (browser.equalsIgnoreCase("CHROME")) {
            DRIVER.set(new ChromeDriver());
        } else if (browser.equalsIgnoreCase("EDGE")) {
            DRIVER.set(new EdgeDriver());
        } else if (browser.equalsIgnoreCase("FIREFOX")) {
            DRIVER.set(new FirefoxDriver());
        } else if (browser.equalsIgnoreCase("SAFARI")) {
            DRIVER.set(new SafariDriver());
        } else {
            throw new Error("Browser name is not specified correctly. It should be either chrome, firefox, edge or safari!!");
        }
    }

    @AfterMethod
    public void tearDown() {
        DRIVER.get().quit();
    }
}
