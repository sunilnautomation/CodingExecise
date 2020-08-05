package com.pages;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FindWorkshop extends TestBase {

    @FindBy(id = "location-search")
    WebElement searchLocationInputField;

    @FindBy(id = "location-search-cta")
    WebElement findButton;

    @FindBy(id = "locationName-1jro_")
    WebElement LocationName;

    @FindBy(className = "linkUnderline-1_h4g")
    List<WebElement> searchResultsNames;

    @FindBy(className = "distance-OhP63")
    List<WebElement> searchResultsDistance;


    public FindWorkshop() {
        PageFactory.initElements(driver, this);
    }

    //Method to Search for Meetings at a particular Zip
    public void searchForMeetings(String zipCode) {
        searchLocationInputField.sendKeys(zipCode);
        findButton.click();
    }

    //Method to retrieve First Search Results Name
    public WebElement getFirstSearchResult() {
        return this.searchResultsNames.get(0);
    }

    //Method to retrieve First Search Results Name
    public String getFirstSearchResultsName() {
        return this.searchResultsNames.get(0).getText().trim();
    }

    //Method to retrieve First Search Results Distance
    public String getFirstSearchResultsDistance() {
        return this.searchResultsDistance.get(0).getText().trim();
    }

    //Method to navigate to Studio And Workshop
    public StudioAndWorkshop navigateToStudioAndWorkshop() {
        getFirstSearchResult().click();
        return new StudioAndWorkshop();
    }

}
