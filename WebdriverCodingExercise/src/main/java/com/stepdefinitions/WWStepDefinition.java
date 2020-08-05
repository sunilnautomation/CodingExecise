package com.stepdefinitions;

import com.base.TestBase;
import com.pages.FindWorkshop;
import com.pages.HomePage;
import com.pages.StudioAndWorkshop;
import com.util.TestUtil;
import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;

import cucumber.api.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import java.util.*;

public class WWStepDefinition extends TestBase {
    HomePage homePage = new HomePage();
    FindWorkshop findWorkshop;
    StudioAndWorkshop studioAndWorkshop;

    String firstSearchResultsName = "";
    String firstSearchResultsDistance = "";
    Scenario scenario;

    public WWStepDefinition() {
        super();
    }

    @Before
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("^I am on Home page of \"([^\"]*)\"$")
    public void i_am_om_Home_page_of(String wwInthomePage) throws Throwable {
        scenario.write(wwInthomePage + "'s home page url is ::" + driver.getCurrentUrl());
    }

    @Given("^I assert that loaded page title matches$")
    public void i_assert_that_loaded_page_title_matches(DataTable pageTitle) throws Throwable {
        List<List<String>> dataTable = pageTitle.raw();
        String expectedPageTitle=dataTable.get(0).get(0);
        try {
            Alert alert = driver.switchTo().alert();
            //System.out.println(alert.getText() + " Alert is Displayed");
            driver.switchTo().alert().dismiss();
            Assert.assertEquals(expectedPageTitle, driver.getTitle());
        } catch (NoAlertPresentException ex) {
            //System.out.println("Alert is not Displayed");
        }
    }

    @Given("^I click on \"([^\"]*)\" found on the right corner$")
    public void i_click_on_found_on_the_right_corner(String buttonName) throws Throwable {
        findWorkshop = homePage.navigateToFindWorkshopViaFindaLocation();
    }

    @Given("^I search for the meetings at zip code$")
    public void i_search_for_the_meetings_at_zip_code(DataTable zipCode) throws Throwable {
        List<List<String>> dataTable = zipCode.raw();
        String searchZipCode=dataTable.get(0).get(0);
        findWorkshop.searchForMeetings(searchZipCode);
    }

    @Given("^I print the title of the first result and the distance$")
    public void i_print_the_title_of_the_first_result_and_the_distance() throws Throwable {
        firstSearchResultsName = findWorkshop.getFirstSearchResultsName();
        firstSearchResultsDistance = findWorkshop.getFirstSearchResultsDistance();

        //To print the details on the cucumber file
        scenario.write("The title of the first result and the distance :: ");
        scenario.write(firstSearchResultsName);
        scenario.write(firstSearchResultsDistance);
    }

    @Given("^I click on first search result$")
    public void i_click_on_first_search_result() throws Throwable {
        studioAndWorkshop = findWorkshop.navigateToStudioAndWorkshop();
    }

    @Given("^I assert that loaded page title matches with first result$")
    public void i_assert_that_loaded_page_title_matches_with_first_result() throws Throwable {
        Assert.assertEquals(studioAndWorkshop.getStudioName(), firstSearchResultsName);
    }

    @Given("^I print TODAY’s hours of operation$")
    public void i_print_TODAY_s_hours_of_operation() throws Throwable {
        ArrayList<String> hoursOfOperation = studioAndWorkshop.getTodaysHours(TestUtil.getCurrenDayofWeek());
        scenario.write("TODAY ("+ TestUtil.getCurrenDayofWeek() +")’s hours of operation :: ");
        //To print the details on the cucumber file
        for (String each : hoursOfOperation)
            scenario.write(each);
    }

    @Given("^I print the number of meeting the each person for each day$")
    public void i_print_the_number_of_meeting_the_each_person_for_each_day(DataTable daysInWeek) throws Throwable {
        List<List<String>> dataTable = daysInWeek.raw();

        for (List<String> each : dataTable) {
            String eachDay=each.get(0);
            Map<String, Integer> map = studioAndWorkshop.getMeetingsPerPerson(eachDay);
            scenario.write("Number of meeting the each person(under the scheduled time) has on " + each.get(0) + "DAY of the week :: ");
            //To print the details on the cucumber file
            for (String eachItem : map.keySet())
                scenario.write(eachItem + " " + map.get(eachItem));
        }
    }

}
