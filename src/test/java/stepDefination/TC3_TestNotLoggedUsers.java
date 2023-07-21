package stepDefination;

import Pages.P1_LandingPage;
import Pages.P2_SignInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class TC3_TestNotLoggedUsers {
    P1_LandingPage landing = new P1_LandingPage();
    P2_SignInPage signIn = new P2_SignInPage();


    @When("user hover over Hello,sign in Account & Lists in the top right corner")
    public void helloSignInHover() {
        //Hover over Hello,sign in Account & Lists
        Actions action = new Actions(TestBase.driver);
        action.moveToElement(landing.helloSignIn()).perform();
    }

    @And("^Click on \"(.*)\"$")
    public void clickPage(String pageName) {
        //Click on page under Hello,sign in Account & Lists
        landing.helloSubPage(pageName).click();
    }

    @Then("Sign in form displayed")
    public void SignInFormDisplayed() {
        //Sign in form is displayed
        Assert.assertTrue(signIn.signInForm().isDisplayed());
    }

    @Then("Lists screen are displayed with different benefits")
    public void listPagesDisplayed() {
        //page header equals to "Lists"
        Assert.assertEquals(landing.listsHeader().getText().contains("Lists"),true);

        //page sub header equals to "for all your shopping needs"
        Assert.assertEquals(landing.listsSubHeader().getText().contains("for all your shopping needs"),true);

        // page header, sub header and benefit card are displayed
        Assert.assertTrue(landing.listsHeader().isDisplayed());
        Assert.assertTrue(landing.listsSubHeader().isDisplayed());
        Assert.assertTrue(landing.benefitsCard().isDisplayed());
    }

}