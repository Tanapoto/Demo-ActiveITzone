package Setup.project.pages.Login;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.LoginModal;
import Setup.project.pages.Dashboard.DashBoardPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    public By inputEmail = ObjectUtils.getByLocatorFromConfig("inputEmail");
    public By inputPassword = ObjectUtils.getByLocatorFromConfig("inputPassword");
    public By alertErrorMessage = ObjectUtils.getByLocatorFromConfig("alertErrorMess");
    public By buttonLogin = ObjectUtils.getByLocatorFromConfig("buttonLogin");
    ExcelHelpers excelHelpers;
    public LoginPage() {
        excelHelpers = new ExcelHelpers();
    }

    public DashBoardPage loginInvalidEmail() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1, LoginModal.getLoginPageUrl())));
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, excelHelpers.getCellData(1, LoginModal.getEmail()));
        WebUI.setText(inputPassword, excelHelpers.getCellData(1, LoginModal.getPassword()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementPresent(alertErrorMessage));
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(1, LoginModal.getDashboardPageUrl())));
        return new DashBoardPage();
    }

    public DashBoardPage loginInvalidPassword() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(2, LoginModal.getLoginPageUrl())));
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, excelHelpers.getCellData(2, LoginModal.getEmail()));
        WebUI.setText(inputPassword, excelHelpers.getCellData(2, LoginModal.getPassword()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementPresent(alertErrorMessage));
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(2, LoginModal.getDashboardPageUrl())));
        return new DashBoardPage();
    }

    public DashBoardPage loginEmptyUsername() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(3, LoginModal.getLoginPageUrl())));
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, excelHelpers.getCellData(3, LoginModal.getEmail()));
        WebUI.setText(inputPassword, excelHelpers.getCellData(3, LoginModal.getPassword()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementNotPresent(alertErrorMessage));
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(3, LoginModal.getDashboardPageUrl())));
        return new DashBoardPage();
    }

    public DashBoardPage loginEmptyPassword() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(4, LoginModal.getLoginPageUrl())));
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, excelHelpers.getCellData(4, LoginModal.getEmail()));
        WebUI.setText(inputPassword, excelHelpers.getCellData(4, LoginModal.getPassword()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementNotPresent(alertErrorMessage));
        Assert.assertFalse(WebUI.verifyPageUrl(excelHelpers.getCellData(4, LoginModal.getDashboardPageUrl())));
        return new DashBoardPage();
    }

    public DashBoardPage loginSuccessfully() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login");
        WebUI.getURL(FrameworkConstants.URL_PROJECT);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(5, LoginModal.getLoginPageUrl())));
        WebUI.clearText(inputEmail);
        WebUI.clearText(inputPassword);
        WebUI.setText(inputEmail, excelHelpers.getCellData(5, LoginModal.getEmail()));
        WebUI.setText(inputPassword, excelHelpers.getCellData(5, LoginModal.getPassword()));
        WebUI.clickElement(buttonLogin);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementNotPresent(alertErrorMessage));
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(5, LoginModal.getDashboardPageUrl())));
        return new DashBoardPage();
    }

}
