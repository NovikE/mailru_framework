package utils;

import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class StringUtils {

    public static String getRandomString (int length){
        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmopqrstuywxyz";
        Random rnd = new Random();
        String str = "";
        for (int i = 0; i < length; i++) {
            str = str + AB.charAt(rnd.nextInt(AB.length()));
        }
        return str;
    }

    public static boolean equalText(List<WebElement> webElements, String text) {
        boolean equalText = false;
        for (WebElement webElement: webElements) {
            if(webElement.getText().contains(text)) {
                equalText = true;
                break;
            }
        }
        return equalText;
    }
}
