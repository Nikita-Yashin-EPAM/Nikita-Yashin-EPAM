package steps;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import page.Main;
import page.TaskOnePage;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;
    public Main main;
    public TaskOnePage taskOnePage;

    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(true);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        main = PageFactory.initElements(driver, Main.class);
        taskOnePage = PageFactory.initElements(driver, TaskOnePage.class);

    }

    public void endUp() {
        driver.close();
    }
}
