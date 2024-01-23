package definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import static support.TestContext.getDriver;


public class LoginPage {
    @Given("user open url {string}")
    public void iOpenUrl(String url) {
        System.out.println("launches the url");
        getDriver().get(url);

    }

    @When("user enter username {string} in username field")
    public void enterUsername(String username){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        System.out.println("sends the valid username");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name = 'username']"))).sendKeys(username);


    }

    @And("user enters password {string} in the password field")
    public void enterPassword(String password){

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name = 'password']"))).sendKeys(password);

    }

    @And("user clicks {string} button")
    public void clickButton(String button){

        getDriver().findElement(By.xpath("//button[text() = ' Login ']")).click();
    }

    @Then("user is redirected to Dashboard")
    public void verifyUserRedirectedToDashboard(){

        String title = getDriver().getTitle();
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        By dash = By.xpath("//h6[text()='Dashboard']");
        wait.until(ExpectedConditions.presenceOfElementLocated(dash));
        WebElement dashboard = getDriver().findElement(dash);

        assertTrue(dashboard.isDisplayed());
        assertEquals("OrangeHRM",title);
    }

    @Then("error message {string} is displayed")
    public void errorMessageIsDisplayed(String errorMessage){

        System.out.println("entered error message method");
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        By message = By.xpath("//p[text()='Invalid credentials']");
        //By message = By.xpath("//p[text()='Invalid credentials']");
        wait.until(ExpectedConditions.presenceOfElementLocated(message));
        WebElement expectedErrorMessage = getDriver().findElement(message);
        System.out.println("assertions happens here");
        assertTrue(expectedErrorMessage.isDisplayed());




    }

}
