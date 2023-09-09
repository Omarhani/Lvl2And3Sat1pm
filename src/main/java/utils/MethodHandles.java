package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MethodHandles {

    protected WebDriver driver;
    WebDriverWait wait;
    public MethodHandles(WebDriver driver){
        this.driver =driver;
    }

    protected void click(By locator){
        explicitWait(locator,15);
        webElement(locator).click();
    }
    protected void sendKeys(By locator,String text){
        explicitWait(locator,10);
        webElement(locator).sendKeys(text);
    }
    private void explicitWait(By locator,int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(driver.findElement(locator)),
                ExpectedConditions.elementToBeClickable(locator),
                ExpectedConditions.presenceOfElementLocated(locator)));
    }

    private WebElement webElement(By locator){
        return driver.findElement(locator);
    }
}
