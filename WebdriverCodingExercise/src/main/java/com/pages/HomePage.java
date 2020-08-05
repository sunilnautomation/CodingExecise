package com.pages;

import com.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends TestBase {

    @FindBy(className = "IconButton_icon-button__1FbvG")
    WebElement PopupCloseButtton;

    @FindBy(className = "Modal_modal__backdrop__Qg5dX")
    WebElement findaLocation;

    //Page object intialization
    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    //Method to Navigate To Find Workshop Via Find Location
    public FindWorkshop navigateToFindWorkshopViaFindaLocation() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement el = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//span[contains(text(), 'Find a Workshop')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", el);
        return new FindWorkshop();
    }

}
