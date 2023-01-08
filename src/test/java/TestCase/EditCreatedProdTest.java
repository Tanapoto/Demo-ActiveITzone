package TestCase;

import Setup.baseSetUp.BaseTest;
import Setup.project.dataprovider.EditProdDataProvider;
import Setup.project.pages.Login.LoginPage;
import Setup.project.pages.Products.AddNewProdPage;
import Setup.project.pages.Products.EditCreatedProdPage;
import Setup.project.pages.Products.ListProdsPage;
import Setup.project.pages.Products.ProdDetailPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Test;

import java.util.Hashtable;

@Epic("Regression Test Automation Practice")
@Feature("Add New Prods Test")
public class EditCreatedProdTest extends BaseTest {

    LoginPage loginPage;
    AddNewProdPage addNewProdPage;
    ListProdsPage listProdsPage;
    ProdDetailPage prodDetailPage;
    EditCreatedProdPage editCreatedProdPage;

    public EditCreatedProdTest() {
        loginPage = new LoginPage();
        addNewProdPage = new AddNewProdPage();
        listProdsPage = new ListProdsPage();
        prodDetailPage = new ProdDetailPage();
        editCreatedProdPage = new EditCreatedProdPage();
    }

    @Test(priority = 1, dataProvider = "getEditProdsDataHashTable", dataProviderClass = EditProdDataProvider.class)
    @Step("editProdTestDataProvider")
    public void editedProdSuccessfullyWithAllField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCreatedProdPage.openEditProdPage();
        editCreatedProdPage.editProdInfo(1);
        editCreatedProdPage.uploadGalleryImage();
        editCreatedProdPage.uploadThumbnailImage();
        editCreatedProdPage.editVideoLink(1);
//        editCreatedProdPage.editSelectProdVariation();
        editCreatedProdPage.editPriceStock(1);
        editCreatedProdPage.editFilePDF();
        editCreatedProdPage.editProdDescription(1);
        editCreatedProdPage.editSEOMeta(1);
        editCreatedProdPage.editShippingDays(1);
        editCreatedProdPage.saveEdit();
        editCreatedProdPage.checkEditProdSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.checkEditedProd(1);
        prodDetailPage.checkEditedProdDetail(1);
    }

    @Test(priority = 2, dataProvider = "getEditProdsDataHashTable", dataProviderClass = EditProdDataProvider.class)
    @Step("editProdTestDataProvider")
    public void editedProdSuccessfullyWithRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCreatedProdPage.openEditProdPage();
        editCreatedProdPage.editProdInfo(2);
        editCreatedProdPage.editVideoLink(2);
        editCreatedProdPage.editPriceStock(2);
        editCreatedProdPage.editProdDescription(2);
        editCreatedProdPage.editSEOMeta(2);
        editCreatedProdPage.editShippingDays(2);
        editCreatedProdPage.saveEdit();
        editCreatedProdPage.checkEditProdSuccessfully();
        listProdsPage.openListProdPage();
        listProdsPage.checkEditedProd(2);
    }

    @Test(priority = 3, dataProvider = "getEditProdsDataHashTable", dataProviderClass = EditProdDataProvider.class)
    @Step("editProdTestDataProvider")
    public void editedProdFailureWithNotRequiredField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCreatedProdPage.openEditProdPage();
        editCreatedProdPage.editProdInfo(3);
        editCreatedProdPage.editVideoLink(3);
        editCreatedProdPage.editPriceStock(3);
        editCreatedProdPage.editProdDescription(3);
        editCreatedProdPage.editShippingDays(3);
        editCreatedProdPage.saveEdit();
        editCreatedProdPage.checkEditProdFailure();
    }


    @Test(priority = 4, dataProvider = "getEditProdsDataHashTable", dataProviderClass = EditProdDataProvider.class)
    @Step("editProdTestDataProvider")
    public void editedProdFailureWithEmptyField(Hashtable<String, String> data) {
        loginPage.loginSuccessfully();
        editCreatedProdPage.openEditProdPage();
        editCreatedProdPage.editProdInfo(4);
        editCreatedProdPage.editVideoLink(4);
        editCreatedProdPage.editPriceStock(4);
        editCreatedProdPage.editProdDescription(4);
        editCreatedProdPage.editShippingDays(4);
        editCreatedProdPage.saveEdit();
        editCreatedProdPage.checkEditProdFailure();
    }
}