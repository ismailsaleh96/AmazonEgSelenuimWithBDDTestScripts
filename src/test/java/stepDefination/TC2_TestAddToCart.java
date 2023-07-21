package stepDefination;

import Pages.P1_LandingPage;
import Pages.P3_ProductProcessPage;
import Pages.P4_CartPage;
import Gen.Wait;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC2_TestAddToCart {
    static String  productTitle = null;
    static double productPrice = 0;
    static double productFractionPrice = 0;
    P1_LandingPage landing = new P1_LandingPage();
    P3_ProductProcessPage products = new P3_ProductProcessPage();
    P4_CartPage cart = new P4_CartPage();
    Wait wait = new Wait();

    @When("User Click on All hamburger menu and Select Today's deal")
    public void selectTodayDeal() {
        //Click on hamburger menu icon
        landing.allThreeDashesMenu().click();
        //Click on Today's deal under hamburger menu
        products.todayDeal().click();
    }

    @And("Click first product under second category")
    public void selectFirstProduct() {
        //Click on second category
        products.secondCategory().click();
        //Click on first product under second category
        products.firstProduct().click();
    }

    @And("Click second item if visible & Select Regular price radio")
    public void selectRegularPrice() {
        //wait for second item to be visible as sometime product doesn't have items under it
        try {
            wait.waitToBeClickableElement(products.secondItem(),15);
            //wait.until(ExpectedConditions.visibilityOf(products.secondItem())).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //set product title
        productTitle = products.productTitle().getText();
        //click on regular price radio button
        products.regularPriceRadio().click();
        //locate item price
        productPrice = Double.parseDouble(products.regularProductPrice().getText()) ;
        System.out.println(productPrice);
        //locate fraction price then divide by 100
        productFractionPrice = Double.parseDouble(products.regularProductFractionPrice().getText());
        System.out.println(productFractionPrice);

    }

    @And("Select Quantity if displayed & Add to cart")
    public void addSecondToCart() {
        //Wait for QTY dropdown to be visible as it's sometime isn't visible
        try {
            wait.waitVisibilityOfElement(products.quantityDropdown(),15);
            // wait.until(ExpectedConditions.visibilityOf(products.quantityDropdown()));
            Select selectQuantity = new Select(products.quantityDropdown());
            selectQuantity.selectByVisibleText("2");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //click on add to cart button
        products.addToCartBTN().click();

    }

    @And("discard extended warranty if displayed")
    public void discardExtendedWarranty() {
        try {
            wait.waitVisibilityOfElement(products.extendedWarrantyDiscard(),15);

            //wait.until(ExpectedConditions.visibilityOf(products.extendedWarrantyDiscard())).click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Then("Item is presented in cart with correct name, price, price and subtotal")
    public void itemAddedCorrectly() {
        //define price equals to product price + product fraction price
        double price = productPrice + (productFractionPrice/100);
        //click on cart icon
        products.cart().click();
        //to handle if the product quantity drop down isn't visible while checking out

        // condition will be skipped if QTY of the Product  is already set to 2
        try {
            if (cart.cartItemQuantity().getText().equals("1")) {
                Select selectQuantity = new Select(cart.cartQTYDropdown());
                selectQuantity.selectByVisibleText("2");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        //Check cart count is equal to 2 as the QTY is 2
        Assert.assertEquals(products.cartCount().getText().equals("2"), true);

        //Check item quantity equals to 2
        Assert.assertEquals(cart.cartQTYDropdown().getText().equals("2"), true);
        //Check product title in product details page equals to product title in cart page
        Assert.assertEquals(cart.productCartTitle().getText().contains(productTitle), true);

        //Check product price in product details page equals to product price in cart page
        Assert.assertEquals(cart.cartProductPrice().getText().equals(String.format("EGP %,.2f",price)), true);

        Assert.assertEquals(cart.subTotalPrice().getText().equals(String.format("EGP %,.2f",(2 * price))), true);
    }
}