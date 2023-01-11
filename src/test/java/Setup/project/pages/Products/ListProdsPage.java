package Setup.project.pages.Products;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.Log;
import Common.utilities.ObjectUtils;
import Setup.project.modals.AddProdModal;
import Setup.project.modals.EditProdModal;
import Setup.project.modals.ListProdsModal;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ListProdsPage {

    public By filterBySellerInLP = ObjectUtils.getByLocatorFromConfig("filterBySellerInLP");
    public By sortInLP = ObjectUtils.getByLocatorFromConfig("sortInLP");
    public By searchTbxInLP = ObjectUtils.getByLocatorFromConfig("searchTbxInLP");
    public By searchResultInLP = ObjectUtils.getByLocatorFromConfig("searchResultInLP");
    public By btnCloseModalIntroduce = ObjectUtils.getByLocatorFromConfig("btnCloseModalIntroduce");
    public By btnNextPage = ObjectUtils.getByLocatorFromConfig("btnNextPage");
    public By numberOfPaging = ObjectUtils.getByLocatorFromConfig("numberOfPaging");

    public By btnCancelDelete = ObjectUtils.getByLocatorFromConfig("btnCancelDelete");
    public By btnConfirmDelete = ObjectUtils.getByLocatorFromConfig("btnConfirmDelete");
    public By messDeleteProdSuccess = ObjectUtils.getByLocatorFromConfig("messDeleteProdSuccess");


    ExcelHelpers excelHelpers;

    public ListProdsPage() {
        excelHelpers = new ExcelHelpers();
    }

    public ListProdsPage openListProdPage() {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.navigateToUrl(excelHelpers.getCellData(1, AddProdModal.getListProdsLink()));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(1, AddProdModal.getListProdsLink())));
        return new ListProdsPage();
    }

    public ListProdsPage checkCreatedProd(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");

        WebUI.clearText(searchTbxInLP);
        WebUI.setText(searchTbxInLP, excelHelpers.getCellData(rowNum, AddProdModal.getProductName()));
        WebUI.pressENTER();
        WebUI.sleep(2);

        if (WebUI.getWebElements(searchResultInLP).size() < 1) {
            Log.info("Not found value: " + searchResultInLP);
        } else {
            for (int i = 1; i <= WebUI.getWebElements(searchResultInLP).size(); i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                By viewProdDetail = By.xpath("//tbody/tr[" + i + "]/td[9]/a[1]/i[1]");
                if (WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, AddProdModal.getProductName()))) {
                    WebUI.clickElement(viewProdDetail);
                    WebUI.switchToWindowOrTab(1);
                }
            }
            WebUI.clickElement(btnCloseModalIntroduce);
        }
        return new ListProdsPage();
    }

    public ListProdsPage checkEditedProd(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");

        WebUI.clearText(searchTbxInLP);
        WebUI.setText(searchTbxInLP, excelHelpers.getCellData(rowNum, EditProdModal.getProductName()));
        WebUI.pressENTER();
        WebUI.sleep(2);

        if (WebUI.getWebElements(searchResultInLP).size() < 1) {
            Log.info("Not found value: " + searchResultInLP);
        } else {
            for (int i = 1; i <= WebUI.getWebElements(searchResultInLP).size(); i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                By viewProdDetail = By.xpath("//tbody/tr[" + i + "]/td[9]/a[1]/i[1]");
                if (WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, EditProdModal.getProductName()))) {
                    WebUI.clickElement(viewProdDetail);
                    WebUI.switchToWindowOrTab(1);
                }
            }
            WebUI.clickElement(btnCloseModalIntroduce);
        }
        return new ListProdsPage();
    }

    public ListProdsPage filterBySeller(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "List_Prods");

        WebUI.selectOptionByText(sortInLP, excelHelpers.getCellData(rowNum, ListProdsModal.getSellers()));
        WebUI.waitForPageLoaded();
        int pageSize = WebUI.verifyElementExists(numberOfPaging) ? WebUI.getWebElements(numberOfPaging).size() - 2 : 1;
        for (int k = 1; k <= pageSize; k++) {
            if (WebUI.getWebElements(searchResultInLP).size() < 1) {
                Log.info("Not found value: " + searchResultInLP);
            } else {
                for (int i = 1; i <= WebUI.getWebElements(searchResultInLP).size(); i++) {
                    By prodSeller = By.xpath("//tbody/tr[" + i + "]/td[3]");
                    WebUI.scrollToElement(prodSeller);
                    Assert.assertTrue(WebUI.verifyElementTextEquals(prodSeller, excelHelpers.getCellData(rowNum, ListProdsModal.getSellers())));
                }
                if (pageSize != k) {
                    WebUI.clickElement(btnNextPage);
                    WebUI.waitForPageLoaded();
                }
            }
        }
        return new ListProdsPage();
    }

    public ListProdsPage searchByProdsName(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "List_Prods");
        WebUI.clearText(searchTbxInLP);
        WebUI.setText(searchTbxInLP, excelHelpers.getCellData(rowNum, ListProdsModal.getKeywordSearch()));
        WebUI.pressENTER();

        int pageSize = WebUI.verifyElementExists(numberOfPaging) ? WebUI.getWebElements(numberOfPaging).size() - 2 : 1;
        for (int k = 1; k <= pageSize; k++) {
            if (WebUI.getWebElements(searchResultInLP).size() < 1) {
                Log.info("Not found value: " + searchResultInLP);
            } else {
                for (int i = 1; i <= WebUI.getWebElements(searchResultInLP).size(); i++) {
                    By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                    WebUI.scrollToElement(prodName);
                    Assert.assertTrue(WebUI.verifyElementTextContains(prodName, excelHelpers.getCellData(rowNum, ListProdsModal.getKeywordSearch())));
                }
                if (pageSize != k) {
                    WebUI.clickElement(btnNextPage);
                    WebUI.waitForPageLoaded();
                    WebUI.sleep(2);
                }
            }
        }
        return new ListProdsPage();
    }

    public ListProdsPage deleteProd(int number) {

        if (WebUI.getWebElements(searchResultInLP).size() < 1) {
            Log.info("Not found value: " + searchResultInLP);
        } else {
            for (int i = 1; i <= number; i++) {
                By prodName = By.xpath("//tbody/tr[" + i + "]/td[2]");
                WebUI.scrollToElement(prodName);
                String oldProdNameText = WebUI.getTextElement(prodName);
                By btnDelete = By.xpath("//tbody/tr[" + i + "]/td[9]/a[4]");
                WebUI.clickElement(btnDelete);
                WebUI.clickElement(btnCancelDelete);
                WebUI.clickElement(btnDelete);
                WebUI.clickElement(btnConfirmDelete);
                WebUI.waitForPageLoaded();
                Assert.assertTrue(WebUI.verifyElementPresent(messDeleteProdSuccess));
                Assert.assertFalse(WebUI.verifyElementTextEquals(prodName, oldProdNameText));
            }
        }
        return new ListProdsPage();
    }

}
