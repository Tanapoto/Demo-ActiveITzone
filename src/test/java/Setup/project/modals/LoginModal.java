package Setup.project.modals;

import lombok.Data;

@Data
public class LoginModal {

    public static String email = "EMAIL";

    public static String password = "PASSWORD";

    public static String expectedError = "EXPECTED_ERROR";

    public static String loginPageUrl = "LOGIN_PAGE_URL";

    public static String dashboardPageUrl = "DASHBOARD_PAGE_URL";


    public static String getEmail() {
        return email;
    }

    public static String getPassword() {
        return password;
    }

    public static String getExpectedError() {
        return expectedError;
    }

    public static String getLoginPageUrl() {
        return loginPageUrl;
    }

    public static String getDashboardPageUrl() {
        return dashboardPageUrl;
    }
}