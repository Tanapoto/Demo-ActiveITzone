package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.LoginDataProvider;
import Setup.project.pages.Login.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test Automation Practice")
@Feature("Login Test")
public class LoginTest extends BaseTest {

    LoginPage loginPage;
    public LoginTest() {
        loginPage = new LoginPage();
    }

    @Test(priority = 1, dataProvider = "getLoginDataHashTable", dataProviderClass = LoginDataProvider.class)
    @Step("loginTestDataProvider")
    public void loginInvalidEmail(Hashtable<String, String> data) {
        loginPage.loginInvalidEmail();
    }

    @Test(priority = 2, dataProvider = "getLoginDataHashTable", dataProviderClass = LoginDataProvider.class)
    @Step("loginTestDataProvider")
    public void loginInvalidPassword(Hashtable<String, String> data) {
        loginPage.loginInvalidEmail();
    }

    @Test(priority = 3, dataProvider = "getLoginDataHashTable", dataProviderClass = LoginDataProvider.class)
    @Step("loginTestDataProvider")
    public void loginEmptyUsername(Hashtable<String, String> data) {
        loginPage.loginInvalidEmail();
    }

    @Test(priority = 4, dataProvider = "getLoginDataHashTable", dataProviderClass = LoginDataProvider.class)
    @Step("loginTestDataProvider")
    public void loginEmptyPassword(Hashtable<String, String> data) {
        loginPage.loginInvalidEmail();
    }

    @Test(priority = 5, dataProvider = "getLoginDataHashTable", dataProviderClass = LoginDataProvider.class)
    @Step("loginTestDataProvider")
    public void loginSuccessfully(Hashtable<String, String> data) {
        loginPage.loginInvalidEmail();
    }

}

