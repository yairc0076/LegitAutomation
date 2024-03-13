package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.*;

import static org.testng.Assert.assertFalse;
import static utilities.CommonOps.getData;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[1]/fieldset[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement txt_Email;

    @FindBy(xpath = "//div[1]/fieldset[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement txt_pass;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    public WebElement btn_SignIn;

    // Page Methods

    public void loginWithEnabledUser() {
        String user = getData("username");
        String password = getData("password");
        String URL = getData("url");

        driver.get(URL);
        txt_Email.sendKeys(user);
        txt_pass.sendKeys(password);
        btn_SignIn.click();
        sleep(1000);
    }



    // Secure Handling of Passwords Test Scenario
    public void verifySecureHandlingOfPasswords() {
        // Check console logs for sensitive information
        List<org.openqa.selenium.logging.LogEntry> logs = driver.manage().logs().get(LogType.BROWSER).getAll();
        for (LogEntry entry : logs) {
            assertFalse(entry.getMessage().toLowerCase().contains("password"), "Password should not be logged");
        }

        // Modify this assertion based on your application's authentication mechanism
        assertFalse(driver.getPageSource().contains(getData("username")), "Username should not  be part of the network requests");
    }

    public void checkLatency() {
        String url = getData("url");
        int latency = checkLatency(url);

        System.out.println("Latency: " + latency + " milliseconds");

        int threshold = 1100; // Define your threshold here (in milliseconds)
        Assert.assertTrue(latency <= threshold, "Latency is slower than the stride.");

        System.out.println("Latency is within the stride.");
    }

    private int checkLatency(String url) {
        long startTime = System.currentTimeMillis();
        driver.get(url);
        long endTime = System.currentTimeMillis();
        return (int) (endTime - startTime);
    }
}