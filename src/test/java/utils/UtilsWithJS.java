package utils;

import org.openqa.selenium.*;

public class UtilsWithJS {

    public static void highlightElement(WebDriver driver, WebElement element) {
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }


    public static void clickAsJs (WebDriver driver, String id){
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("document.getElementById('" + id + "').click()");

    }




}
