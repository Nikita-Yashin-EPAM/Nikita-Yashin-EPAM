package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TaskOnePage extends BasePage {
    public TaskOnePage(WebDriver webDriver) {
        super(webDriver);
    }
    public TaskOnePage fillInSearchField(String request){
        writeText(By.xpath("//form[@id='search-form']/input[@role='combobox']"), request);
        return this;
    }
    public TaskOnePage clickSearchButton(){
        click(By.cssSelector("#search-form > button.promoted-search__search-button"));
        return this;
    }
    public TaskOnePage isSearchResultCorrect(){
        isElementDisplayed(By.xpath("//div[@class='title']"));
        return  this;
    }
}
