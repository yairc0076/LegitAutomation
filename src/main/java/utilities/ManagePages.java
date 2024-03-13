package utilities;

import org.openqa.selenium.support.PageFactory;
import pageobjects.*;

public class ManagePages extends Base {

    public static void Legit() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        shoppingCartPage = PageFactory.initElements(driver, ShoppingCartPage.class);
        ordersPage = PageFactory.initElements(driver, OrdersPage.class);
        homePage = PageFactory.initElements(driver, HomePage.class);
        checkoutPage = PageFactory.initElements(driver, CheckoutPage.class);
    }
}