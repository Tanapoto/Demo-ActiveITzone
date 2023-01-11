package TestCase.Products;
import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.AddProdDataProvider;
import Setup.project.dataprovider.LoginDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.Products.AddNewProdPage;
import Setup.project.pages.Products.ListProdsPage;
import Setup.project.pages.Products.ProdDetailPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;

import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test Automation Practice")
@Feature("Add New Prods Test")
public class AddNewProdTest extends BaseTest{

    LoginPage loginPage;
    AddNewProdPage addNewProdPage;
    ListProdsPage listProdsPage;
    ProdDetailPage prodDetailPage;
    public AddNewProdTest() {
        loginPage = new LoginPage();
        addNewProdPage = new AddNewProdPage();
        listProdsPage = new ListProdsPage();
        prodDetailPage = new ProdDetailPage();
    }

    @Test(priority = 1, dataProvider = "getAddProdsDataHashTable", dataProviderClass = AddProdDataProvider.class)
    @Step("addProdTestDataProvider")
    public void addNewProdSuccessfullyWithAllField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addNewProdPage.openAddNewProdPage(1);
        addNewProdPage.addNewProdInfo(1);
        addNewProdPage.uploadGalleryImage();
        addNewProdPage.uploadThumbnailImage();
        addNewProdPage.inputVideoLink(1);
        addNewProdPage.selectProdVariation();
        addNewProdPage.inputPriceStock(1);
        addNewProdPage.inputProdDescription(1);
        addNewProdPage.uploadFilePDF();
        addNewProdPage.inputSEOMeta(1);
        addNewProdPage.inputShippingDays(1);
        addNewProdPage.save_publish();
        listProdsPage.openListProdPage();
        listProdsPage.checkCreatedProd(1);
        prodDetailPage.checkCreatedProdDetail(1);
    }


    @Test(priority = 2, dataProvider = "getAddProdsDataHashTable", dataProviderClass = AddProdDataProvider.class)
    @Step("addProdTestDataProvider")
    public void addNewProdSuccessfullyWithRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addNewProdPage.openAddNewProdPage(2);
        addNewProdPage.addNewProdInfo(2);
        addNewProdPage.inputPriceStock(2);
        addNewProdPage.save_publish();
        addNewProdPage.checkCreateProdSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.checkCreatedProd(2);
        prodDetailPage.checkCreatedProdDetail(2);
    }

    @Test(priority = 3, dataProvider = "getAddProdsDataHashTable", dataProviderClass = AddProdDataProvider.class)
    @Step("addProdTestDataProvider")
    public void addNewProdFailureWithNotRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addNewProdPage.openAddNewProdPage(3);
        addNewProdPage.addNewProdInfo(3);
        addNewProdPage.inputPriceStock(3);
        addNewProdPage.save_publish();
        addNewProdPage.checkCreateProdFailure();
    }


    @Test(priority = 4, dataProvider = "getAddProdsDataHashTable", dataProviderClass = AddProdDataProvider.class)
    @Step("addProdTestDataProvider")
    public void addNewProdFailureWithNotEmptyData(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        addNewProdPage.openAddNewProdPage(4);
        addNewProdPage.addNewProdInfo(4);
        addNewProdPage.inputPriceStock(4);
        addNewProdPage.save_publish();
        addNewProdPage.checkCreateProdFailure();
    }

}
