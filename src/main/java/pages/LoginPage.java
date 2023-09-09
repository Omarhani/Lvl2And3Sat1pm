package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.MethodHandles;

public class LoginPage extends MethodHandles {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.id("Email");

    private By passwordField = By.id("Password");
    private By loginButton = By.cssSelector(".button-1.login-button");

    public void insertUsername(String text){
        sendKeys(emailField,text);
    }
    public void insertPassword(String text){
        sendKeys(passwordField,text);
    }
    public void clickOnLoginButton(){
        click(loginButton);
    }

}
