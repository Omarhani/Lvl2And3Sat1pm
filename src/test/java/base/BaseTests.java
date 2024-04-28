package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.*;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.lang.reflect.Method;

public class BaseTests {

    WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser,Method method) {

        setUpBrowser(browser);

        driver.manage().window().maximize();
        homePage = new HomePage(driver);

    }
    @BeforeMethod
    public void goHome(Method method) throws Exception {
        readDataFromJson = new ReadDataFromJson();
        driver.get(readDataFromJson.readJsonFile().URL);
    }
    @Parameters("browser")
    public void setUpBrowser(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")){
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("headlessChrome")) {
            ChromeOptions options = new ChromeOptions();
            options.setHeadless(true);
            driver = new ChromeDriver(options);

        } else if (browser.equalsIgnoreCase("headlessFirefox")) {
            FirefoxOptions options = new FirefoxOptions();
            options.setHeadless(true);
            driver = new FirefoxDriver(options);
        }
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
