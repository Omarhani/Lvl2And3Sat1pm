package login;

import base.BaseTests;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataDrivenFromJson;
import reader.ReadDataFromJson;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LoginTests extends BaseTests {

    ReadDataDrivenFromJson readDataDrivenFromJson;

    @DataProvider
    public Object[] testDataForSuccessfulLogin() throws IOException, ParseException {
        readDataDrivenFromJson = new ReadDataDrivenFromJson();
        return readDataDrivenFromJson.testDataForSuccessfulLogin();
    }

    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void testSuccessfulLogin(String data) throws FileNotFoundException {
//        readDataFromJson = new ReadDataFromJson();
        String users[]= data.split(",");
        
        //  [0] --> omar
        //  [1] --> 123
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertUsername(users[0]);
        loginPage.insertPassword(users[1]);
//        loginPage.insertUsername(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
//        loginPage.insertPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);


        loginPage.clickOnLoginButton();
    }
    @Test(dataProvider = "testDataForSuccessfulLogin")
    public void testSuccessfulLogin2(String data) throws FileNotFoundException {
//        readDataFromJson = new ReadDataFromJson();
        String users[]= data.split(",");

        //  [0] --> omar
        //  [1] --> 123
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertUsername(users[0]);
        loginPage.insertPassword(users[1]);

//        loginPage.insertUsername(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
//        loginPage.insertPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);


        loginPage.clickOnLoginButton();
    }
}
