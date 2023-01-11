package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.ListCategoryModal;
import Setup.project.modals.ListProdsModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ListCategoryDataProvider {

    private ListCategoryDataProvider() {
    }

    @Test(dataProvider = "getListCategoryDataHashTable")
    public void testGetCategoryData(Hashtable<String, String> data) {
        System.out.println("ListCategory.Sellers = " + data.get(ListCategoryModal.getKeywordSearch()));

    }


    @DataProvider(name = "getListCategoryDataHashTable")
    public static Object[][] getListCategoryData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "List_Category", 1, 1);
        return data;
    }
}
