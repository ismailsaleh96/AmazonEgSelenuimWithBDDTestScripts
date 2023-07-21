package stepDefination;

import Pages.P1_LandingPage;
import Pages.P2_SignInPage;
import Gen.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


public class TC1_TestSignInCases {
    P1_LandingPage landing = new P1_LandingPage();
    P2_SignInPage signIn = new P2_SignInPage();
    Wait wait=new Wait();
    Actions action = new Actions(TestBase.driver);

    @Given("^User Navigate to Landing Page")

    public void openBrowser(String URL) {
        TestBase.driver.get(URL);
        try {
            Thread.sleep(3000);
            TestBase.driver.navigate().refresh();

            //Switich  to english Language if the site is in arabic version and skip if not
            wait.waitVisibilityOfElement(landing.siteLanguage("AR"),15);
            action.moveToElement(landing.localization()).perform();
            landing.inActiveLanguageRadio().click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @When("User Click on Hello Sign in")
    public void clickSignIn() {
        //wait for Hello sign in account & list button to be clickable then click it
        wait.waitToBeClickableElement(landing.helloSignIn(),50);
        //Sign in form header equals to Sign in
        Assert.assertEquals(signIn.signInFormHeader().getText().equals("Sign in"), true);
        //Email phone number field label equals to mail or mobile phone number
        Assert.assertEquals(signIn.emailPhoneLabel().getText().contains("Email or mobile phone number"), true);
    }

    @And("^Enter \"(.*)\" in Email field$")
    public void enterEmail(String email) {
        //Enter email in text field
        signIn.emailPhoneTextField().sendKeys(email);
    }

    @And("Click continue")
    public void clickContinue() {
        //Wait for continue button to be clickable then click it
        wait.waitToBeClickableElement(signIn.continueBTN(),15);
    }

    @Then("^Validation \"(.*)\"$")
    public void validationMessage(String validation) {

        //if validation message equals "We cannot find an account with that email address"
        //Alert is displayed with text equal "We cannot find an account with that email address"
        if (validation.equals("We cannot find an account with that email address")) {
            Assert.assertTrue(signIn.noAccFoundAlert().isDisplayed());
            Assert.assertEquals(signIn.alertMessage().getText().equals(validation), true);
        }
        //if validation message equals "Enter your email or mobile phone number"
        //validation message displayed equals to "Enter your email or mobile phone number"
        else if (validation.equals("Enter your email or mobile phone number")) {
            Assert.assertEquals(signIn.emailRequiredMessage().getText().equals(validation), true);
        }
    }

}