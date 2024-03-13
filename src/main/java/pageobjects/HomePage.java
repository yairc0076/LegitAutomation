package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[contains(text(),'Online Shopping Website')]")
    public WebElement txt_Title;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/ul[1]/li[1]/button[1]")
    public WebElement btn_Add1;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/ul[1]/li[2]/button[1]")
    public WebElement btn_Add2;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/ul[1]/li[3]/button[1]")
    public WebElement btn_Add3;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/ul[1]/li[4]/button[1]")
    public WebElement btn_Add4;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/ul[1]/li[5]/button[1]")
    public WebElement btn_Add5;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]")
    public WebElement txt_Product1;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[2]")
    public WebElement txt_Product2;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[3]")
    public WebElement txt_Product3;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[4]")
    public WebElement txt_Product4;

    @FindBy(xpath = "//div[1]/div[1]/div[1]/div[1]/ul[1]/li[5]")
    public WebElement txt_Product5;

    @FindBy(xpath = "//select[@id='product_id_1-product-quantity-select']")
    public WebElement select_Quantity1;

    @FindBy(xpath = "//select[@id='product_id_2-product-quantity-select']")
    public WebElement select_Quantity2;

    @FindBy(xpath = "//select[@id='product_id_3-product-quantity-select']")
    public WebElement select_Quantity3;

    @FindBy(xpath = "//select[@id='product_id_4-product-quantity-select']")
    public WebElement select_Quantity4;

    @FindBy(xpath = "//select[@id='product_id_5-product-quantity-select']")
    public WebElement select_Quantity5;

    @FindBy(xpath = "//a[contains(text(),'Home')]")
    public WebElement link_Home;

    @FindBy(xpath = "//a[contains(text(),'Shopping Cart')]")
    public WebElement link_ShoppingCart;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    public WebElement link_CheckOut;

    @FindBy(xpath = "//a[contains(text(),'Orders')]")
    public WebElement link_Orders;

    // Page Methods

    // Function to compare product price
    public boolean compareProductPrice(WebElement button, WebElement product1Title, WebElement shoppingCart, WebElement productTitleFromShopping) {
        button.click();
        String savedTitle1 = product1Title.getText();
        shoppingCart.click();
        String existingTextOnShoppingPage = productTitleFromShopping.getText();
        return existingTextOnShoppingPage.contains(savedTitle1);
    }
}