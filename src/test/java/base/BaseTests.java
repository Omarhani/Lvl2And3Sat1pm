package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @BeforeClass
    public void setUp() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        driver = new ChromeDriver();
        driver.get(readDataFromJson.readJsonFile().URL);
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
