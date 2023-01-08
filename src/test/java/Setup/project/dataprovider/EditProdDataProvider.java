package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.EditProdModal;
import Setup.project.modals.EditProdModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class EditProdDataProvider {

    public EditProdDataProvider() {
    }

    @Test(dataProvider = "getEditProdsDataHashTable")
    public void testEditProdsData(Hashtable<String, String> data) {
        System.out.println("EditProds.ProductName = " + data.get(EditProdModal.getProductName()));
        System.out.println("EditProds.Category = " + data.get(EditProdModal.getCategory()));
        System.out.println("EditProds.Brand = " + data.get(EditProdModal.getBrand()));
        System.out.println("EditProds.Unit = " + data.get(EditProdModal.getUnit()));
        System.out.println("EditProds.Weight = " + data.get(EditProdModal.getWeight()));
        System.out.println("EditProds.MinPurchase = " + data.get(EditProdModal.getMinPurchase()));
        System.out.println("EditProds.Tags = " + data.get(EditProdModal.getTags()));
        System.out.println("EditProds.Barcode = " + data.get(EditProdModal.getBarcode()));
        System.out.println("EditProds.Refund = " + data.get(EditProdModal.getRefund()));
        System.out.println("EditProds.DashboardPageUrl = " + data.get(EditProdModal.getDashboardPageUrl()));
        System.out.println("EditProds.AddProdPageUrl = " + data.get(EditProdModal.getAddProdPageUrl()));
        System.out.println("EditProds.Unit = " + data.get(EditProdModal.getUnitPrice()));
        System.out.println("EditProds.DiscountDate = " + data.get(EditProdModal.getDiscountDate()));
        System.out.println("EditProds.DiscountPercent = " + data.get(EditProdModal.getDiscountPercent()));
        System.out.println("EditProds.Point = " + data.get(EditProdModal.getPoint()));
        System.out.println("EditProds.Quantity = " + data.get(EditProdModal.getQuantity()));
        System.out.println("EditProds.SUK = " + data.get(EditProdModal.getSuk()));
        System.out.println("EditProds.ExternalLink = " + data.get(EditProdModal.getExternalLink()));
        System.out.println("EditProds.ExternalTextLink = " + data.get(EditProdModal.getExternalTextLink()));
        System.out.println("EditProds.ProdDescription = " + data.get(EditProdModal.getProdDescription()));
        System.out.println("EditProds.MetaTitle = " + data.get(EditProdModal.getMetaTitle()));
        System.out.println("EditProds.MetaDescription = " + data.get(EditProdModal.getMetaDescription()));
        System.out.println("EditProds.ListProdsLink = " + data.get(EditProdModal.getListProdsLink()));
        System.out.println("EditProds.ProdVideoLink = " + data.get(EditProdModal.getProdVideoLink()));
    }

    @DataProvider(name = "getEditProdsDataHashTable")
    public static Object[][] getEditProdsData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod", 1, 1);
        return data;
    }

}
