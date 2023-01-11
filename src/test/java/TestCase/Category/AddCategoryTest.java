package TestCase.Category;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.AddCategoryDataProvider;
import Setup.project.dataprovider.AddProdDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.Products.AddNewProdPage;
import Setup.project.pages.Products.ListProdsPage;
import Setup.project.pages.Products.ProdDetailPage;
import Setup.project.pages.ProductsCategory.AddCategoryPage;
import Setup.project.pages.ProductsCategory.ListCategoryPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCategoryTest extends BaseTest {

    LoginPage loginPage;
    AddCategoryPage addCategoryPage;
    ListCategoryPage listCategoryPage;
    public AddCategoryTest() {
        loginPage = new LoginPage();
        addCategoryPage= new AddCategoryPage();
        listCategoryPage = new ListCategoryPage();
    }

    @Test(priority = 1, dataProvider = "getAddCategoryDataHashTable", dataProviderClass = AddCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void addNewCategorySuccessfullyWithAllField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addCategoryPage.openCreateCategoryPage(1);
        addCategoryPage.createCategory(1);
        addCategoryPage.uploadCategoryImage();
        addCategoryPage.uploadIconImage();
        addCategoryPage.saveCategorySuccessfully(1);
        listCategoryPage.checkCreatedCategory(1);
    }

    @Test(priority = 2, dataProvider = "getAddCategoryDataHashTable", dataProviderClass = AddCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void addNewCategorySuccessfullyWithRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addCategoryPage.openCreateCategoryPage(2);
        addCategoryPage.createCategory(2);
        addCategoryPage.saveCategorySuccessfully(2);
        listCategoryPage.checkCreatedCategory(2);
    }

    @Test(priority = 3, dataProvider = "getAddCategoryDataHashTable", dataProviderClass = AddCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void addNewCategoryFailureWithNotRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addCategoryPage.openCreateCategoryPage(3);
        addCategoryPage.createCategory(3);
        addCategoryPage.saveCategoryFailure(3);
    }
    @Test(priority = 4, dataProvider = "getAddCategoryDataHashTable", dataProviderClass = AddCategoryDataProvider.class)
    @Step("testCategoryDataProvider")
    public void addNewCategoryFailureWithEmptyField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addCategoryPage.openCreateCategoryPage(4);
        addCategoryPage.createCategory(4);
        addCategoryPage.saveCategoryFailure(4);
    }


}
