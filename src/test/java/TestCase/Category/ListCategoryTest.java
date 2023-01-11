package TestCase.Category;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.AddCategoryDataProvider;
import Setup.project.dataprovider.ListCategoryDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.ProductsCategory.AddCategoryPage;
import Setup.project.pages.ProductsCategory.ListCategoryPage;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ListCategoryTest extends BaseTest {


    LoginPage loginPage;
    AddCategoryPage addCategoryPage;
    ListCategoryPage listCategoryPage;
    public ListCategoryTest() {
        loginPage = new LoginPage();
        addCategoryPage= new AddCategoryPage();
        listCategoryPage = new ListCategoryPage();
    }

    @Test(priority = 1, dataProvider = "getListCategoryDataHashTable", dataProviderClass = ListCategoryDataProvider.class)
    @Step("testListCategoryData")
    public void searchCategoryInListCategory(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        listCategoryPage.openListCategoryPage();
        listCategoryPage.searchByCategoryName(1);
        listCategoryPage.searchByCategoryName(2);
        listCategoryPage.searchByCategoryName(3);
    }

    @Test(priority = 2, dataProvider = "getListCategoryDataHashTable", dataProviderClass = ListCategoryDataProvider.class)
    @Step("testListCategoryData")
    public void deleteCategoryInListCategory(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        listCategoryPage.openListCategoryPage();
        listCategoryPage.deleteCategory(3);
    }

}
