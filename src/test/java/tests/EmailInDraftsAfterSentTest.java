package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComposeEmailDialog;
import pages.DraftsFolderPage;
import pages.LoginPage;
import service.UserCreator;
import utils.InputData;
import utils.StringUtils;

public class EmailInDraftsAfterSentTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = StringUtils.getRandomString(9);
        String emailBody = StringUtils.getRandomString(50);

        @Test
        public void verifyEmailInDrafts(){
                User testUser = UserCreator.withCredentialsFromProperty();
                new LoginPage(driver)
                         .login(testUser);

                 new ComposeEmailDialog(driver).clickCompose()
                        .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                        .closeEmail();

                DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
                draftsFolder.findEmail(emailSubject);
                draftsFolder.verifyEmails(sendToAddress, emailBody);
                draftsFolder.sendEmail();
                draftsFolder.closeAlertWindow();

                Assert.assertFalse(draftsFolder.draftsOpenFolder().findEmail(emailSubject), "Email is NOT sent!");
    }
}
