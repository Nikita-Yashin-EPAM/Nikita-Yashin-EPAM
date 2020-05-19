package steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepdefs extends TestBase {
    @Before
    public void init(){
        startUp();
    }
    @After
    public void finish(){
        endUp();
    }

    @Given("^I go to start page$")
    public void iGoToStartPage() {
        main.goTo();
    }

    @When("^I feel search field by \"([^\"]*)\"$")
    public void iFeelSearchFieldBy(String arg0) {
        taskOnePage.fillInSearchField(arg0);
    }

    @And("^I press the search button$")
    public void iPressTheSearchButton() {
        taskOnePage.clickSearchButton();
    }

    @Then("^I successfully  get a data of the user$")
    public void iSuccessfullyGetADataOfTheUser() {
        taskOnePage.isSearchResultCorrect();
    }

}
