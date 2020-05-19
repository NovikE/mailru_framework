package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.InputData;
import utils.StringUtils;

import java.util.List;

public class DraftsFolderPage extends AbstractPage{

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(xpath = "//*[@href='/drafts/']")
    private WebElement draftsBtn;

    @FindBy(xpath = "//*[@class='ll-sj__normal']")
    private List<WebElement> draftEmails;

    @FindBy(xpath = "//*[@class='text--1tHKB']")
    private WebElement sendToInDraft;

    @FindBy(xpath = "//div[@class='js-helper js-readmsg-msg']/descendant::div")
    private List<WebElement> bodyInDraft;

    @FindBy(xpath = "//*[@title='Отправить']")
    private WebElement sendBtn;

    @FindBy(xpath = "//*[@title='Закрыть']")
    WebElement closeAlertBtn;

    public DraftsFolderPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS).
                until(ExpectedConditions.visibilityOf(draftsBtn));
    }

    public DraftsFolderPage draftsOpenFolder(){
        draftsBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
            .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@style, 'display: table;')]"))));
        return this;
    }

    public boolean findEmail(String emailSubject){
        for (WebElement webElement: draftEmails) {
            if(webElement.getText().contains(emailSubject)) {
                webElement.click();
                new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                        .until(ExpectedConditions.visibilityOf(sendToInDraft));
                return true;
            }
        }
        return false;
    }

    public boolean verifyEmails(String sendToAddress, String bodyText){
        if(sendToInDraft.getText().contains(sendToAddress) && StringUtils.equalText(bodyInDraft, bodyText)){
            return true;
        }
        return false;
    }


    public void sendEmail(){
        sendBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(closeAlertBtn));
    }

    public void closeAlertWindow(){
        closeAlertBtn.click();
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS)
                .until(ExpectedConditions.visibilityOf(draftsBtn));
    }

}
