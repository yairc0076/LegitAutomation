package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;


public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[contains(text(),'Checkout')]")
    public WebElement txt_Checkout;

    @FindBy(xpath = "//input[@id='shipping-address-text']")
    public WebElement boxText_ShippingAddress;

    @FindBy(xpath = "//button[@id='checkout-button']")
    public WebElement btn_CompletedCheckout;

    // Page Methods

    public String handleProceedAlert(WebElement complete) {
        String alertText = null;
        try {
            complete.click();
            // Wait for the alert to be present
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4000)); // Adjust the timeout as needed
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alertText = alert.getText();
            alert.accept();
        } catch (UnhandledAlertException | StaleElementReferenceException e) {
            // Handle any exceptions or log the error if needed
            e.printStackTrace();
        }
        return alertText;
    }

    public void pressOKKey(WebElement elem) {
        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(2000);
            elem.click();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}