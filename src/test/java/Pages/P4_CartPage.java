package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import stepDefination.TestBase;

public class P4_CartPage {
    public WebElement productCartTitle() {
        return TestBase.driver.findElement(By.xpath("//div[@class='sc-item-content-group']//ul[1]"));
    }

    public WebElement cartProductPrice() {
         return TestBase.driver.findElement(By.cssSelector("form#activeCartViewForm>div:nth-of-type(2)>div:nth-of-type(3)>div:nth-of-type(4)>div>div:nth-of-type(2)>ul>div>p>span"));
    }

    public WebElement subTotalItem() {
        return TestBase.driver.findElement(By.cssSelector("span#sc-subtotal-amount-activecart>span"));
    }

    public WebElement subTotalPrice() {
        return TestBase.driver.findElement(By.cssSelector("span#sc-subtotal-amount-buybox>span"));
    }

    public WebElement cartItemQuantity() {
        return TestBase.driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
    }

    public WebElement cartQTYDropdown() {
        return TestBase.driver.findElement(By.xpath("//span[@class='a-dropdown-prompt']"));
    }

}
