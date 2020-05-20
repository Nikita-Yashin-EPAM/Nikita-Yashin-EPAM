package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertFalse;

public class TaskOnePage extends BasePage {
    public TaskOnePage(WebDriver webDriver) {
        super(webDriver);
    }
    public TaskOnePage fillInSearchField(String request){
        writeText(By.xpath("somexpath"), request);
        return this;
    }
    public TaskOnePage clickSearchButton(){
        click(By.cssSelector("somecss"));
        return this;
    }
    public TaskOnePage isSearchResultCorrect(){
        isElementDisplayed(By.xpath("somexpath"));
        return  this;
    }
    public TaskOnePage isSearchResultNOTcorrect(){
        isElementNOTdisplayed(By.xpath("somexpath"));
        return this;
    }
}
