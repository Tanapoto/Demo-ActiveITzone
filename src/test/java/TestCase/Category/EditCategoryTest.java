package TestCase.Category;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.AddCategoryDataProvider;
import Setup.project.dataprovider.EditCategoryDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.ProductsCategory.AddCategoryPage;
import Setup.project.pages.ProductsCategory.EditCategoryPage;
import Setup.project.pages.ProductsCategory.ListCategoryPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class EditCategoryTest extends BaseTest {

    LoginPage loginPage;
    EditCategoryPage editCategoryPage;
    ListCategoryPage listCategoryPage;
    public EditCategoryTest() {
        loginPage = new LoginPage();
        editCategoryPage = new EditCategoryPage();
        listCategoryPage = new ListCategoryPage();
    }

    @Test(priority = 1, dataProvider = "getEditCategoryDataHashTable", dataProviderClass = EditCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void editCategorySuccessfullyWithAllField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCategoryPage.openEditCategoryPage(1);
        editCategoryPage.editCategory(1);
//        editCategoryPage.editCategoryImage();
        editCategoryPage.editIconImage();
        editCategoryPage.editCategorySuccessfully(1);
        listCategoryPage.openListCategoryPage();
        listCategoryPage.checkEditedCategory(1);
    }

    @Test(priority = 2, dataProvider = "getEditCategoryDataHashTable", dataProviderClass = EditCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void editCategorySuccessfullyWithRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCategoryPage.openEditCategoryPage(2);
        editCategoryPage.editCategory(2);
        editCategoryPage.editCategorySuccessfully(2);
        listCategoryPage.openListCategoryPage();
        listCategoryPage.checkEditedCategory(2);
    }

    @Test(priority = 3, dataProvider = "getEditCategoryDataHashTable", dataProviderClass = EditCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void editCategoryFailureWithNotRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCategoryPage.openEditCategoryPage(3);
        editCategoryPage.editCategory(3);
        editCategoryPage.editCategoryFailure(3);
    }

    @Test(priority = 4, dataProvider = "getEditCategoryDataHashTable", dataProviderClass = EditCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void editCategoryFailureWithEmptyField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCategoryPage.openEditCategoryPage(4);
        editCategoryPage.editCategory(4);
        editCategoryPage.editCategoryFailure(4);
    }
}
