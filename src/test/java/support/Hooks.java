package support;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static support.TestContext.getDriver;



public class Hooks {

    @Before
    public void scenarioStart() {
        System.out.println("Inside Hook class- run before scenario");
        TestContext.setup();
        getDriver().manage().deleteAllCookies();
    }

    @After
    public void scenarioEnd(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Executed after scenario");
            TakesScreenshot screenshotTaker = (TakesScreenshot) getDriver();
            byte[] screenshot = screenshotTaker.getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Screenshot");
        }
        TestContext.teardown();
    }
}
