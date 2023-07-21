package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefination.TestBase;

public class P2_SignInPage {
    public WebElement signInForm(){
        return TestBase.driver.findElement(By.id("authportal-main-section"));
    }
    public WebElement amazonLogo() {
        return TestBase.driver.findElement(By.xpath("//i[@class='a-icon a-icon-logo']"));
    }

    public WebElement signInFormHeader() {
        return TestBase.driver.findElement(By.className("a-spacing-small"));
    }

    public WebElement emailPhoneLabel() {
        return TestBase.driver.findElement(By.className("a-form-label"));
    }

    public WebElement emailPhoneTextField() {
        return TestBase.driver.findElement(By.id("ap_email"));
    }

    public WebElement continueBTN() {
        return TestBase.driver.findElement(By.className("a-button-input"));
    }

    public WebElement noAccFoundAlert() {
        return TestBase.driver.findElement(By.xpath("//div[@class='a-box-inner a-alert-container']"));
    }

    public WebElement alertMessage() {
        return TestBase.driver.findElement(By.className("a-list-item"));

    }

    public WebElement emailRequiredMessage() {
        return TestBase.driver.findElement(By.xpath("//div[text()[normalize-space()='Enter your email or mobile phone number']]"));


    }


}
