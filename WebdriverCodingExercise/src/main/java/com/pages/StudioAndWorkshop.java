package com.pages;

import com.base.TestBase;
import com.google.gson.stream.JsonToken;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudioAndWorkshop extends TestBase {

    WebElement parent;

    @FindBy(className = "locationName-1jro_")
    WebElement studioName;

    @FindBy(className = "dayName-1UpF5")
    List<WebElement> daysOfOperation;

    //Page object intialization
    public StudioAndWorkshop() {
        PageFactory.initElements(driver, this);
    }

    //Method to return StudioName object
    public String getStudioName() {
        return this.studioName.getText().trim();
    }

    //Method to retrieve the Today's Hours
    public ArrayList<String> getTodaysHours(String todayDay) {
        ArrayList<String> hoursOfOperation=new ArrayList<String>();
        for (WebElement each : daysOfOperation) {
            if (todayDay.equals(each.getText())) {
                //System.out.println("Today :: " + each.getText());
                parent = (WebElement) ((JavascriptExecutor) driver).executeScript(
                        "return arguments[0].parentNode;", each);
                //System.out.print("Parent Text:: " + parent.getText() + "  ");
                break;
            }
        }

        List<WebElement> childs = parent.findElements(By.className("meetingTime-1g52A"));
        //System.out.println("Hours of operation:: ");
        for (WebElement each : childs) {
            hoursOfOperation.add(each.getText());
        }
        return hoursOfOperation;
    }

    //Method to retrieve the Meetings Per Person
    public Map<String, Integer> getMeetingsPerPerson(String todayDay) {
        Map<String, Integer> getMeetingsPerPerson = new HashMap<String, Integer>();
        String dynamic="//span[contains(text(),'"+todayDay+"')]/following-sibling::*//span[2]";

        List<WebElement> meetingsPerPerson = driver.findElements(By.xpath(dynamic));
        for (WebElement each : meetingsPerPerson) {
            if(!getMeetingsPerPerson.containsKey(each.getText()))
                getMeetingsPerPerson.put(each.getText(),0);
            getMeetingsPerPerson.put(each.getText(),getMeetingsPerPerson.get(each.getText())+1);
        }
        return getMeetingsPerPerson;
    }
}
