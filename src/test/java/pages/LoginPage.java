package pages;

import model.User;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.UtilsWithJS;
import utils.InputData;

import java.io.IOException;

public class LoginPage extends AbstractPage{

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(id = "mailbox:login")
    private WebElement login;

    @FindBy(id = "mailbox:saveauth")
    private  WebElement saveAuthCheckBox;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private  WebElement addPassBtn;

    @FindBy(id = "mailbox:password")
    private  WebElement passwordInput;

    @FindBy(id = "PH_user-email")
    private WebElement userName;

    public LoginPage(WebDriver driver){
        super (driver);
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(login));
    }

    public LoginPage login(User testUser){

        new Actions(driver).sendKeys(login, testUser.getUsername()).build().perform();
       //login.sendKeys(loginName);
        new Actions(driver).click(saveAuthCheckBox).build().perform();
       // saveAuthCheckBox.click();
        UtilsWithJS.clickAsJs(driver, "mailbox:submit");
       //addPassBtn.click();
        passwordInput.sendKeys(testUser.getPassword());
        addPassBtn.click();


        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(userName));

        return this;
    }

    public String getLoggedUserName() throws IOException {
        UtilsWithJS.highlightElement(driver, userName);
        return userName.getText();
    }

}
