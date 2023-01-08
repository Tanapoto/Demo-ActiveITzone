package Setup.project.pages.Products;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.AddProdModal;
import Setup.project.modals.EditProdModal;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ProdDetailPage {


    public By prodName = ObjectUtils.getByLocatorFromConfig("prodName");
    public By prodShippingTime = ObjectUtils.getByLocatorFromConfig("prodShippingTime");
    public By prodPrice = ObjectUtils.getByLocatorFromConfig("prodPrice");
    public By prodExternalLink = ObjectUtils.getByLocatorFromConfig("prodExternalLink");
    public By prodDescriptionTab = ObjectUtils.getByLocatorFromConfig("prodDescriptionTab");
    public By prodDescriptionDetail = ObjectUtils.getByLocatorFromConfig("prodDescriptionDetail");
    public By prodVideoTab = ObjectUtils.getByLocatorFromConfig("prodVideoTab");
    public By prodVideoLink = ObjectUtils.getByLocatorFromConfig("prodVideoLink");

    ExcelHelpers excelHelpers;

    public ProdDetailPage() {
        excelHelpers = new ExcelHelpers();
    }

    public ListProdsPage checkCreatedProdDetail(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        Assert.assertTrue(WebUI.verifyPageTitle(excelHelpers.getCellData(rowNum, AddProdModal.getProductName())));
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodName, excelHelpers.getCellData(rowNum, AddProdModal.getProductName())));
        Assert.assertTrue(WebUI.verifyElementTextContains(prodShippingTime, excelHelpers.getCellData(rowNum, AddProdModal.getShippingDays())));
        Assert.assertTrue(WebUI.verifyTextContains(WebUI.getTextElement(prodPrice).replace(",",""), excelHelpers.getCellData(1, AddProdModal.getUnitPrice())));
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodExternalLink, excelHelpers.getCellData(rowNum, AddProdModal.getExternalTextLink())));
        WebUI.clickElement(prodDescriptionTab);
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodDescriptionDetail, excelHelpers.getCellData(rowNum, AddProdModal.getProdDescription())));
        WebUI.clickElement(prodVideoTab);
        String prodVideoLink_ = WebUI.getAttributeElement(prodVideoLink, "src");
        Assert.assertTrue(WebUI.verifyTextContains(prodVideoLink_, excelHelpers.getCellData(rowNum, AddProdModal.getProdVideoLink())));
        return new ListProdsPage();
    }

    public ListProdsPage checkEditedProdDetail(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
        Assert.assertTrue(WebUI.verifyPageTitle(excelHelpers.getCellData(rowNum, EditProdModal.getProductName())));
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodName, excelHelpers.getCellData(rowNum, EditProdModal.getProductName())));
        Assert.assertTrue(WebUI.verifyElementTextContains(prodShippingTime, excelHelpers.getCellData(rowNum, EditProdModal.getShippingDays())));
        Assert.assertTrue(WebUI.verifyTextContains(WebUI.getTextElement(prodPrice).replace(",",""), excelHelpers.getCellData(1, EditProdModal.getUnitPrice())));
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodExternalLink, excelHelpers.getCellData(rowNum, EditProdModal.getExternalTextLink())));
        WebUI.clickElement(prodDescriptionTab);
        Assert.assertTrue(WebUI.verifyElementTextEquals(prodDescriptionDetail, excelHelpers.getCellData(rowNum, EditProdModal.getProdDescription())));
        WebUI.clickElement(prodVideoTab);
        String prodVideoLink_ = WebUI.getAttributeElement(prodVideoLink, "src").replace("https://www.youtube.com/embed/", "");
        Assert.assertTrue(WebUI.verifyTextContains(excelHelpers.getCellData(rowNum, EditProdModal.getProdVideoLink()),prodVideoLink_));
        return new ListProdsPage();
    }
}