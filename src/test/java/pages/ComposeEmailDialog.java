package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.InputData;


public class ComposeEmailDialog extends AbstractPage{

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(xpath = "//*[@class='compose-button__wrapper']")
    private WebElement composeBtn;

    @FindBy(xpath = "//input[@class='container--H9L5q size_s_compressed--2c-eV']")
    private WebElement sendToInput;

    @FindBy(name = "Subject")
    private WebElement subjectInput;

    @FindBy(xpath = "//div[@contenteditable='true' and @role='textbox']/div")
    private WebElement bodyInput;

    @FindBy(xpath = "//*[@title='Сохранить']")
    private WebElement saveDraftBtn;

    @FindBy(xpath = "//*[@title='Закрыть']")
    private WebElement closeEmail;

    public ComposeEmailDialog(WebDriver driver){
        super (driver);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS).
                until(ExpectedConditions.visibilityOf(composeBtn));
       }

    public ComposeEmailDialog clickCompose(){
        composeBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS).
                until(ExpectedConditions.visibilityOf(sendToInput));
        return this;
    }

    public ComposeEmailDialog createNewDraftEmail(String sendToAddress, String subject, String bodyText){
        sendToInput.sendKeys(sendToAddress);
        subjectInput.sendKeys(subject);
        bodyInput.sendKeys(bodyText);
        saveDraftBtn.click();
        return this;
    }

    public void closeEmail(){
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(closeEmail));
        closeEmail.click();

    }

}
