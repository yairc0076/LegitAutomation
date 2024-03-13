package pageobjects;


import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Random;


abstract class BasePage {
    WebDriver driver;
    JavascriptExecutor js;
    Actions actions;
    WebDriverWait wait;
    public String mainWindow;

    BasePage(WebDriver driver) {
        this.driver = driver;
        js = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // General Actions
    @Step("Click on element")
    public void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    @Step("Send keys text")
    public void updateText(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }


    @Step("Select option from dropdown by text")
    public void updateDropDown(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Clear text")
    public void clear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.clear();
    }

    // Mouse Actions
    @Step("Mouse over between two elements")
    public void mouseOver(WebElement elem1, WebElement elem2) {
        wait.until(ExpectedConditions.visibilityOf(elem1));
        actions.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    @Step("Double click on element")
    public void doubleClick(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        actions.doubleClick(elem).build().perform();
    }

    @Step("Double click on element and clear")
    public void doubleClickAndClear(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        actions.doubleClick(elem).build().perform();
        elem.sendKeys(Keys.BACK_SPACE);
    }

    @Step("Right click on element")
    public void rightClick(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        actions.doubleClick(elem).build().perform();
    }

    // Drag and Drop
    @Step("Drag and drop")
    public void dragDrop(WebElement drag, WebElement drop) {
        wait.until(ExpectedConditions.visibilityOf(drag));
        actions.dragAndDrop(drag, drop).build().perform();
    }

    // Other Actions
    @Step("Select multiple elements")
    public void selectMultiple(List<WebElement> list1) {
        actions.clickAndHold(list1.get(0)).clickAndHold(list1.get(1)).build().perform();
    }

    @Step("Get element from the list by index")
    public WebElement getIndex(List<WebElement> list, int index) {
        list.get(index);
        return null;
    }

    @Step("Scroll to element")
    public void scroll(WebElement elem) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", elem);
    }

    // Alert Actions
    @Step("Alert popup get text")
    public void alertPopupGetText(String alert) {
        Alert popup = driver.switchTo().alert();
        alert = popup.getText();
        popup.accept();
    }

    // Utility Methods
    public String getRandomNumberStringForGid() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }

    public String generateString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

    void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void highlightElement(WebElement element, String color) {
        String originalStyle = element.getAttribute("style");
        String newStyle = "background-color:Violet;border: 1px solid " + color + ";" + originalStyle;
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }
}