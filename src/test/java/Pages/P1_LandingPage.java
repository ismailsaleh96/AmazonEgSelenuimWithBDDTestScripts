package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefination.TestBase;

public class P1_LandingPage {
    public WebElement helloSignIn() {
        return TestBase.driver.findElement(By.id("nav-link-accountList"));
    }

    public WebElement signIN() {
        return TestBase.driver.findElement(By.xpath("//span[text()='Sign in']"));

    }


    public WebElement siteLanguage(String language) {
        return TestBase.driver.findElement(By.xpath("//div[text()=\""+language+"\"]"));
    }



    public WebElement localization() {
        return TestBase.driver.findElement(By.className("icp-nav-link-inner"));

    }


    public WebElement inActiveLanguageRadio() {
        return TestBase.driver.findElement(By.xpath("//i[@class='icp-radio']"));
    }

    public WebElement allThreeDashesMenu() {
        return TestBase.driver.findElement(By.id("nav-hamburger-menu"));
    }

    public WebElement helloSubPage(String pageName) {
        return TestBase.driver.findElement(By.xpath("//span[text()=\"" + pageName + "\"]"));
    }

    public WebElement listsHeader() {

        return TestBase.driver.findElement(By.className("al-intro-banner-header"));
    }

    public WebElement listsSubHeader() {
        return TestBase.driver.findElement(By.className("al-intro-banner-subheader"));
    }

    public WebElement benefitsCard() {
        return TestBase.driver.findElement(By.id("al-intro-benefits"));

    }


}
