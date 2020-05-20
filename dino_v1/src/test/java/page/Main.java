package page;

import org.openqa.selenium.WebDriver;

public class Main extends BasePage {

    String SITE_URL = "some_domain.com/company/777/users?name=Izergil";

    public Main(WebDriver webDriver) {
        super(webDriver);
    }

    public Main goTo() {
        webDriver.get(SITE_URL);
        return this;
    }
}
