package Setup.project.dataprovider;

import Common.constants.FrameworkConstants;
import Common.helpers.ExcelHelpers;
import Common.helpers.Helpers;
import Setup.project.modals.EditCategoryModal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class EditCategoryDataProvider {


    private EditCategoryDataProvider() {
    }

    @Test(dataProvider = "getEditCategoryDataHashTable")
    public void testGetCategoryData(Hashtable<String, String> data) {
        System.out.println("EditCategory.CategoryName = " + data.get(EditCategoryModal.getCategoryName()));
        System.out.println("EditCategory.ParentCategory = " + data.get(EditCategoryModal.getParentCategory()));
        System.out.println("EditCategory.OrderNumber = " + data.get(EditCategoryModal.getOrderNumber()));
        System.out.println("EditCategory.CategoryTitle = " + data.get(EditCategoryModal.getCategoryTitle()));
        System.out.println("EditCategory.CategoryDescription = " + data.get(EditCategoryModal.getCategoryDescription()));
        System.out.println("EditCategory.FilteringAttribute = " + data.get(EditCategoryModal.getFilteringAttribute()));
        System.out.println("EditCategory.LinkListCategory = " + data.get(EditCategoryModal.getLinkListCategory()));
        System.out.println("EditCategory.LinkCreateCategory = " + data.get(EditCategoryModal.getLinkEditCategory()));

    }


    @DataProvider(name = "getEditCategoryDataHashTable")
    public static Object[][] getCategoryData() {
        ExcelHelpers excelHelpers = new ExcelHelpers();
        Object[][] data = excelHelpers.getDataHashTable(Helpers.getCurrentDir() + FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category", 1, 1);
        return data;
    }
}
