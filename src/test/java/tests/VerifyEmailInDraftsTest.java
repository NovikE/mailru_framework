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

public class VerifyEmailInDraftsTest extends BaseTest{

        String sendToAddress = InputData.SENDTOADRESS.getPersonalData();
        String emailSubject = StringUtils.getRandomString(9);
        String emailBody = StringUtils.getRandomString(50);

        @Test
        public void createEmailAsDraft(){

                User testUser = UserCreator.withCredentialsFromProperty();
                new LoginPage(driver)
                        .login(testUser);

                new ComposeEmailDialog(driver).clickCompose()
                        .createNewDraftEmail(sendToAddress, emailSubject, emailBody)
                        .closeEmail();

                DraftsFolderPage draftsFolder = new DraftsFolderPage(driver).draftsOpenFolder();
                draftsFolder.findEmail(emailSubject);
                Assert.assertTrue(draftsFolder.verifyEmails(sendToAddress, emailBody), "Wrong email!");
                draftsFolder.sendEmail();
                draftsFolder.closeAlertWindow();

    }
}
