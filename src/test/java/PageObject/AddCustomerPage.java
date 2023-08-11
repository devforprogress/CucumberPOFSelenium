package PageObject;

import StepDefinitions.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class AddCustomerPage extends BaseClass {

    WebDriver ldriver;

    public AddCustomerPage(WebDriver rdriver){
        ldriver = rdriver;
        PageFactory.initElements(rdriver,this);
        wait10 = new WebDriverWait(rdriver, Duration.ofSeconds(10));


    }

    @FindBy(xpath = "//a[@href='/Admin/Customer/Create']")
    WebElement addCustomerBtn;
    @FindBy(xpath = "//input[@id='Email']")
    WebElement enterEmailField;
    @FindBy(xpath = "//input[@id='Password']")
    WebElement pwdField;
    @FindBy(xpath = "//input[@id='FirstName']")
    WebElement FnameField;
    @FindBy(xpath = "//input[@id='LastName']")
    WebElement LnameField;
    @FindBy(xpath = "//input[@id='Gender_Male']")
    WebElement gMaleField;
    @FindBy(xpath = "//input[@id='Gender_Female']")
    WebElement gFemaleField;
    @FindBy(xpath = "//input[@id='Company']")
    WebElement companyInputField;
    @FindBy(xpath = "//input[@id='DateOfBirth']")
    WebElement dobField;

    @FindBy(xpath = "//input[@id='IsTaxExempt']")
    WebElement isTaxExemptCheckBox;

    @FindBy(xpath = "//select[@id='VendorId']")
    WebElement managerOfVendorList;

//    @FindBy(xpath = "//select[@id='SelectedCustomerRoleIds']")
//    WebElement customerRoleList;

    @FindBy(name = "AdminComment")
    WebElement AdminCommentField;

    @FindBy(xpath = "//button[@name='save']")
    WebElement saveBtn;

    @FindBy(xpath = "//span[@title=\"delete\"]")
    WebElement deleteRoleBtn;

    @FindBy(xpath = "// input[@name='SearchEmail']")
    WebElement emailSearchField;

    @FindBy(xpath = "// button[@id='search-customers']")
    WebElement searchBtn;

//    @FindBy(xpath = "//table[@id=\"customers-grid\"]//tbody/tr")
    @FindBy(xpath = "//table[@class ='table table-bordered table-hover table-striped dataTable no-footer' and @id = 'customers-grid']//tbody/tr")
    List<WebElement> tableRows;

    @FindBy(xpath = "//table[@id=\"customers-grid\"]//tbody/tr[1]/td")

    List<WebElement> tableColumns;

    @FindBy(xpath = "//div[@id='customers-grid_info' and @role='status']")
    WebElement numberOfPages;

//    @FindBy(xpath = "//select[@id=\"SelectedCustomerRoleIds\"]")
//    WebElement selectRole;


    public void addCustomerBtn(){

        addCustomerBtn.click();

    }
    public void enterEmailId(String emailID){
        enterEmailField.sendKeys(emailID);

    }

    public String copyEmailID(){

        String enteredEmailID = enterEmailField.getText();
        return enteredEmailID;

    }
    public void enterPassword(String pwd){
    pwdField.sendKeys(pwd);
    }

    public void enterFirstName(String firstName){

        FnameField.sendKeys(firstName);
    }

    public void enterLastName(String lastName){

        LnameField.sendKeys(lastName);
    }

    public void selectGender(String MorF){

        if(MorF.equals("M") || MorF.equalsIgnoreCase("Male")){

            gMaleField.click();
        }
        else if(MorF.equals("F") || MorF.equalsIgnoreCase("Female")){

            gFemaleField.click();
        }

    }

    public void enterDOB(String date){

        dobField.sendKeys(date);
    }

    public void enterCompanyName(String nameOfCompany){

        companyInputField.sendKeys(nameOfCompany);
    }

public void isTaxExempt(String YesOrNo){

        if(YesOrNo.equalsIgnoreCase("Yes")){
            isTaxExemptCheckBox.click();

        }
        else{
            System.out.println("Not tax exempt");
        }
}

public void adminComment(String Comment){

        AdminCommentField.sendKeys(Comment);
}


//public void setManagerOfVendorList(String value){
//
//    Select dropdown = new Select(managerOfVendorList);
//
//    // Select by Visible Text
//    dropdown.selectByVisibleText(value);
//}

//public void setCustomerRoleList(String value){
//        deleteRoleBtn.click();
//
//        Select dropDown = new Select(selectRole);
//        dropDown.selectByVisibleText(value);
//}

public void clickSaveBtn(){

        saveBtn.click();
}

public void enterEmailToSearch(String mailID){

        emailSearchField.sendKeys(mailID);
}

public void hitSearchBtn(){

        searchBtn.click();
}

public boolean checkEmailInSearchResults(String email){
        boolean found = false;

        //Get number of total rows
    int totalRows = tableRows.size();
    int totalCols = tableColumns.size();
    for (int i=1; i<= totalRows;i++){
        WebElement emailActual = ldriver.findElement(By.xpath("//table[@class ='table table-bordered table-hover table-striped dataTable no-footer' and @id = 'customers-grid']/tbody/tr["+i+"]/td[2]"));

        String emailActualText = emailActual.getText();
        System.out.println("77777777777777 -"+emailActualText);
        if(emailActualText.equalsIgnoreCase(email)){

            found = true;
            break;

        }

    }
return found;

}

 public String numberofPagesInSearchResults(){

     System.out.println("Waiting for the Element");

     wait10.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='customers-grid_info' and @role='status']")));

        String pages =numberOfPages.getText();
        return pages;
 }


}

