package com.practice.step_definitions;

import com.practice.pages.WikiSearchPage;
import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wiki_StepDefinitions {
    WikiSearchPage wikiSearchPage = new WikiSearchPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        String wikiUrl = ConfigurationReader.getProperty("wikiURL");
        Driver.getDriver().get(wikiUrl);

    }
    @When("User types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String arg0) {
        wikiSearchPage.searchBur.sendKeys(arg0);

    }
    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikiSearchPage.searchButton.click();
    }
    @Then("User sees {string} in the viki title")
    public void user_sees_steve_jobs_in_the_viki_title(String arg0) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = arg0 + " - Wikipedia";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User sees {string} in the viki header")
    public void userSeesInTheVikiHeader(String arg0) {
        String expectedHeader = arg0;
        String actualHeader = wikiSearchPage.header.getText();

        Assert.assertEquals(arg0, actualHeader);
    }

    @Then("User sees {string} is in the wiki title")
    public void userSeesIsInTheWikiTitle(String arg0) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = arg0 + " - Wikipedia";

        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Then("User sees {string} is in the main header")
    public void userSeesIsInTheMainHeader(String arg0) {
        String expectedHeader = arg0;
        String actualHeader = wikiSearchPage.header.getText();

        Assert.assertEquals(arg0, actualHeader);
    }
}
