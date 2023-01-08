package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.ListProdsDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.Products.AddNewProdPage;
import Setup.project.pages.Products.ListProdsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test Automation Practice")
@Feature("List Prods Test")
public class ListProdsTest extends BaseTest {

    LoginPage loginPage;
    AddNewProdPage addNewProdPage;
    ListProdsPage listProdsPage;

    public ListProdsTest() {
        loginPage = new LoginPage();
        listProdsPage = new ListProdsPage();
    }

    @Test(priority = 1, dataProvider = "getListProdsDataHashTable", dataProviderClass = ListProdsDataProvider.class)
    @Step("addProdTestDataProvider")
    public void filterProdsBySellersInListProds(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.filterBySeller(1);
        listProdsPage.filterBySeller(2);
        listProdsPage.filterBySeller(3);
        listProdsPage.filterBySeller(4);
        listProdsPage.filterBySeller(5);
    }

    @Test(priority = 2, dataProvider = "getListProdsDataHashTable", dataProviderClass = ListProdsDataProvider.class)
    @Step("addProdTestDataProvider")
    public void searchProdsByProdsNameInListProds(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.searchByProdsName(1);
        listProdsPage.searchByProdsName(2);
        listProdsPage.searchByProdsName(3);
        listProdsPage.searchByProdsName(4);
        listProdsPage.searchByProdsName(5);
    }

    @Test(priority = 3, dataProvider = "getListProdsDataHashTable", dataProviderClass = ListProdsDataProvider.class)
    @Step("addProdTestDataProvider")
    public void deleteProdsInListProds(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.deleteProd(5);
    }
}
