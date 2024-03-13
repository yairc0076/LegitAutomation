package utilities;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.aspectj.lang.annotation.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.sikuli.script.Screen;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import org.w3c.dom.Document;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.swing.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;



public class CommonOps extends Base {


    //  public static Screen screen;


    public static String getData(String nodeName) {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/Configuration.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        } catch (Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }
    public static String getUsername() {
        return getData("username");
    }

    public static String getPassword() {
        return getData("password");
    }

    public static String getURL() {
        return getData("url");
    }

    public static void initBroswer(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if ((browserType.equalsIgnoreCase("ie")))
            driver = initIEDriver();
        else
            throw new RuntimeException("Invalid Browser Type");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        ManagePages.Legit();
        wait = new WebDriverWait(driver, Duration.ofSeconds(70));
        action = new Actions(driver);
        softassert = new SoftAssert();


    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        // WebDriverManager.chromedriver().driverVersion("102").browserInDocker().setup();
        // WebDriverManager.chromedriver().driverVersion("107").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);


        //ChromeOptions options = new ChromeOptions();
        //options.addArguments("--remote-allow-origins=*");
//       //screen = new Screen();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        System.setProperty("webdriver.chrome.args", "--disable-logging");
//        System.setProperty("webdriver.chrome.silentOutput", "true");
//        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
////      // options.addArguments("disable-infobars"); // disabling infobars
////      // options.addArguments("disable-infobars"); // disabling infobars
//        options.addArguments("--disable-extensions"); // disabling extensions
//        options.addArguments("--disable-gpu"); // applicable to windows os only
//        options.addArguments("window-size=1920,1080"); // Bypass OS security model
//        options.addArguments("--lang=en_US");
//        options.addArguments("--ignore-certificate-errors");
//        options.addArguments("--remote-debugging-port=9222");
//        options.addArguments("--user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/102.0.5005.61 Safari/537.36");
        //ChromeDriver driver = new ChromeDriver(options);

        return driver;

    }

    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    @BeforeSuite
    public void startSession() throws Exception {


        if (getData("PlatformName").equalsIgnoreCase("web"))
            initBroswer(getData("BrowserName"));

//        else if(platform.equalsIgnoreCase("mobile")))
//            initMobile();

        else
            throw new RuntimeException("Invlaid platform name");
        //softassert = new SoftAssert();
    }


    @AfterSuite
    public void closeSession() {

        driver.quit();
    }


    // @BeforeMethod
    // public void BeforeMethod(Method method) {
//            try {
//                MonteScreenRecorder.startRecord(method.getName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

}


//}