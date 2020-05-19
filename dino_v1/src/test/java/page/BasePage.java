package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.AssertJUnit.assertTrue;

public class BasePage {

    public WebDriver webDriver;
    public WebDriverWait webDriverWait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, 30);
    }
    public void waitVisibility(By elementBy){
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }
    public void click (By elementBy){
        waitVisibility(elementBy);
        webDriver.findElement(elementBy).click();
    }
    public void isElementDisplayed (By elementBy){
        waitVisibility(elementBy);
        assertTrue(webDriver.findElement(elementBy).isDisplayed());
    }
    public void writeText(By elementBy, String text){
        waitVisibility(elementBy);
        webDriver.findElement(elementBy).sendKeys(text);
    }
    public String readText(By elementBy){
        waitVisibility(elementBy);
        return webDriver.findElement(elementBy).getText();
    }
    public void isElementNOTdisplayed (By elementBy){
        assertTrue(webDriver.findElements(elementBy).size() > 0);
    }

}
