
package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestContext {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;

    }
    @BeforeEach
    public static void setup() {
        System.out.println("Comes first here to setup method in TestContext class");
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        System.out.println("Creates new driver instance");

    }

    @AfterEach
    public static void teardown() {
        System.out.println("Comes last here to teardown method in TestContext class");
        driver.quit();
    }
}


