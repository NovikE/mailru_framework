package tests;

import model.User;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import service.UserCreator;

import java.io.IOException;

public class LoginPageTest extends BaseTest{

        @Test
        public void loginUser() throws IOException {
            User testUser = UserCreator.withCredentialsFromProperty();
            Assert.assertTrue(new LoginPage(driver)
            .login(testUser)
            .getLoggedUserName().contains(testUser.getUsername()),"Wrong user login name!");
        }

    }

