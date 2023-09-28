package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import pages.HomePage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class BaseTests {

    WebDriver driver;
    protected ReadDataFromJson readDataFromJson;
    protected HomePage homePage;

    @Parameters("browser")
    @BeforeClass
    public void setUp(String browser) throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        setUpBrowser(browser);
        driver.get(readDataFromJson.readJsonFile().URL);

        driver.manage().window().maximize();
        homePage = new HomePage(driver);
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
