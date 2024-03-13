package extentions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.asserts.SoftAssert;
import utilities.CommonOps;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.*;

public class Verifications extends CommonOps {

    private static SoftAssert softAssert;

    // Visibility Verifications
    @Step("Verify element is displayed")
    public static void verifyElementIsDisplayed(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isDisplayed());
    }

    @Step("Verify element is not displayed")
    public static void verifyElementIsNotDisplayed(WebElement elem) {
        assertFalse(elem.isDisplayed());
    }

    @Step("Verify element is displayed without assert")
    public static void verifyIsDisplayedElement(WebElement elem) {
        //wait.until(ExpectedConditions.visibilityOf(elem));
        Uninterruptibles.sleepUninterruptibly(Duration.ofSeconds(3));
        elem.isDisplayed();
    }

    @Step("Verify element is enabled")
    public static void verifyElementIsEnabled(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isEnabled());
    }

    @Step("Verify element is not enabled")
    public static void verifyElementIsNotEnabled(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertFalse(elem.isEnabled());
    }

    @Step("Verify element is selected")
    public static void verifyElementIsSelected(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.isSelected());
    }

    @Step("Verify element is not selected")
    public static void verifyElementIsNotSelected(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertFalse(elem.isSelected());
    }

    // Text Verifications
    @Step("Verify text in element")
    public static void verifyTextInElement(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertEquals(elem.getText(), expected);
    }

    @Step("Verify text contains in element")
    public static void verifyTextContainsInElement(WebElement elem, String string) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertTrue(elem.getText().contains(string));
    }
    @Step("Verify text contains")
    public static void verifyTextContains(String actualText, String expectedText) {
        assertTrue(actualText.contains(expectedText));
    }


    @Step("Verify text is not correct in element")
    public static void verifyTextInElementNotCorrect(WebElement elem, String expected) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        assertFalse(elem.getText().equals(expected));
    }

    // Size Verifications
    @Step("Verify the size of element/list")
    public static void verifyNumOfElements(List<WebElement> elems, int expected) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        assertEquals(elems.size(), expected);
    }

    // Soft Assertions
    @Step("Verify element displayed with soft assertions/list")
    public static void verifyVisibilityOfElements(List<WebElement> elems) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry, " + elem.getText() + " not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify img displayed with soft assertions/list")
    public static void verifyVisibilityOfImg(List<WebElement> elems) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(), "Sorry, " + elem + " not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }

    @Step("Verify element location with soft assertions/list")
    public static void verifyLocationOfElements(List<WebElement> elems, String expectedLocation) {
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size() - 1)));
        for (WebElement elem : elems) {
            softAssert.assertEquals(elem.getLocation().toString(), expectedLocation);
        }
        softAssert.assertAll("Some elements were not location correct");
    }

    // Existence and Non-Existence Verifications
    @Step("Verify element existence")
    public static void verifyExistanceOfElement(List<WebElement> elements) {
        assertTrue(elements.size() > 0);
    }

    @Step("Verify element non-existence")
    public static void verifyNonExistanceOfElement(List<WebElement> elements) {
        assertFalse(elements.size() > 0);
    }

    @Step("Verify element existence according to expected number")
    public static void verifyExistanceOfElement(List<WebElement> elements, int expectedNumber) {
        assertTrue(elements.size() == expectedNumber);
    }

    // Location Verification
    @Step("Verify element location")
    public static void verifyLocation(WebElement elem, String expectedLocation) {
        String actualLocation = elem.getLocation().toString();
        softAssert.assertEquals(actualLocation, expectedLocation);
        softAssert.assertAll();
    }
}