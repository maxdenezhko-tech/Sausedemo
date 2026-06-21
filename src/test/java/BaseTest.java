import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void setUP() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("start-maximized");
        options.addArguments("--headless");
        driver = new FirefoxDriver(options);
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void close() {
        driver.quit();
    }
}
