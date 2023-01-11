package Setup.project.pages.ProductsCategory;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.EditCategoryModal;
import Setup.project.modals.EditCategoryModal;
import org.openqa.selenium.By;
import org.testng.Assert;

public class EditCategoryPage {

    public By productMenu = ObjectUtils.getByLocatorFromConfig("productMenu");
    public By categorySubMenu = ObjectUtils.getByLocatorFromConfig("categorySubMenu");
    public By btnEditTheNewestCategory = ObjectUtils.getByLocatorFromConfig("btnEditTheNewestCategory");
    public By tbxCategoryName = ObjectUtils.getByLocatorFromConfig("tbxCategoryName");
    public By dropdownEditParentCategory = ObjectUtils.getByLocatorFromConfig("dropdownEditParentCategory");
    public By editSelectParentCategory = ObjectUtils.getByLocatorFromConfig("editSelectParentCategory");
    public By tbxOrderNumber = ObjectUtils.getByLocatorFromConfig("tbxOrderNumber");
    public By dropdownEditTypeCategory = ObjectUtils.getByLocatorFromConfig("dropdownEditTypeCategory");
    public By selectTypeCategory = ObjectUtils.getByLocatorFromConfig("selectTypeCategory");
    public By btnOpenScreenEditBanner = ObjectUtils.getByLocatorFromConfig("btnOpenScreenEditBanner");
    public By editBannerBar = ObjectUtils.getByLocatorFromConfig("editBannerBar");
    public By btnOpenScreenEditIcon = ObjectUtils.getByLocatorFromConfig("btnOpenScreenEditIcon");
    public By editIconBar = ObjectUtils.getByLocatorFromConfig("editIconBar");
    public By btnRemoveBanner = ObjectUtils.getByLocatorFromConfig("btnRemoveBanner");
    public By btnRemoveIcon = ObjectUtils.getByLocatorFromConfig("btnRemoveIcon");

    public By tabSelectFile = ObjectUtils.getByLocatorFromConfig("tabSelectFile");
    public By tabUploadFile = ObjectUtils.getByLocatorFromConfig("tabUploadFile");
    public By uploadFile = ObjectUtils.getByLocatorFromConfig("uploadFile");
    public By filePath = ObjectUtils.getByLocatorFromConfig("filePath");
    public By uploadFileStatus = ObjectUtils.getByLocatorFromConfig("uploadFileStatus");
    public By fileName = ObjectUtils.getByLocatorFromConfig("fileName");
    public By btnAddMoreFile = ObjectUtils.getByLocatorFromConfig("btnAddMoreFile");
    public By btnAddFile = ObjectUtils.getByLocatorFromConfig("btnAddFile");
    public By btnCloseModal = ObjectUtils.getByLocatorFromConfig("btnCloseModal");
    public By uploadedBanner = ObjectUtils.getByLocatorFromConfig("uploadedBanner");
    public By uploadedIcon = ObjectUtils.getByLocatorFromConfig("uploadedIcon");
    public By sortDropdown = ObjectUtils.getByLocatorFromConfig("sortDropdown");
    public By btnSelectFile = ObjectUtils.getByLocatorFromConfig("btnSelectFile");
    public By selectedFile = ObjectUtils.getByLocatorFromConfig("selectedFile");
    public By capacityImage = ObjectUtils.getByLocatorFromConfig("capacityImage");
    public By searchFileTbx = ObjectUtils.getByLocatorFromConfig("searchFileTbx");
    public By fileTitle = ObjectUtils.getByLocatorFromConfig("fileTitle");
    public By image = ObjectUtils.getByLocatorFromConfig("image");


    public By tbxCategoryTitle = ObjectUtils.getByLocatorFromConfig("tbxCategoryTitle");
    public By tbxCategoryDescription = ObjectUtils.getByLocatorFromConfig("tbxCategoryDescription");
    public By dropdownEditFiltering = ObjectUtils.getByLocatorFromConfig("dropdownEditFiltering");
    public By editSelectFiltering = ObjectUtils.getByLocatorFromConfig("editSelectFiltering");
    public By tbxSearchDropDown = ObjectUtils.getByLocatorFromConfig("tbxSearchDropDown");
    public By btnSubmit = ObjectUtils.getByLocatorFromConfig("btnSubmit");
    public By messEditCategorySuccessfully = ObjectUtils.getByLocatorFromConfig("messEditCategorySuccessfully");

    ExcelHelpers excelHelpers;

    public EditCategoryPage() {
        excelHelpers = new ExcelHelpers();
    }

    public EditCategoryPage openEditCategoryPage(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Category");
        WebUI.clickElement(productMenu);
        WebUI.clickElement(categorySubMenu);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, EditCategoryModal.getLinkListCategory())));
        WebUI.clickElement(btnEditTheNewestCategory);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, EditCategoryModal.getLinkEditCategory())));
        WebUI.waitForPageLoaded();
        return new EditCategoryPage();
    }

    public EditCategoryPage editCategory(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Category");
        Assert.assertTrue(WebUI.verifyHTML5RequiredField(tbxCategoryName));
        WebUI.clearText(tbxCategoryName);
        WebUI.setText(tbxCategoryName,excelHelpers.getCellData(rowNum,EditCategoryModal.getCategoryName()));

        WebUI.selectOptionByValue(editSelectParentCategory,"219");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditParentCategory,"---- Nail Dryer"));
        WebUI.selectOptionByValue(editSelectParentCategory,"108");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditParentCategory,"---- Gaming mouse"));
        WebUI.selectOptionByValue(editSelectParentCategory,"232");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditParentCategory,"---- Painting & Calligraphy"));
        WebUI.selectOptionByValue(editSelectParentCategory,"92");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditParentCategory,"---- Men sleep & lounge"));
        WebUI.clickElement(dropdownEditParentCategory);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum, EditCategoryModal.getParentCategory()));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditParentCategory,excelHelpers.getCellData(rowNum,EditCategoryModal.getParentCategory())));

        WebUI.clearText(tbxOrderNumber);
        WebUI.setText(tbxOrderNumber,excelHelpers.getCellData(rowNum,EditCategoryModal.getOrderNumber()));

        WebUI.selectOptionByText(selectTypeCategory,"Physical");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditTypeCategory,"Physical"));
        WebUI.selectOptionByText(selectTypeCategory,"Digital");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownEditTypeCategory,"Digital"));

        WebUI.clearText(tbxCategoryTitle);
        WebUI.setText(tbxCategoryTitle,excelHelpers.getCellData(rowNum,EditCategoryModal.getCategoryTitle()));

        WebUI.clearText(tbxCategoryDescription);
        WebUI.setText(tbxCategoryDescription,excelHelpers.getCellData(rowNum,EditCategoryModal.getCategoryDescription()));

        //Handle Attributes dropdown
        WebUI.selectOptionByValue(editSelectFiltering,"1");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Size"));
        WebUI.selectOptionByValue(editSelectFiltering,"2");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Fabric"));
        WebUI.selectOptionByValue(editSelectFiltering,"4");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Sleeve"));
        WebUI.selectOptionByValue(editSelectFiltering,"5");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Wheel"));
        WebUI.selectOptionByValue(editSelectFiltering,"6");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Liter"));

        WebUI.deselectOptionByValue(editSelectFiltering,"1");
        WebUI.deselectOptionByValue(editSelectFiltering,"2");
        WebUI.deselectOptionByValue(editSelectFiltering,"4");
        WebUI.deselectOptionByValue(editSelectFiltering,"5");
        WebUI.deselectOptionByValue(editSelectFiltering,"6");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Nothing selected"));
        WebUI.clickElementWithJs(dropdownEditFiltering);
        WebUI.setText(tbxSearchDropDown,"Size");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(dropdownEditFiltering);
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownEditFiltering,"Size"));
        WebUI.sleep(5);
        return new EditCategoryPage();
    }


    public EditCategoryPage editCategoryImage(){
        // Upload Category Image
        WebUI.clickElementWithJs(btnRemoveBanner);
        WebUI.clickElement(btnOpenScreenEditBanner);
        WebUI.clickElement(tabUploadFile);
        WebUI.uploadMultiFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\ron1.jpg","C:\\Users\\Tanapoto\\Pictures\\ImageTest\\ron2.jpg");
//        WebUI.clickElement(btnAddMoreFile);
//        WebUI.uploadFileWithSendKeys(filePath,"C:\\Users\\Tanapoto\\Pictures\\ImageTest\\ron3.jpg");
        for(int i = 1; i<= WebUI.getWebElements(fileName).size(); i++){
            By fileName = By.xpath("//div[2]/div[1]/ul[1]/li["+i+"]/div/div/div[@title]");
            Assert.assertTrue(WebUI.verifyElementTextContains(fileName,"ron"+i));
        }
//        Assert.assertTrue(WebUI.verifyImagesIsNotBroken(uploadFile));
        Assert.assertTrue(WebUI.verifyElementTextEquals(uploadFileStatus,"Complete"));
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);

        //Select Category Image
        WebUI.clickElement(btnOpenScreenEditBanner);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(2);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadGallery,"3"));
        Assert.assertTrue(WebUI.verifyElementPresent(uploadedBanner));
        WebUI.verifyImagesIsNotBroken(uploadFile);

        //Sort Category Image bt Smallest
        WebUI.clickElement(btnOpenScreenEditBanner);
        WebUI.clickElement(tabSelectFile);
        WebUI.selectOptionByValue(sortDropdown,"smallest");
        WebUI.verifyTextWhenSortingBySmallest(capacityImage);
        //Sort Category Image bt Largest
        WebUI.selectOptionByValue(sortDropdown,"largest");
        WebUI.verifyTextWhenSortingByLargest(capacityImage);
        //Sort selected Image
        WebUI.clickElement(btnSelectFile);
        Assert.assertTrue(WebUI.verifyElementAttributeValue(selectedFile,"data-selected","true"));
        WebUI.clickElement(btnSelectFile);
        //Search file
        WebUI.setText(searchFileTbx,"ron");
        WebUI.pressENTER();
        WebUI.pressENTER();
        WebUI.sleep(2);
        Assert.assertTrue(WebUI.verifyElementTextContains(fileTitle,"ron"));
        WebUI.clickElementWithJs(btnCloseModal);
        return new EditCategoryPage();
    }

    public EditCategoryPage editIconImage(){
        WebUI.clickElement(btnRemoveIcon);
        WebUI.clickElement(btnOpenScreenEditIcon);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementPresent(uploadedIcon));
        return new EditCategoryPage();
    }


    public EditCategoryPage editCategorySuccessfully(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Category");
        WebUI.clickElement(btnSubmit);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, EditCategoryModal.getLinkListCategory())));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementTextEquals(messEditCategorySuccessfully,"Category has been updated successfully"));
        return new EditCategoryPage();
    }

    public EditCategoryPage editCategoryFailure(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Edit_Created_Category");
        WebUI.clickElement(btnSubmit);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, EditCategoryModal.getLinkEditCategory())));
        return new EditCategoryPage();
    }



//




}
