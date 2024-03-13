package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class OrdersPage extends BasePage {
    public OrdersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='amplify-id-:rd:']")
    public WebElement txt_Email;

    @FindBy(xpath = "//input[@id='amplify-id-:rg:']")
    public WebElement txt_pass;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement btn_SignIn;

    // Methods for OrdersPage class

    public String getTextFromOrdersPage() {

        return "";
    }

    // Add the following method to extract the order ID from the page
    public String extractOrderIDFromPage() {

        String pageText = getTextFromOrdersPage();
        return extractOrderIDFromText(pageText);
    }

    private String extractOrderIDFromText(String pageText) {
        return pageText;
    }
}