package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.AddProdModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddProdDataProvider {

    public AddProdDataProvider() {
    }

    @Test(dataProvider = "getAddProdsDataHashTable")
    public void testAddProdsData(Hashtable<String, String> data) {
        System.out.println("AddProds.ProductName = " + data.get(AddProdModal.getProductName()));
        System.out.println("AddProds.Category = " + data.get(AddProdModal.getCategory()));
        System.out.println("AddProds.Brand = " + data.get(AddProdModal.getBrand()));
        System.out.println("AddProds.Unit = " + data.get(AddProdModal.getUnit()));
        System.out.println("AddProds.Weight = " + data.get(AddProdModal.getWeight()));
        System.out.println("AddProds.MinPurchase = " + data.get(AddProdModal.getMinPurchase()));
        System.out.println("AddProds.Tags = " + data.get(AddProdModal.getTags()));
        System.out.println("AddProds.Barcode = " + data.get(AddProdModal.getBarcode()));
        System.out.println("AddProds.Refund = " + data.get(AddProdModal.getRefund()));
        System.out.println("AddProds.DashboardPageUrl = " + data.get(AddProdModal.getDashboardPageUrl()));
        System.out.println("AddProds.AddProdPageUrl = " + data.get(AddProdModal.getAddProdPageUrl()));
        System.out.println("AddProds.Unit = " + data.get(AddProdModal.getUnitPrice()));
        System.out.println("AddProds.DiscountDate = " + data.get(AddProdModal.getDiscountDate()));
        System.out.println("AddProds.DiscountPercent = " + data.get(AddProdModal.getDiscountPercent()));
        System.out.println("AddProds.Point = " + data.get(AddProdModal.getPoint()));
        System.out.println("AddProds.Quantity = " + data.get(AddProdModal.getQuantity()));
        System.out.println("AddProds.SUK = " + data.get(AddProdModal.getSuk()));
        System.out.println("AddProds.ExternalLink = " + data.get(AddProdModal.getExternalLink()));
        System.out.println("AddProds.ExternalTextLink = " + data.get(AddProdModal.getExternalTextLink()));
        System.out.println("AddProds.ProdDescription = " + data.get(AddProdModal.getProdDescription()));
        System.out.println("AddProds.MetaTitle = " + data.get(AddProdModal.getMetaTitle()));
        System.out.println("AddProds.MetaDescription = " + data.get(AddProdModal.getMetaDescription()));
        System.out.println("AddProds.ListProdsLink = " + data.get(AddProdModal.getListProdsLink()));
        System.out.println("AddProds.ProdVideoLink = " + data.get(AddProdModal.getProdVideoLink()));
    }

    @DataProvider(name = "getAddProdsDataHashTable")
    public static Object[][] getAddProdsData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod", 1, 1);
        return data;
    }

}
