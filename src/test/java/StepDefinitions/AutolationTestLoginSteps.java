package StepDefinitions;

import Pages.DialogContent;
import Utilities.Driver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

/**
 * @Author:Otosun Tarih :09/10/2020
 */


public class AutolationTestLoginSteps {
    WebDriver driver;
    DialogContent dialogContent = new DialogContent();

    @Given("^Navigate to automationpractice$")
    public void navigateToAutomationpractice() {
        driver = Driver.getDriver();
        driver.get("http://automationpractice.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @When("^Enter username and password,  click Login button$")
    public void enterUsernameAndPasswordClickLoginButton() {

        dialogContent.findElementAndClickFunction("sigIn");
        dialogContent.findElementAndSendKeysFunction("email", "hasan.sahan@gmail.com");
        dialogContent.findElementAndSendKeysFunction("password", "grup246");
        dialogContent.findElementAndClickFunction("loginButton");

    }

    @Then("^User should  login successfully$")
    public void userShouldLoginSuccessfully() {


    }

    @Given("^Navigate to Contact us$")
    public void navigateToContactUs() {
        dialogContent.findElementAndClickFunction("contactUs");

    }

    @When("^Send mesage$")
    public void sendMesage() {
        dialogContent.findElementAndClickFunction("sendMesageButton");

    }

    @Then("^Error message shuld be diplayed$")
    public void errorMessageShuldBeDiplayed() {
        dialogContent.findElementAndVerifyContainsText("mesageAlert", "message cannot");

    }

    @And("^Send mesage successfull$")
    public void sendMesageSuccessfull() {
        dialogContent.findElementAndVerifyContainsText("successMessage", "successfull");
    }

    @Then("^Fill in the message \"([^\"]*)\"$")
    public void fillInTheMessage(String arg0) {
        dialogContent.findElementAndSendKeysFunction("mesageArea", arg0);
    }

    @When("^Select message \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
    public void selectMessageAndAnd(String arg0, String arg1, String arg2) {
        dialogContent.findElementAndSelectMenu("mesageHeading", arg0);
        dialogContent.findElementAndSelectMenu("orderReference", arg1);
        if (!arg1.equals("0"))
            dialogContent.findElementAndSelectMenu("pruduct", arg2);
    }
}
