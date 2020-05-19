package utils;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


public class TestListener implements ITestListener {

    private Logger log = LogManager.getRootLogger();

    public void onTestFailure(ITestResult iTestResult) {
        makeScreenshots();
    }

    public void makeScreenshots() {
        File screenShotFile = ((TakesScreenshot) DriverSingleton.getDriver())
                .getScreenshotAs(OutputType.FILE);

        try {
            FileUtils.copyFile(screenShotFile, new File("src/test/test-output/"
                    + "screenshot " + getCurrentTimeAsString()+ ".png"));
            }catch (IOException e){
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);

    }
}
