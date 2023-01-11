package Setup.project.pages.ProductsCategory;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.Log;
import Common.utilities.ObjectUtils;
import Setup.project.modals.*;
import Setup.project.pages.Products.ListProdsPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ListCategoryPage {
    public By tbxSearchCategory = ObjectUtils.getByLocatorFromConfig("tbxSearchCategory");
    public By btnNextPageCategory = ObjectUtils.getByLocatorFromConfig("btnNextPageCategory");
    public By searchResultInCategory = ObjectUtils.getByLocatorFromConfig("searchResultInCategory");
    public By numberOfPagingCategory = ObjectUtils.getByLocatorFromConfig("numberOfPagingCategory");
    public By btnCancelDeleteCategory = ObjectUtils.getByLocatorFromConfig("btnCancelDeleteCategory");
    public By btnConfirmDeleteCategory = ObjectUtils.getByLocatorFromConfig("btnConfirmDeleteCategory");
    public By messDeleteCategorySuccess = ObjectUtils.getByLocatorFromConfig("messDeleteCategorySuccess");

    ExcelHelpers excelHelpers;

    public ListCategoryPage() {
        excelHelpers = new ExcelHelpers();
    }

    public ListCategoryPage openListCategoryPage() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");
        WebUI.navigateToUrl(excelHelpers.getCellData(1, AddCategoryModal.getLinkListCategory()));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1, AddCategoryModal.getLinkListCategory())));
        return new ListCategoryPage();
    }

    public ListCategoryPage checkCreatedCategory(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");

        WebUI.clearText(tbxSearchCategory);
        WebUI.setText(tbxSearchCategory, excelHelpers.getCellData(rowNum, AddCategoryModal.getCategoryName()));
        WebUI.pressENTER();
        WebUI.sleep(2);

        if (WebUI.getWebElements(searchResultInCategory).size() < 1) {
            Log.info("Not found value: " + searchResultInCategory);
        } else {
            for (int i = 1; i <= WebUI.getWebElements(searchResultInCategory).size(); i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                By parentCategory = By.xpath("//tbody/tr[" + i + "]/td[3]");
                WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, AddCategoryModal.getCategoryName()));
                WebUI.verifyElementTextContains(parentCategory, excelHelpers.getCellData(rowNum, AddCategoryModal.getParentCategory()));
            }
        }
        return new ListCategoryPage();
    }

    public ListCategoryPage checkEditedCategory(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Category");

        WebUI.clearText(tbxSearchCategory);
        WebUI.setText(tbxSearchCategory, excelHelpers.getCellData(rowNum, EditCategoryModal.getCategoryName()));
        WebUI.pressENTER();
        WebUI.sleep(2);

        if (WebUI.getWebElements(searchResultInCategory).size() < 1) {
            Log.info("Not found value: " + searchResultInCategory);
        } else {
            for (int i = 1; i <= WebUI.getWebElements(searchResultInCategory).size(); i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                By parentCategory = By.xpath("//tbody/tr[" + i + "]/td[3]");
                WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, EditCategoryModal.getCategoryName()));
                WebUI.verifyElementTextContains(parentCategory, excelHelpers.getCellData(rowNum, EditCategoryModal.getParentCategory()));
            }
        }
        return new ListCategoryPage();
    }

    public ListCategoryPage deleteCategory(int number) {

        if (WebUI.getWebElements(searchResultInCategory).size() < 1) {
            Log.info("Not found value: " + searchResultInCategory);
        } else {
            for (int i = 1; i <= number; i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                WebUI.scrollToElement(prodName);
                String oldProdNameText = WebUI.getTextElement(prodName);
                By btnDelete = By.xpath("//tbody/tr[" + i + "]/td[10]/a[2]");
                WebUI.clickElementWithJs(btnDelete);
                WebUI.clickElement(btnCancelDeleteCategory);
                WebUI.clickElementWithJs(btnDelete);
                WebUI.clickElement(btnConfirmDeleteCategory);
                WebUI.waitForPageLoaded();
                Assert.assertTrue(WebUI.verifyElementPresent(messDeleteCategorySuccess));
                Assert.assertFalse(WebUI.verifyElementTextEquals(prodName, oldProdNameText));
            }
        }
        return new ListCategoryPage();
    }

    public ListCategoryPage searchByCategoryName(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "List_Category");
        WebUI.clearText(tbxSearchCategory);
        WebUI.setText(tbxSearchCategory, excelHelpers.getCellData(rowNum, ListCategoryModal.getKeywordSearch()));
        WebUI.pressENTER();

        int pageSize = WebUI.verifyElementExists(numberOfPagingCategory) ? WebUI.getWebElements(numberOfPagingCategory).size() - 2 : 1;
        for (int k = 1; k <= pageSize; k++) {
            if (WebUI.getWebElements(searchResultInCategory).size() < 1) {
                Log.info("Not found value: " + searchResultInCategory);
            } else {
                for (int i = 1; i <= WebUI.getWebElements(searchResultInCategory).size(); i++) {
                    By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                    WebUI.scrollToElement(prodName);
                    Assert.assertTrue(WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, ListCategoryModal.getKeywordSearch())));
                }
                if (pageSize != k) {
                    WebUI.clickElement(btnNextPageCategory);
                    WebUI.waitForPageLoaded();
                    WebUI.sleep(2);
                }
            }
        }
        return new ListCategoryPage();
    }
}
