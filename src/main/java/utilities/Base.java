package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageobjects.*;

public class Base {
    protected static WebDriver driver;
    protected static WebDriverWait wait;
    protected static Actions action;
    protected static SoftAssert softassert;

    // Page Objects
    protected static LoginPage loginPage;
    protected static CheckoutPage checkoutPage;
    protected static HomePage homePage;
    protected static OrdersPage ordersPage;
    protected static ShoppingCartPage shoppingCartPage;
}