package Setup.project.pages.Products;
import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.AddProdModal;
import Setup.project.modals.EditProdModal;
import Setup.project.modals.LoginModal;
import Setup.project.pages.Dashboard.DashBoardPage;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
public class AddNewProdPage {

    public By btnClearCache = ObjectUtils.getByLocatorFromConfig("btnClearCache");
    public By productMenu = ObjectUtils.getByLocatorFromConfig("productMenu");
    public By addProdSubMenu = ObjectUtils.getByLocatorFromConfig("addProdSubMenu");
    public By productName = ObjectUtils.getByLocatorFromConfig("productName");
    public By categoryDropdown = ObjectUtils.getByLocatorFromConfig("categoryDropdown");
    public By selectedOptionCategoryDropdown = ObjectUtils.getByLocatorFromConfig("selectedOptionCategoryDropdown");
    public By selectedOptionBrandDropdown = ObjectUtils.getByLocatorFromConfig("selectedOptionBrandDropdown");
    public By brandDropdown = ObjectUtils.getByLocatorFromConfig("brandDropdown");
    public By unitTbx = ObjectUtils.getByLocatorFromConfig("unitTbx");
    public By weightTbx = ObjectUtils.getByLocatorFromConfig("weightTbx");
    public By minPurchaseTbx = ObjectUtils.getByLocatorFromConfig("minPurchaseTbx");
    public By tagTbx = ObjectUtils.getByLocatorFromConfig("tagTbx");
    public By barcodeTbx = ObjectUtils.getByLocatorFromConfig("barcodeTbx");
    public By refundSwitchBtn = ObjectUtils.getByLocatorFromConfig("refundSwitchBtn");


    public By btnOpenScreenUploadGallery = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadGallery");
    public By btnOpenScreenUploadThumbnail = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadThumbnail");
    public By btnOpenScreenUploadPDF = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadPDF");
    public By image = ObjectUtils.getByLocatorFromConfig("image");
    public By tabSelectFile = ObjectUtils.getByLocatorFromConfig("tabSelectFile");
    public By tabUploadFile = ObjectUtils.getByLocatorFromConfig("tabUploadFile");
    public By uploadFile = ObjectUtils.getByLocatorFromConfig("uploadFile");
    public By filePath = ObjectUtils.getByLocatorFromConfig("filePath");
    public By uploadFileStatus = ObjectUtils.getByLocatorFromConfig("uploadFileStatus");
    public By fileName = ObjectUtils.getByLocatorFromConfig("fileName");
    public By btnAddMoreFile = ObjectUtils.getByLocatorFromConfig("btnAddMoreFile");
    public By btnAddFile = ObjectUtils.getByLocatorFromConfig("btnAddFile");
    public By btnCloseModal = ObjectUtils.getByLocatorFromConfig("btnCloseModal");

    public By sortDropdown = ObjectUtils.getByLocatorFromConfig("sortDropdown");
    public By btnSelectFile = ObjectUtils.getByLocatorFromConfig("btnSelectFile");
    public By selectedFile = ObjectUtils.getByLocatorFromConfig("selectedFile");
    public By capacityImage = ObjectUtils.getByLocatorFromConfig("capacityImage");
    public By searchFileTbx = ObjectUtils.getByLocatorFromConfig("searchFileTbx");
    public By fileTitle = ObjectUtils.getByLocatorFromConfig("fileTitle");


    public By colorDropdown = ObjectUtils.getByLocatorFromConfig("colorDropdown");
    public By selectedColorOption = ObjectUtils.getByLocatorFromConfig("selectedColorOption");
    public By btnSwitchColor = ObjectUtils.getByLocatorFromConfig("btnSwitchColor");
    public By attributeDropdown = ObjectUtils.getByLocatorFromConfig("attributeDropdown");
    public By selectedAttributeOption = ObjectUtils.getByLocatorFromConfig("selectedAttributeOption");
    public By searchTbxInDropdown = ObjectUtils.getByLocatorFromConfig("searchTbxInDropdown");
    public By sizeDropdown = ObjectUtils.getByLocatorFromConfig("sizeDropdown");
    public By selectedOption = ObjectUtils.getByLocatorFromConfig("selectedOption");


    public By videoProviderDropdown = ObjectUtils.getByLocatorFromConfig("videoProviderDropdown");
    public By videoLinkTbx = ObjectUtils.getByLocatorFromConfig("videoLinkTbx");

    public By unitPriceTbx = ObjectUtils.getByLocatorFromConfig("unitPriceTbx");
    public By discountDateDropdown = ObjectUtils.getByLocatorFromConfig("discountDateDropdown");
    public By btnSelectDate = ObjectUtils.getByLocatorFromConfig("btnSelectDate");
    public By discountPercentTbx = ObjectUtils.getByLocatorFromConfig("discountPercentTbx");
    public By optionDiscountTypeDropdown = ObjectUtils.getByLocatorFromConfig("optionDiscountTypeDropdown");
    public By discountTypeDropdown = ObjectUtils.getByLocatorFromConfig("discountTypeDropdown");
    public By pointTbx = ObjectUtils.getByLocatorFromConfig("pointTbx");
    public By quantityTbx = ObjectUtils.getByLocatorFromConfig("quantityTbx");
    public By sukTbx = ObjectUtils.getByLocatorFromConfig("sukTbx");
    public By externalLinkTbx = ObjectUtils.getByLocatorFromConfig("externalLinkTbx");
    public By externalLinkTextTbx = ObjectUtils.getByLocatorFromConfig("externalLinkTextTbx");
    public By prodDescription = ObjectUtils.getByLocatorFromConfig("prodDescription");


    public By metaTitle = ObjectUtils.getByLocatorFromConfig("metaTitle");
    public By metaDescription = ObjectUtils.getByLocatorFromConfig("metaDescription");
    public By btnOpenScreenUploadMeta = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadMeta");


    public By shippingDayTbx = ObjectUtils.getByLocatorFromConfig("shippingDayTbx");


    public By btnSaveUnpublish = ObjectUtils.getByLocatorFromConfig("btnSaveUnpublish");
    public By btnSavePublish = ObjectUtils.getByLocatorFromConfig("btnSavePublish");


    ExcelHelpers excelHelpers;

    public AddNewProdPage() {
        excelHelpers = new ExcelHelpers();
    }
    public ListProdsPage openAddNewProdPage(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddProdModal.getDashboardPageUrl())));
        WebUI.clickElement(productMenu);
        WebUI.clickElement(addProdSubMenu);
        WebUI.waitForPageLoaded();
        WebUI.clickElement(btnClearCache);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddProdModal.getAddProdPageUrl())));
        return new ListProdsPage();
    }

    public ListProdsPage addNewProdInfo(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(productName));
        WebUI.clearText(productName);
        WebUI.setText(productName, excelHelpers.getCellData(rowNum, AddProdModal.getProductName()));
        WebUI.selectOptionByValue(categoryDropdown,"60");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- Beauty & Health"));
        WebUI.selectOptionByValue(categoryDropdown,"22");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"-- Accessories"));
        WebUI.selectOptionByValue(categoryDropdown,"126");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- Luxury car"));
        WebUI.selectOptionByValue(categoryDropdown,"229");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- LED Panel Lights"));
        WebUI.clickElement(selectedOptionCategoryDropdown);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum, EditProdModal.getCategory()));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedOptionCategoryDropdown,excelHelpers.getCellData(rowNum,EditProdModal.getCategory())));

        WebUI.selectOptionByText(brandDropdown,"Honda");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionBrandDropdown,"Honda"));
        WebUI.selectOptionByText(brandDropdown,"Dior");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionBrandDropdown,"Dior"));
        WebUI.selectOptionByText(brandDropdown,"Pampers");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionBrandDropdown,"Pampers"));
        WebUI.selectOptionByText(brandDropdown,"Mercedes");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionBrandDropdown,"Mercedes"));
        WebUI.clickElement(selectedOptionBrandDropdown);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum,EditProdModal.getBrand()));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedOptionBrandDropdown,excelHelpers.getCellData(rowNum,EditProdModal.getBrand())));

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(unitTbx));
        WebUI.clearText(unitPriceTbx);
        WebUI.setText(unitTbx, excelHelpers.getCellData(rowNum, EditProdModal.getUnit()));

        Assert.assertFalse(WebUI.verifyHTML5RequiredField(weightTbx));
        WebUI.clearText(weightTbx);
        WebUI.setText(weightTbx, excelHelpers.getCellData(rowNum, AddProdModal.getWeight()));

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(minPurchaseTbx));
        WebUI.clearText(minPurchaseTbx);
        WebUI.setText(minPurchaseTbx, excelHelpers.getCellData(rowNum, AddProdModal.getMinPurchase()));

        WebUI.clickElement(tagTbx);
//        for (int i = 1; i <= 5;i++){
//            By tag = By.xpath("//div[1]/tags[1]/tag["+i+"]/div[1]/span[1]");
//            String tagText = excelHelpers.getCellData(rowNum,AddProdModal.getTags()) + i;
//            WebUI.pressCopyPaste(tagText);
//            WebUI.pressENTER();
//            Assert.assertTrue(WebUI.verifyElementTextEquals(tag,tagText));
//        }
//        for (int k = WebUI.getWebElements(tagOfNumber).size(); k > 1 ;k--){
//            By tag = By.xpath("//div[1]/tags[1]/tag["+k+"]/div[1]/span[1]");
//            By tagRemoveBtn = By.xpath("//div[1]/tags[1]/tag["+k+"]/x[1]");
//            WebUI.clickElement(tagRemoveBtn);
//            WebUI.sleep(0.3);
//            Assert.assertTrue(WebUI.verifyElementNotPresent(tag));
//        }
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum,AddProdModal.getTags()));
        WebUI.pressENTER();

        Assert.assertFalse(WebUI.verifyHTML5RequiredField(barcodeTbx));
        WebUI.setText(barcodeTbx, excelHelpers.getCellData(rowNum, AddProdModal.getBarcode()));

        WebUI.clickElement(refundSwitchBtn);
        WebUI.clickElement(refundSwitchBtn);
        return new ListProdsPage();
    }

    public ListProdsPage uploadGalleryImage(){
        // Upload gallery Image
        WebUI.scrollToElement(refundSwitchBtn);
        WebUI.clickElement(btnOpenScreenUploadGallery);
        WebUI.clickElement(tabUploadFile);
        WebUI.uploadMultiFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\Phantom1.jpg","C:\\Users\\Tanapoto\\Pictures\\ImageTest\\Phantom2.jpg");
        WebUI.clickElement(btnAddMoreFile);
        WebUI.uploadFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\Phantom3.jpg");
        for(int i = 1; i<= WebUI.getWebElements(fileName).size(); i++){
            By fileName = By.xpath("//div[2]/div[1]/ul[1]/li["+i+"]/div/div/div[@title]");
            Assert.assertTrue(WebUI.verifyElementTextContains(fileName,"Phantom"+i));
        }
        Assert.assertTrue(WebUI.verifyImagesIsNotBroken(uploadFile));
        Assert.assertTrue(WebUI.verifyElementTextEquals(uploadFileStatus,"Complete"));
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(2);

        //Select Gallery Image
        WebUI.clickElement(btnOpenScreenUploadGallery);
        WebUI.clickElementWithJs(tabSelectFile);
        for(int i = 1; i < 4; i++){
            By image = By.xpath("//body/div[@id='aizUploaderModal']/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div["+i+"]/div[1]/div[1]");
            WebUI.clickElement(image);
        }
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadGallery,"3"));
        WebUI.verifyImagesIsNotBroken(uploadFile);

        //Sort Gallery Image bt Smallest
        WebUI.clickElement(btnOpenScreenUploadGallery);
        WebUI.clickElement(tabSelectFile);
        WebUI.selectOptionByValue(sortDropdown,"smallest");
        WebUI.verifyTextWhenSortingBySmallest(capacityImage);
        //Sort Gallery Image bt Largest
        WebUI.selectOptionByValue(sortDropdown,"largest");
        WebUI.verifyTextWhenSortingByLargest(capacityImage);
        //Sort selected Image
        WebUI.clickElement(btnSelectFile);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(selectedFile,"data-selected","true"));
        WebUI.clickElement(btnSelectFile);
        //Search file
        WebUI.setText(searchFileTbx,"Phantom");
        WebUI.pressENTER();
        WebUI.pressENTER();
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.verifyElementTextContains(fileTitle,"Phantom"));
        WebUI.clickElementWithJs(btnCloseModal);
        return new ListProdsPage();
    }

    public ListProdsPage uploadThumbnailImage(){
        // Upload thumbnail Image
        WebUI.clickElement(btnOpenScreenUploadThumbnail);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
        return new ListProdsPage();
    }

    public ListProdsPage selectProdVariation(){
        //Handle color dropdown
        Assert.assertFalse(WebUI.verifyElementSelected(btnSwitchColor));
        Assert.assertTrue(WebUI.waitForElementHasAttribute(colorDropdown,"multiple"));
        WebUI.clickElementWithJs(btnSwitchColor);
        WebUI.selectOptionByValue(colorDropdown,"#F0F8FF");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedColorOption,"AliceBlue"));
        WebUI.selectOptionByValue(colorDropdown,"#F8F8FF");
        WebUI.selectOptionByValue(colorDropdown,"#C71585");
        WebUI.selectOptionByValue(colorDropdown,"#98FB98");
        WebUI.selectOptionByValue(colorDropdown,"#FA8072");
        WebUI.selectOptionByValue(colorDropdown,"#9ACD32");
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedColorOption,"6 items selected"));
        WebUI.clickElementWithJs(selectedColorOption);
        WebUI.setText(searchTbxInDropdown,"AliceBlue");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(selectedColorOption);
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedColorOption,"5 items selected"));
        WebUI.deselectOptionByValue(colorDropdown,"#F8F8FF");
        WebUI.deselectOptionByValue(colorDropdown,"#C71585");
        WebUI.deselectOptionByValue(colorDropdown,"#98FB98");
        WebUI.deselectOptionByValue(colorDropdown,"#FA8072");
        WebUI.deselectOptionByValue(colorDropdown,"#9ACD32");
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedColorOption,"Nothing selected"));

        //Handle Attributes dropdown
        Assert.assertTrue(WebUI.waitForElementHasAttribute(attributeDropdown,"multiple"));
        WebUI.selectOptionByValue(attributeDropdown,"1");
        WebUI.verifyElementTextContains(selectedAttributeOption,"Size");
        WebUI.selectOptionByValue(attributeDropdown,"2");
        WebUI.selectOptionByValue(attributeDropdown,"4");
        WebUI.selectOptionByValue(attributeDropdown,"5");
        WebUI.selectOptionByValue(attributeDropdown,"6");
        WebUI.sleep(3);
        WebUI.verifyElementTextContains(selectedAttributeOption,"5 items selected");
        WebUI.deselectOptionByValue(attributeDropdown,"1");
        WebUI.deselectOptionByValue(attributeDropdown,"2");
        WebUI.deselectOptionByValue(attributeDropdown,"4");
        WebUI.deselectOptionByValue(attributeDropdown,"5");
        WebUI.deselectOptionByValue(attributeDropdown,"6");
        WebUI.sleep(3);
        WebUI.verifyElementTextContains(selectedAttributeOption,"Nothing selected");
        WebUI.clickElementWithJs(selectedAttributeOption);
        WebUI.setText(searchTbxInDropdown,"Size");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(selectedAttributeOption);
        WebUI.verifyElementTextContains(selectedAttributeOption,"Size");

        //Handle sub-dropdown
        WebUI.selectOptionByValue(sizeDropdown,"M");
        WebUI.selectOptionByValue(sizeDropdown,"XL");
        WebUI.selectOptionByValue(sizeDropdown,"128GB");
        WebUI.selectOptionByValue(sizeDropdown,"512GB");
        WebUI.selectOptionByValue(sizeDropdown,"1TB");
        WebUI.verifyElementTextContains(selectedOption,"5");
        WebUI.deselectOptionByValue(sizeDropdown,"M");
        WebUI.deselectOptionByValue(sizeDropdown,"XL");
        WebUI.deselectOptionByValue(sizeDropdown,"128GB");
        WebUI.deselectOptionByValue(sizeDropdown,"512GB");
        WebUI.deselectOptionByValue(sizeDropdown,"1TB");
        WebUI.verifyElementTextContains(selectedOption,"Nothing selected");
        WebUI.clickElementWithJs(selectedOption);
        WebUI.setText(searchTbxInDropdown,"1TB");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(selectedOption);
        WebUI.verifyElementTextContains(selectedOption,"1");
        WebUI.deselectOptionByValue(attributeDropdown,"1");
        return new ListProdsPage();
    }

    public ListProdsPage inputVideoLink(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.selectOptionByValue(videoProviderDropdown,"dailymotion");
        WebUI.selectOptionByValue(videoProviderDropdown,"vimeo");
        WebUI.selectOptionByValue(videoProviderDropdown,"youtube");
        WebUI.sleep(1);
        WebUI.setText(videoLinkTbx,excelHelpers.getCellData(rowNum,AddProdModal.getProdVideoLink()));
        return new ListProdsPage();
    }

    public ListProdsPage inputPriceStock(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(unitPriceTbx));
        WebUI.clearText(unitPriceTbx);
        WebUI.setText(unitPriceTbx,excelHelpers.getCellData(rowNum,AddProdModal.getUnitPrice()));
        WebUI.clearText(discountDateDropdown);
        WebUI.setText(discountDateDropdown,excelHelpers.getCellData(rowNum,AddProdModal.getDiscountDate()));
        WebUI.clickElement(btnSelectDate);
        WebUI.clearText(discountPercentTbx);
        WebUI.setText(discountPercentTbx,excelHelpers.getCellData(rowNum,AddProdModal.getDiscountPercent()));
        WebUI.selectOptionByValue(optionDiscountTypeDropdown,"percent");
        Assert.assertTrue(WebUI.verifyElementTextContains(discountTypeDropdown,"Percent"));
        WebUI.selectOptionByValue(optionDiscountTypeDropdown,"amount");
        Assert.assertTrue(WebUI.verifyElementTextContains(discountTypeDropdown,"Flat"));
        WebUI.clearText(pointTbx);
        WebUI.setText(pointTbx,excelHelpers.getCellData(rowNum,AddProdModal.getPoint()));
        WebUI.clearText(quantityTbx);
        WebUI.setText(quantityTbx,excelHelpers.getCellData(rowNum,AddProdModal.getQuantity()));
        WebUI.clearText(sukTbx);
        WebUI.setText(sukTbx,excelHelpers.getCellData(rowNum,AddProdModal.getSuk()));
        WebUI.clearText(externalLinkTbx);
        WebUI.setText(externalLinkTbx,excelHelpers.getCellData(rowNum,AddProdModal.getExternalLink()));
        WebUI.clearText(externalLinkTextTbx);
        WebUI.setText(externalLinkTextTbx,excelHelpers.getCellData(rowNum,AddProdModal.getExternalTextLink()));

        return new ListProdsPage();
    }

    public ListProdsPage uploadFilePDF(){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.scrollToElement(prodDescription);
        // Upload PDF file
        WebUI.clickElement(btnOpenScreenUploadPDF);
        WebUI.clickElementWithJs(tabUploadFile);
        WebUI.uploadMultiFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\sample1.pdf","C:\\Users\\Tanapoto\\Pictures\\ImageTest\\sample2.pdf");
        WebUI.clickElement(btnAddMoreFile);
        WebUI.uploadFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\sample3.pdf");
        for(int i = 1; i<= WebUI.getWebElements(fileName).size(); i++){
            By fileName = By.xpath("//div[2]/div[1]/ul[1]/li["+i+"]/div/div/div[@title]");
            Assert.assertTrue(WebUI.verifyElementTextContains(fileName,"sample"+i));
        }
        Assert.assertTrue(WebUI.verifyImagesIsNotBroken(uploadFile));
        Assert.assertTrue(WebUI.verifyElementTextEquals(uploadFileStatus,"Complete"));
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(2);

        //Select File Image
        WebUI.clickElement(btnOpenScreenUploadPDF);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadPDF,"1"));

        return new ListProdsPage();
    }
    public ListProdsPage inputProdDescription(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.clearText(prodDescription);
        WebUI.setText(prodDescription,excelHelpers.getCellData(rowNum,AddProdModal.getProdDescription()));
        return new ListProdsPage();
    }
    public ListProdsPage inputSEOMeta(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");

        Assert.assertFalse(WebUI.verifyHTML5RequiredField(metaTitle));
        WebUI.clearText(metaTitle);
        WebUI.setText(metaTitle,excelHelpers.getCellData(rowNum,AddProdModal.getMetaTitle()));
        WebUI.clearText(metaDescription);
        WebUI.setText(metaDescription,excelHelpers.getCellData(rowNum,AddProdModal.getMetaDescription()));

        //Select File Image
        WebUI.clickElement(btnOpenScreenUploadMeta);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadPDF,"1"));

        return new ListProdsPage();
    }

    public ListProdsPage inputShippingDays(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Add_New_Prod");
        WebUI.clearText(shippingDayTbx);
        WebUI.setText(shippingDayTbx,excelHelpers.getCellData(rowNum,AddProdModal.getShippingDays()));
        return new ListProdsPage();
    }


    public ListProdsPage save_publish(){
        WebUI.clickElement(btnSavePublish);
        WebUI.sleep(5);
        return new ListProdsPage();
    }

    public ListProdsPage checkCreateProdSuccessfully(){
        Assert.assertTrue(WebUI.verifyPageUrl("https://demo.activeitzone.com/ecommerce/admin/products/store"));
        return new ListProdsPage();
    }
    public ListProdsPage checkCreateProdFailure(){
        Assert.assertFalse(WebUI.verifyPageUrl("https://demo.activeitzone.com/ecommerce/admin/products/store"));
        return new ListProdsPage();
    }
}
