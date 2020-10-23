package StepDefinitions;

import Pages.DialogContent;
import Utilities.Driver;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.List;
import java.util.Set;
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

    @Given("^Click on the element in the Dialog Content class$")
    public void clickOnTheElementInTheDialogContentClass(DataTable elements) {
        List<String> elementsTo = elements.asList(String.class);

        for (int i = 0; i < elementsTo.size(); i++) {

            System.out.println(elementsTo.get(i));
            dialogContent.findElementAndClickFunction(elementsTo.get(i++));
            dialogContent.beklet(1000);
            Set<String> sayfaidleri = driver.getWindowHandles();
            //Sonrasında açılan pencerenin URL'indeki "facebook" kelimesini doğrulayınız
            String anasayfaidsi = driver.getWindowHandle();
            for (String s : sayfaidleri) {
                if (!s.equals(anasayfaidsi))
                    driver.switchTo().window(s);
            }
            String acilansayfaidsi = driver.getCurrentUrl();
            System.out.println("acilansayfaidsi= " + acilansayfaidsi);
            Assert.assertTrue(acilansayfaidsi.toLowerCase().contains(elementsTo.get(i).toLowerCase()));
            driver.switchTo().window(anasayfaidsi);
            acilansayfaidsi = driver.getCurrentUrl();
            System.out.println(acilansayfaidsi);


        }

    }



    @Given("^Navigate to Dresses$")
    public void navigateToDresses() {
        dialogContent.findElementAndClickFunction("dresses");
    }

    @And("^Add an item to the cart$")
    public void addAnItemToTheCart() {
        dialogContent.findElementAndClickFunction("printedDressAddToCart");
        dialogContent.findElementAndClickFunction("addToCart");
        dialogContent.findElementAndVerifyContainsText("successProductAdd","your cart");
    }

    @When("^Empty the items in the cart$")
    public void emptyTheItemsInTheCart() {
        dialogContent.findElementAndClickFunction("proceedToCheckout");
        dialogContent.findElementAndClickFunction("deleteIcon");


    }

    @And("^Verify cart is empty$")
    public void verifyCartIsEmpty() {

        dialogContent.findElementAndVerifyContainsText("cart","empty");

    }
}
