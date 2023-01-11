package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.AddCategoryModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddCategoryDataProvider {


    private AddCategoryDataProvider() {
    }

    @Test(dataProvider = "getAddCategoryDataHashTable")
    public void testGetCategoryData(Hashtable<String, String> data) {
        System.out.println("AddCategory.CategoryName = " + data.get(AddCategoryModal.getCategoryName()));
        System.out.println("AddCategory.ParentCategory = " + data.get(AddCategoryModal.getParentCategory()));
        System.out.println("AddCategory.OrderNumber = " + data.get(AddCategoryModal.getOrderNumber()));
        System.out.println("AddCategory.CategoryTitle = " + data.get(AddCategoryModal.getCategoryTitle()));
        System.out.println("AddCategory.CategoryDescription = " + data.get(AddCategoryModal.getCategoryDescription()));
        System.out.println("AddCategory.FilteringAttribute = " + data.get(AddCategoryModal.getFilteringAttribute()));
        System.out.println("AddCategory.LinkListCategory = " + data.get(AddCategoryModal.getLinkListCategory()));
        System.out.println("AddCategory.LinkCreateCategory = " + data.get(AddCategoryModal.getLinkCreateCategory()));

    }


    @DataProvider(name = "getAddCategoryDataHashTable")
    public static Object[][] getCategoryData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category", 1, 1);
        return data;
    }
}
