import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class First extends TestBase {
    @Test
    public void firstTest(){
        driver.get(SITE_URL);
    }
    @Test
    public void secondTest(){
        driver.get(SITE_URL);
    }
}
