package login;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;
import reader.ReadDataFromJson;

import java.io.FileNotFoundException;

public class LoginTests extends BaseTests {

    @Test
    public void testSuccessfulLogin() throws FileNotFoundException {
        readDataFromJson = new ReadDataFromJson();
        LoginPage loginPage = homePage.clickOnLoginLink();
        loginPage.insertUsername(readDataFromJson.readJsonFile().Login.ValidCredentials.Username);
        loginPage.insertPassword(readDataFromJson.readJsonFile().Login.ValidCredentials.Password);
        loginPage.clickOnLoginButton();
    }
}
