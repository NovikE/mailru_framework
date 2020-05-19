package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.InputData;
import utils.StringUtils;

import java.util.List;

public class SentEmailsFolderPage extends AbstractPage {

    private static final String HOMEPAGE_URL = InputData.HOMEPAGE_URL.getPersonalData();

    @FindBy(xpath = "//*[@title='Отправленные']")
    private WebElement sentFolderBtn;

    @FindBy(xpath = "//*[@class='ll-sj__normal']")
    private List<WebElement> sentEmails;

    @FindBy(id = "PH_logoutLink")
    private WebElement exitBtn;

    public SentEmailsFolderPage openSentEmailsFolder() throws InterruptedException {
        sentFolderBtn.click();
        Thread.sleep(2000);
        return this;
    }

    public boolean isEmailSent(String subject){
        return  StringUtils.equalText(sentEmails, subject);
    }

    public void logout(){exitBtn.click();}

    public SentEmailsFolderPage(WebDriver driver){
        super(driver);
        new WebDriverWait(driver, WAIT_TIMEOUTS_SECONDS).
                until(ExpectedConditions.visibilityOf(sentFolderBtn));}

}
