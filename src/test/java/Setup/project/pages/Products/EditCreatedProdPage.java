package Setup.project.pages.Products;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.AddProdModal;
import Setup.project.modals.EditProdModal;
import org.apache.xmlbeans.impl.xb.xsdschema.FieldDocument;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EditCreatedProdPage {

    public By btnClearCache = ObjectUtils.getByLocatorFromConfig("btnClearCache");
    public By productMenu = ObjectUtils.getByLocatorFromConfig("productMenu");
    public By addProdSubMenu = ObjectUtils.getByLocatorFromConfig("addProdSubMenu");
    public By listProdsSubMenu = ObjectUtils.getByLocatorFromConfig("listProdsSubMenu");
    public By btnEditTheNewestProds = ObjectUtils.getByLocatorFromConfig("btnEditTheNewestProds");
    public By titleEditPage = ObjectUtils.getByLocatorFromConfig("titleEditPage");
    public By productName = ObjectUtils.getByLocatorFromConfig("productName");
    public By categoryDropdown = ObjectUtils.getByLocatorFromConfig("categoryDropdown");
    public By selectedOptionCategoryDropdown = ObjectUtils.getByLocatorFromConfig("selectedOptionCategoryDropdown");
    public By editCategory_BrandSearchTbx = ObjectUtils.getByLocatorFromConfig("editCategory_BrandSearchTbx");
    public By numOfOption = ObjectUtils.getByLocatorFromConfig("numOfOption");
    public By brandDropdown = ObjectUtils.getByLocatorFromConfig("brandDropdown");
    public By selectedOptionBrandDropdown = ObjectUtils.getByLocatorFromConfig("selectedOptionBrandDropdown");
    public By unitTbx = ObjectUtils.getByLocatorFromConfig("unitTbx");
    public By weightTbx = ObjectUtils.getByLocatorFromConfig("weightTbx");
    public By minPurchaseTbx = ObjectUtils.getByLocatorFromConfig("minPurchaseTbx");
    public By tagTbx = ObjectUtils.getByLocatorFromConfig("tagTbx");
    public By tagOfNumber = ObjectUtils.getByLocatorFromConfig("tagOfNumber");
    public By barcodeTbx = ObjectUtils.getByLocatorFromConfig("barcodeTbx");
    public By refundSwitchBtn = ObjectUtils.getByLocatorFromConfig("refundSwitchBtn");


    public By btnOpenScreenUploadGallery = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadGallery");
    public By btnOpenScreenUploadThumbnail = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadThumbnail");
    public By btnOpenScreenUploadPDF = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadPDF");
    public By tabSelectFile = ObjectUtils.getByLocatorFromConfig("tabSelectFile");
    public By tabUploadFile = ObjectUtils.getByLocatorFromConfig("tabUploadFile");
    public By uploadFile = ObjectUtils.getByLocatorFromConfig("uploadFile");
    public By filePath = ObjectUtils.getByLocatorFromConfig("filePath");
    public By uploadFileStatus = ObjectUtils.getByLocatorFromConfig("uploadFileStatus");
    public By fileName = ObjectUtils.getByLocatorFromConfig("fileName");
    public By image = ObjectUtils.getByLocatorFromConfig("image");
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
    public By btnSwitchColorEditProd = ObjectUtils.getByLocatorFromConfig("btnSwitchColorEditProd");
    public By attributeDropdown = ObjectUtils.getByLocatorFromConfig("attributeDropdown");
    public By selectedAttributeOption = ObjectUtils.getByLocatorFromConfig("selectedAttributeOption");
    public By searchTbxInDropdown = ObjectUtils.getByLocatorFromConfig("searchTbxInDropdown");
    public By sizeDropdown = ObjectUtils.getByLocatorFromConfig("sizeDropdown");
    public By selectedSizeDropdown = ObjectUtils.getByLocatorFromConfig("selectedSizeDropdown");
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

    public By btnSaveEdit = ObjectUtils.getByLocatorFromConfig("btnSaveEdit");
    public By messEditSuccessfully = ObjectUtils.getByLocatorFromConfig("messEditSuccessfully");

    ExcelHelpers excelHelpers;

    public EditCreatedProdPage() {
        excelHelpers = new ExcelHelpers();
    }

    public ListProdsPage openEditProdPage() {
        WebUI.waitForPageLoaded();
        WebUI.clickElement(productMenu);
        WebUI.clickElement(listProdsSubMenu);
        WebUI.clickElement(btnEditTheNewestProds);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementTextEquals(titleEditPage,"Edit Product"));
        return new ListProdsPage();
    }
    public EditCreatedProdPage editProdInfo(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
        WebUI.waitForPageLoaded();
        WebUI.clearText(productName);
        WebUI.setText(productName, excelHelpers.getCellData(rowNum, EditProdModal.getProductName()));


        WebUI.selectOptionByValue(categoryDropdown,"60");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- Beauty & Health"));
        WebUI.selectOptionByValue(categoryDropdown,"22");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"-- Accessories"));
        WebUI.selectOptionByValue(categoryDropdown,"126");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- Luxury car"));
        WebUI.selectOptionByValue(categoryDropdown,"229");
        Assert.assertTrue(WebUI.verifyElementTextEquals(selectedOptionCategoryDropdown,"---- LED Panel Lights"));
        WebUI.clickElement(selectedOptionCategoryDropdown);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum,EditProdModal.getCategory()));
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
        WebUI.setText(weightTbx, excelHelpers.getCellData(rowNum, EditProdModal.getWeight()));

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(minPurchaseTbx));
        WebUI.clearText(minPurchaseTbx);
        WebUI.setText(minPurchaseTbx, excelHelpers.getCellData(rowNum, EditProdModal.getMinPurchase()));

        for (int k = 0; k <= WebUI.getWebElements(tagOfNumber).size(); k++){
            By removeTag = By.xpath("//form[1]/div[1]/div[1]/div[1]/div[1]/div[7]/div[1]/tags[1]/tag[1]/x[1]");
            WebUI.clickElement(removeTag);
            WebUI.sleep(1);
        }
        WebUI.clickElement(tagTbx);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum,EditProdModal.getTags()));
        WebUI.pressENTER();

        Assert.assertFalse(WebUI.verifyHTML5RequiredField(barcodeTbx));
        WebUI.clearText(barcodeTbx);
        WebUI.setText(barcodeTbx, excelHelpers.getCellData(rowNum, EditProdModal.getBarcode()));
        return new EditCreatedProdPage();
    }

    public EditCreatedProdPage uploadGalleryImage(){
        // Upload gallery Image
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
        Assert.assertTrue(WebUI.verifyImagesIsNotBroken(uploadFile));

        //Sort Gallery Image bt Smallest
        WebUI.clickElement(btnOpenScreenUploadGallery);
        WebUI.clickElement(tabSelectFile);
        WebUI.selectOptionByValue(sortDropdown,"smallest");
        Assert.assertTrue(WebUI.verifyTextWhenSortingBySmallest(capacityImage));
        //Sort Gallery Image bt Largest
        WebUI.selectOptionByValue(sortDropdown,"largest");
        Assert.assertTrue(WebUI.verifyTextWhenSortingByLargest(capacityImage));
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
        return new EditCreatedProdPage();
    }

    public EditCreatedProdPage uploadThumbnailImage(){
        // Upload thumbnail Image
        WebUI.scrollToElement(btnOpenScreenUploadGallery);
        WebUI.sleep(5);
        WebUI.clickElement(btnOpenScreenUploadThumbnail);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadThumbnail,"1"));
        return new EditCreatedProdPage();
    }





    public EditCreatedProdPage editSelectProdVariation(){
        //Handle color dropdown
        Assert.assertTrue(WebUI.waitForElementHasAttribute(colorDropdown,"multiple"));
        WebUI.clickElementWithJs(btnSwitchColorEditProd);
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
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedAttributeOption,"Size"));
        WebUI.selectOptionByValue(attributeDropdown,"2");
        WebUI.selectOptionByValue(attributeDropdown,"4");
        WebUI.selectOptionByValue(attributeDropdown,"5");
        WebUI.selectOptionByValue(attributeDropdown,"6");
        WebUI.sleep(3);
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedAttributeOption,"5 items selected"));
        WebUI.deselectOptionByValue(attributeDropdown,"1");
        WebUI.deselectOptionByValue(attributeDropdown,"2");
        WebUI.deselectOptionByValue(attributeDropdown,"4");
        WebUI.deselectOptionByValue(attributeDropdown,"5");
        WebUI.deselectOptionByValue(attributeDropdown,"6");
        WebUI.sleep(3);
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedAttributeOption,"Nothing selected"));
        WebUI.clickElementWithJs(selectedAttributeOption);
        WebUI.setText(searchTbxInDropdown,"Size");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(selectedAttributeOption);
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedAttributeOption,"Size"));

        //Handle sub-dropdown
        WebUI.sleep(3);
        WebUI.selectOptionByValue(sizeDropdown,"M");
        WebUI.selectOptionByValue(sizeDropdown,"XL");
        WebUI.selectOptionByValue(sizeDropdown,"128GB");
        WebUI.selectOptionByValue(sizeDropdown,"512GB");
        WebUI.selectOptionByValue(sizeDropdown,"1TB");
//        Assert.assertTrue(WebUI.verifyElementTextContains(selectedOption,"5"));
        WebUI.deselectOptionByValue(sizeDropdown,"M");
        WebUI.deselectOptionByValue(sizeDropdown,"XL");
        WebUI.deselectOptionByValue(sizeDropdown,"128GB");
        WebUI.deselectOptionByValue(sizeDropdown,"512GB");
        WebUI.deselectOptionByValue(sizeDropdown,"1TB");
        Assert.assertTrue(WebUI.verifyElementTextContains(selectedOption,"Nothing selected"));
        WebUI.clickElementWithJs(selectedOption);
        WebUI.setText(searchTbxInDropdown,"1TB");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(selectedOption);
//        Assert.assertTrue(WebUI.verifyElementTextContains(selectedOption,"1"));
        WebUI.deselectOptionByValue(attributeDropdown,"1");
        WebUI.sleep(2);
        return new EditCreatedProdPage();
    }

    public EditCreatedProdPage editVideoLink(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
        WebUI.selectOptionByValue(videoProviderDropdown,"dailymotion");
        WebUI.selectOptionByValue(videoProviderDropdown,"vimeo");
        WebUI.selectOptionByValue(videoProviderDropdown,"youtube");
        WebUI.sleep(1);
        WebUI.clearText(videoLinkTbx);
        WebUI.setText(videoLinkTbx,excelHelpers.getCellData(rowNum,EditProdModal.getProdVideoLink()));
        return new EditCreatedProdPage();
    }
    public EditCreatedProdPage editPriceStock(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");

        Assert.assertTrue(WebUI.verifyHTML5RequiredField(unitPriceTbx));
        WebUI.clearText(unitPriceTbx);
        WebUI.setText(unitPriceTbx,excelHelpers.getCellData(rowNum,EditProdModal.getUnitPrice()));
        WebUI.clearText(discountDateDropdown);
        WebUI.setText(discountDateDropdown,excelHelpers.getCellData(rowNum,EditProdModal.getDiscountDate()));
        WebUI.clickElement(btnSelectDate);
        WebUI.clearText(discountPercentTbx);
        WebUI.setText(discountPercentTbx,excelHelpers.getCellData(rowNum,EditProdModal.getDiscountPercent()));
        WebUI.selectOptionByValue(optionDiscountTypeDropdown,"percent");
        Assert.assertTrue(WebUI.verifyElementTextContains(discountTypeDropdown,"Percent"));
        WebUI.selectOptionByValue(optionDiscountTypeDropdown,"amount");
        Assert.assertTrue(WebUI.verifyElementTextContains(discountTypeDropdown,"Flat"));
        WebUI.clearText(pointTbx);
        WebUI.setText(pointTbx,excelHelpers.getCellData(rowNum,EditProdModal.getPoint()));
//        WebUI.clearText(quantityTbx);
//        WebUI.setText(quantityTbx,excelHelpers.getCellData(rowNum,EditProdModal.getQuantity()));
//        WebUI.clearText(sukTbx);
//        WebUI.setText(sukTbx,excelHelpers.getCellData(rowNum,EditProdModal.getSuk()));
        WebUI.clearText(externalLinkTbx);
        WebUI.setText(externalLinkTbx,excelHelpers.getCellData(rowNum,EditProdModal.getExternalLink()));
        WebUI.clearText(externalLinkTextTbx);
        WebUI.setText(externalLinkTextTbx,excelHelpers.getCellData(rowNum,EditProdModal.getExternalTextLink()));

        return new EditCreatedProdPage();
    }
    public EditCreatedProdPage editFilePDF(){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
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
        WebUI.verifyImagesIsNotBroken(uploadFile);
        Assert.assertTrue(WebUI.verifyElementTextEquals(uploadFileStatus,"Complete"));
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(2);

        //Select File Image
        WebUI.clickElement(btnOpenScreenUploadPDF);
        WebUI.clickElementWithJs(tabSelectFile);
//        WebUI.setText(editCategory_BrandSearchTbx,"sample");
//        WebUI.pressENTER();
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadPDF,"1"));

        return new EditCreatedProdPage();
    }

    public EditCreatedProdPage editProdDescription(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
        WebUI.clearText(prodDescription);
        WebUI.setText(prodDescription,excelHelpers.getCellData(rowNum,EditProdModal.getProdDescription()));
        return new EditCreatedProdPage();
    }
    public EditCreatedProdPage editSEOMeta(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");

        Assert.assertFalse(WebUI.verifyHTML5RequiredField(metaTitle));
        WebUI.clearText(metaTitle);
        WebUI.setText(metaTitle,excelHelpers.getCellData(rowNum,EditProdModal.getMetaTitle()));
        Assert.assertFalse(WebUI.verifyHTML5RequiredField(metaDescription));
        WebUI.clearText(metaDescription);
        WebUI.setText(metaDescription,excelHelpers.getCellData(rowNum,EditProdModal.getMetaDescription()));

        
        //Select File Image
        WebUI.clickElement(btnOpenScreenUploadMeta);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);

        return new EditCreatedProdPage();
    }
    public EditCreatedProdPage editShippingDays(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Prod");
        WebUI.clearText(shippingDayTbx);
        WebUI.setText(shippingDayTbx,excelHelpers.getCellData(rowNum,EditProdModal.getShippingDays()));
        return new EditCreatedProdPage();
    }
    public EditCreatedProdPage saveEdit(){
        WebUI.clickElement(btnSaveEdit);
        return new EditCreatedProdPage();
    }
    public ListProdsPage checkEditProdSuccessfully(){
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementTextEquals(messEditSuccessfully,"Product has been updated successfully"));
        return new ListProdsPage();
    }
    public ListProdsPage checkEditProdFailure(){
        WebUI.waitForPageLoaded();
        Assert.assertFalse(WebUI.verifyElementExists(messEditSuccessfully));
        return new ListProdsPage();
    }

}


















