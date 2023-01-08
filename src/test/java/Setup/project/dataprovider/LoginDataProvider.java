package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.LoginModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public final class LoginDataProvider {

    private LoginDataProvider() {
    }

    @Test(dataProvider = "getLoginDataHashTable")
    public void testGetLoginData(Hashtable<String, String> data) {
        System.out.println("loginData.username = " + data.get(LoginModal.getEmail()));
        System.out.println("loginData.password = " + data.get(LoginModal.getPassword()));
        System.out.println("loginData.expectedError = " + data.get(LoginModal.getExpectedError()));
        System.out.println("loginData.loginPageUrl = " + data.get(LoginModal.getLoginPageUrl()));
        System.out.println("loginData.DashboardPageUrl = " + data.get(LoginModal.getDashboardPageUrl()));
    }

    
    @DataProvider(name = "getLoginDataHashTable")
    public static Object[][] getLoginData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Login", 1, 1);
        return data;
    }


    
}