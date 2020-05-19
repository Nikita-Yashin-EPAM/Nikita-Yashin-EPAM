package steps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


//todo fix
@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/find.feature"},
        glue = {"steps"}, plugin = {"pretty"})
public class RunTest {
}
