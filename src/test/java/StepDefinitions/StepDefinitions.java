package StepDefinitions;

import PageObject.AddCustomerPage;
import PageObject.DashBoardPage;
import PageObject.LogInPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class StepDefinitions extends BaseClass {





    @Given("User  Launch Crome browser")
    public void user_launch_crome_browser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        logInPage = new LogInPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        addCustomerPage =new AddCustomerPage(driver);

    }
    @When("User Navigate to URL {string}")
    public void user_navigate_to_url(String string) {

        driver.get(string);

    }
    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        logInPage.enterEmail(string);
        logInPage.enterPassword(string2);

    }
    @When("Click Login")
    public void click_login() {
logInPage.clickLoginBtn();
    }
    @Then("Page title Should be {string}")
    public void page_title_should_be(String expectedTitle) {

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }
    @When("User clicks on LogOut Link")
    public void user_clicks_on_log_out_link() {
        dashBoardPage.logOut();

    }




    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }

    // Customer Page Methods
    @Then("User clicks on Customer Menu")
    public void user_clicks_on_customer_menu() {
dashBoardPage.expandCustomerMenu();

    newEmailID = generateRandomEmailID();
        System.out.println("++++++++++++"+newEmailID);
        updateFileContent(filePath,newEmailID);

    }
    @Then("User click on Customers menu item")
    public void user_click_on_customers_menu_item() {
        dashBoardPage.goToCreateCustomerPage();

    }
    @Then("user click on Add New Button")
    public void user_click_on_add_new_button() {

        addCustomerPage.addCustomerBtn();


    }
    @Then("User can view Add new Customer page")
    public void user_can_view_add_new_customer_page() {
        String expectedPageTitle = "Add a new customer / nopCommerce administration";
        String titleOfPage = driver.getTitle();
        if (titleOfPage.equals(expectedPageTitle)){

            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

    }
//    @When("User enters Customers info")
//    public void user_enters_customers_info() {
//        boolean written = writeInTextFile(newEmailID);
//        addCustomerPage.enterEmailId(copyOfEmailID);
//        addCustomerPage.enterPassword("xyz");
//        addCustomerPage.enterFirstName("Abc");
//        addCustomerPage.enterLastName("Xyz");
//        addCustomerPage.selectGender("M");
//        addCustomerPage.enterDOB("03/03/1999");
//        addCustomerPage.enterCompanyName("XYZDSA");
//        addCustomerPage.isTaxExempt("Yes");
////        addCustomerPage.setCustomerRoleList("Guests");
//    }

    @When("User enters Customers information")
        public void user_enters_customers_information() {
        String thiscopyOfEmailID = readFileContent(filePath);
        addCustomerPage.enterEmailId("CVC1");
        addCustomerPage.enterPassword("1xyz");
        addCustomerPage.enterFirstName("Abc12");
        addCustomerPage.enterLastName("Xyz12");
        addCustomerPage.selectGender("M");
        addCustomerPage.enterDOB("03/07/1999");
        addCustomerPage.enterCompanyName("XY1ZDSA2");
        addCustomerPage.isTaxExempt("Yes");

    }
    @When("Click on Save button")
    public void click_on_save_button() {

        addCustomerPage.clickSaveBtn();

    }
    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String string) {
        System.out.println("Its OK");
        String bodyText = driver.findElement(By.tagName("Body")).getText();
        if(bodyText.contains("The new customer has been added successfully")){
            Assert.assertTrue(true);
        }
        else{
            Assert.assertTrue(false);
        }

    }

    @Then("User enter emailID as {string}")
    public void user_enter_email_id_as(String string) {


        addCustomerPage.enterEmailToSearch(copyOfEmailID);
    }
    @When("User hit on Search button")
    public void user_hit_on_search_button() {
        addCustomerPage.hitSearchBtn();
//        try {
//           Thread.sleep(Duration.ofMillis(6000));
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }

    }
    @Then("User Email should be listed in the table")
    public void user_email_should_be_listed_in_the_table() {
        String searchThis = readFileContent(filePath);
        boolean isEmailFound = addCustomerPage.checkEmailInSearchResults(searchThis);

        if (isEmailFound == true){
            Assert.assertTrue(true);
        }
        else {
            Assert.assertTrue(false);
        }

    }




    @Then("Close browser")
    public void close_browser() {
        driver.close();
        driver.quit();
    }




}
