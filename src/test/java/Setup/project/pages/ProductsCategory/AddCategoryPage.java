package Setup.project.pages.ProductsCategory;

import Common.constants.FrameworkConstants;
import Common.handle.WebUI;
import Common.helpers.ExcelHelpers;
import Common.utilities.ObjectUtils;
import Setup.project.modals.AddCategoryModal;
import Setup.project.modals.AddProdModal;
import Setup.project.modals.EditProdModal;
import Setup.project.pages.Products.ListProdsPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class AddCategoryPage {

    public By productMenu = ObjectUtils.getByLocatorFromConfig("productMenu");
    public By categorySubMenu = ObjectUtils.getByLocatorFromConfig("categorySubMenu");
    public By btnAddCategory = ObjectUtils.getByLocatorFromConfig("btnAddCategory");
    public By tbxCategoryName = ObjectUtils.getByLocatorFromConfig("tbxCategoryName");
    public By dropdownParentCategory = ObjectUtils.getByLocatorFromConfig("dropdownParentCategory");
    public By selectParentCategory = ObjectUtils.getByLocatorFromConfig("selectParentCategory");
    public By tbxOrderNumber = ObjectUtils.getByLocatorFromConfig("tbxOrderNumber");
    public By dropdownTypeCategory = ObjectUtils.getByLocatorFromConfig("dropdownTypeCategory");
    public By selectTypeCategory = ObjectUtils.getByLocatorFromConfig("selectTypeCategory");
    public By btnOpenScreenUploadBanner = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadBanner");
    public By uploadBannerBar = ObjectUtils.getByLocatorFromConfig("uploadBannerBar");
    public By btnOpenScreenUploadIcon = ObjectUtils.getByLocatorFromConfig("btnOpenScreenUploadIcon");
    public By uploadIconBar = ObjectUtils.getByLocatorFromConfig("uploadIconBar");

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
    public By dropdownFiltering = ObjectUtils.getByLocatorFromConfig("dropdownFiltering");
    public By selectFiltering = ObjectUtils.getByLocatorFromConfig("selectFiltering");
    public By tbxSearchDropDown = ObjectUtils.getByLocatorFromConfig("tbxSearchDropDown");
    public By btnSubmit = ObjectUtils.getByLocatorFromConfig("btnSubmit");
    public By messSaveCategorySuccessfully = ObjectUtils.getByLocatorFromConfig("messSaveCategorySuccessfully");

    ExcelHelpers excelHelpers;

    public AddCategoryPage() {
        excelHelpers = new ExcelHelpers();
    }

    public AddCategoryPage openCreateCategoryPage(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");
        WebUI.clickElement(productMenu);
        WebUI.clickElement(categorySubMenu);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddCategoryModal.getLinkListCategory())));
        WebUI.clickElement(btnAddCategory);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddCategoryModal.getLinkCreateCategory())));
        WebUI.waitForPageLoaded();
        return new AddCategoryPage();
    }

    public AddCategoryPage createCategory(int rowNum) {
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");
        Assert.assertTrue(WebUI.verifyHTML5RequiredField(tbxCategoryName));
        WebUI.clearText(tbxCategoryName);
        WebUI.setText(tbxCategoryName,excelHelpers.getCellData(rowNum,AddCategoryModal.getCategoryName()));

        WebUI.selectOptionByValue(selectParentCategory,"60");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownParentCategory,"---- Beauty & Health"));
        WebUI.selectOptionByValue(selectParentCategory,"22");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownParentCategory,"-- Accessories"));
        WebUI.selectOptionByValue(selectParentCategory,"126");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownParentCategory,"---- Luxury car"));
        WebUI.selectOptionByValue(selectParentCategory,"229");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownParentCategory,"---- LED Panel Lights"));
        WebUI.clickElement(dropdownParentCategory);
        WebUI.pressCopyPaste(excelHelpers.getCellData(rowNum, AddCategoryModal.getParentCategory()));
        WebUI.pressENTER();
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownParentCategory,excelHelpers.getCellData(rowNum,AddCategoryModal.getParentCategory())));

        WebUI.clearText(tbxOrderNumber);
        WebUI.setText(tbxOrderNumber,excelHelpers.getCellData(rowNum,AddCategoryModal.getOrderNumber()));

        WebUI.selectOptionByText(selectTypeCategory,"Physical");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownTypeCategory,"Physical"));
        WebUI.selectOptionByText(selectTypeCategory,"Digital");
        Assert.assertTrue(WebUI.verifyElementTextEquals(dropdownTypeCategory,"Digital"));

        WebUI.clearText(tbxCategoryTitle);
        WebUI.setText(tbxCategoryTitle,excelHelpers.getCellData(rowNum,AddCategoryModal.getCategoryTitle()));

        WebUI.clearText(tbxCategoryDescription);
        WebUI.setText(tbxCategoryDescription,excelHelpers.getCellData(rowNum,AddCategoryModal.getCategoryDescription()));

        //Handle Attributes dropdown
        WebUI.selectOptionByValue(selectFiltering,"1");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Size"));
        WebUI.selectOptionByValue(selectFiltering,"2");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Fabric"));
        WebUI.selectOptionByValue(selectFiltering,"4");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Sleeve"));
        WebUI.selectOptionByValue(selectFiltering,"5");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Wheel"));
        WebUI.selectOptionByValue(selectFiltering,"6");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Liter"));

        WebUI.deselectOptionByValue(selectFiltering,"1");
        WebUI.deselectOptionByValue(selectFiltering,"2");
        WebUI.deselectOptionByValue(selectFiltering,"4");
        WebUI.deselectOptionByValue(selectFiltering,"5");
        WebUI.deselectOptionByValue(selectFiltering,"6");
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Nothing selected"));
        WebUI.clickElementWithJs(dropdownFiltering);
        WebUI.setText(tbxSearchDropDown,"Size");
        WebUI.pressENTER();
        WebUI.clickElementWithJs(dropdownFiltering);
        Assert.assertTrue(WebUI.verifyElementTextContains(dropdownFiltering,"Size"));
        WebUI.sleep(5);
        return new AddCategoryPage();
    }


    public AddCategoryPage uploadCategoryImage(){
        // Upload Category Image
        WebUI.clickElement(btnOpenScreenUploadBanner);
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
        WebUI.clickElement(btnOpenScreenUploadBanner);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(2);
//        Assert.assertTrue(WebUI.verifyElementTextContains(btnOpenScreenUploadGallery,"3"));
        Assert.assertTrue(WebUI.verifyElementPresent(uploadedBanner));
        WebUI.verifyImagesIsNotBroken(uploadFile);

        //Sort Category Image bt Smallest
        WebUI.clickElement(btnOpenScreenUploadBanner);
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
        return new AddCategoryPage();
    }

    public AddCategoryPage uploadIconImage(){
        WebUI.clickElement(btnOpenScreenUploadIcon);
        WebUI.clickElementWithJs(tabSelectFile);
        WebUI.clickElement(image);
        WebUI.clickElement(btnAddFile);
        WebUI.sleep(5);
//        Assert.assertTrue(WebUI.verifyElementPresent(uploadedIcon));
        return new AddCategoryPage();
    }


    public AddCategoryPage saveCategorySuccessfully(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");
        WebUI.clickElement(btnSubmit);
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddCategoryModal.getLinkListCategory())));
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyElementTextEquals(messSaveCategorySuccessfully,"Category has been inserted successfully"));
        return new AddCategoryPage();
    }

    public AddCategoryPage saveCategoryFailure(int rowNum){
        excelHelpers.setExcelFile(FrameworkConstants.EXCEL_DATA_FILE_PATH, "Create_Category");
        WebUI.clickElement(btnSubmit);
        WebUI.waitForPageLoaded();
        Assert.assertTrue(WebUI.verifyPageUrl(excelHelpers.getCellData(rowNum, AddCategoryModal.getLinkCreateCategory())));
        return new AddCategoryPage();
    }



//




}
