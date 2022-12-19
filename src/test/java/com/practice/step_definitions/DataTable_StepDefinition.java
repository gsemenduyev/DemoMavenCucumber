package com.practice.step_definitions;

import com.practice.pages.DropdownsPage;
import com.practice.pages.LibraryLoginPage;
import com.practice.utilities.BrowserUtils;
import com.practice.utilities.ConfigurationReader;
import com.practice.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class DataTable_StepDefinition {
    LibraryLoginPage loginPage = new LibraryLoginPage();
    DropdownsPage dropdownsPage = new DropdownsPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");

    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        Select select = new Select(dropdownsPage.month);
        List<WebElement> actualMonthAsWebElement = select.getOptions();

        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(actualMonthAsWebElement));

        //3 - Convert from List<WebElement> to List<String>
//         List<String> actualMonthsAsString = new ArrayList<>();
//        for (WebElement each : actualMonthAsWebElement) {
//            actualMonthsAsString.add(each.getText());
//        }
//
//        Assert.assertEquals(expectedList, actualMonthsAsString);

    }


    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("libraryUrl"));

    }
    @When("user inters username and password as below")
    public void user_inters_username_and_password_as_below(Map<String, String> loginInfo) {

       loginPage.emailInput.sendKeys(loginInfo.get("username"));
       loginPage.passwordInput.sendKeys(loginInfo.get("password"));

       loginPage.signIn.click();


    }
    @Then("user should see the title Library")
    public void user_should_see_the_title_something() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Library";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

    }

    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {
        System.out.println("ListOfFruits.size() = " + listOfFruits.size());
        System.out.println("ListOfFruits = " + listOfFruits);
    }

}
