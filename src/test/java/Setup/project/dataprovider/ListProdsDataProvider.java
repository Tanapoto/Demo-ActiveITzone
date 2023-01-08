package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.ListProdsModal;
import Setup.project.modals.LoginModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ListProdsDataProvider {

    private ListProdsDataProvider() {
    }

    @Test(dataProvider = "getListProdsDataHashTable")
    public void testGetLoginData(Hashtable<String, String> data) {
        System.out.println("listProds.Sellers = " + data.get(ListProdsModal.getSellers()));
        System.out.println("listProds.KeywordSearch = " + data.get(ListProdsModal.getKeywordSearch()));

    }


    @DataProvider(name = "getListProdsDataHashTable")
    public static Object[][] getListProdsData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "List_Prods", 1, 1);
        return data;
    }
}
