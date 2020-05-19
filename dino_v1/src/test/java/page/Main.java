package page;

import org.openqa.selenium.WebDriver;

public class Main extends BasePage {

    String SITE_URL = "https://support.google.com/a/#topic=4388346";

    public Main(WebDriver webDriver) {
        super(webDriver);
    }

    public Main goTo() {
        webDriver.get(SITE_URL);
        return this;
    }
}
