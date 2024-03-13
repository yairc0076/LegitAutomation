package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



public class ShoppingCartPage extends BasePage {
    @FindBy(xpath = "//h2[contains(text(),'Shopping Cart')]")
    public WebElement txt_ShoppingCart;

    @FindBy(xpath = "//button[@id='remove-product_id_1-product']")
    public WebElement btn_Remove;

    @FindBy(xpath = "//div[@id='root']/div[1]/div[1]/div[1]/ul[1]/li[1]")
    public WebElement link_Product1;

    @FindBy(xpath = "//div[@id='root']/div[1]/div[1]/div[1]/ul[1]/li[2]")
    public WebElement link_Product2;

    @FindBy(xpath = "//button[contains(text(),'Proceed to Checkout')]")
    public WebElement btn_Proceed;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInvalidAddressIndicatorVisible() {
        return false;
    }
}