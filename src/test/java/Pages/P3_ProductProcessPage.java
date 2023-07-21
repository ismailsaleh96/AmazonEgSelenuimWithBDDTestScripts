package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefination.TestBase;

public class P3_ProductProcessPage {
    public WebElement todayDeal() {
        return TestBase.driver.findElement(By.xpath("//a[@href='/-/en/gp/goldbox/?ref_=nav_em_navm_deals_0_1_1_24']"));
    }

    public WebElement secondCategory() {

        return TestBase.driver.findElement(By.xpath("//img[@src='https://m.media-amazon.com/images/G/42/Sunrise/Events/2023/EID23/Icons/XCM_Manual_1560385_5495145_315x315_2X.jpg']"));
    }

    public WebElement firstProduct() {
        return TestBase.driver.findElement(By.xpath("//div[@class='DealCardDynamic-module__cardImageVertical_1IizpyChuPf_yh4IHtuaWk'] "));
    }

    public WebElement secondItem() {
        return TestBase.driver.findElement(By.xpath("(//div[@class='a-section octopus-dlp-image-shield'])[2]"));
    }

    public WebElement regularPriceRadio() {
        return TestBase.driver.findElement(By.xpath("(//i[contains(@class,'a-icon a-accordion-radio')])[2]"));
    }

    public WebElement quantityDropdown() {
        return TestBase.driver.findElement(By.id("quantity"));
    }

    public WebElement addToCartBTN() {
        return TestBase.driver.findElement(By.id("add-to-cart-button"));
    }

    public WebElement productTitle() {
        return TestBase.driver.findElement(By.id("productTitle"));
    }

    public WebElement regularProductPrice() {
       return TestBase.driver.findElement(By.xpath("//div[@id='apex_desktop_newAccordionRow']/div[3]/div[1]/span[1]/span[2]/span[2]"));
    }
    public WebElement regularProductFractionPrice() {
        return TestBase.driver.findElement(By.xpath("//div[@id='apex_desktop_newAccordionRow']/div[3]/div[1]/span[1]/span[2]/span[3]"));
    }


    public WebElement cart() {
        return TestBase.driver.findElement(By.id("nav-cart"));
    }

    public WebElement cartCount() {
        return TestBase.driver.findElement(By.id("nav-cart-count"));
    }

    public WebElement extendedWarrantyDiscard() {
        return TestBase.driver.findElement(By.cssSelector("span#attachSiNoCoverage>span>input"));
    }

}
