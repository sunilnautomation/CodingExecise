package com.stepdefinitions;

import com.base.TestBase;
import com.util.LoggerHelper;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;




public class ServiceHooks extends TestBase {
    private Scenario myScenario;
    Logger log= LoggerHelper.getLogger(ServiceHooks.class);


    @Before
    public void setUp() {
        TestBase.initialization();
    }

    @After
    public void embedScreenshot(Scenario scenario) throws InterruptedException {
        myScenario = scenario;
        if (scenario.isFailed()) {
            try {
                myScenario.write("current page url is " + driver.getCurrentUrl());
                byte[] screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                myScenario.embed(screenShot, "image/png");

            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                log.error(somePlatformsDontSupportScreenshots.getMessage());
            } catch (ClassCastException cce) {
                cce.printStackTrace();
            }
        }
    }

   @After
    public void tearDown() throws Exception {
        if (driver == null) return;
        driver.quit();
        driver = null;
    }
}
