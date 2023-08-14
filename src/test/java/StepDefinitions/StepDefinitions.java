package StepDefinitions;

import PageObject.AddCustomerPage;
import PageObject.DashBoardPage;
import PageObject.LogInPage;
import Utilities.readConfig;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class StepDefinitions extends BaseClass {

@Before("@NonReg")
public void setup(){
    readConfig = new readConfig();
    String browserName = readConfig.getBrowser();

    switch (browserName.toLowerCase()){

        case "chrome":
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            break;
        case "firefox":
            driver = new FirefoxDriver();
            break;
        default:
            driver = null;
            break;
    }
    driver.manage().window().maximize();
    System.out.println("Non -reg Setup method Executed");
    log = LogManager.getLogger("StepDefinitions");
    url = readConfig.getURL();
}

    @Before("@Sanity")
    public void setup1(){
       readConfig = new readConfig();
       String browserName = readConfig.getBrowser();
       switch (browserName.toLowerCase()){

           case "chrome":
               WebDriverManager.chromedriver().setup();
               driver = new ChromeDriver();
               break;
           case "firefox":
               driver = new FirefoxDriver();
               break;
           case "edge":
               driver = new EdgeDriver();
               break;
           default:
               driver = null;
               break;
       }


        driver.manage().window().maximize();
        System.out.println("Sanity Setup method Executed");
        log = LogManager.getLogger("StepDefinitions");


    }



    @Given("User  Launch Crome browser")
    public void user_launch_crome_browser() {

        logInPage = new LogInPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        addCustomerPage =new AddCustomerPage(driver);


    }
    @When("User Navigate to URL {string}")
    public void user_navigate_to_url(String string) {

        driver.get(url);
        log.info("Navigating to URL");

    }
    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String string, String string2) {
        logInPage.enterEmail(string);
        logInPage.enterPassword(string2);
        log.info("Email Password entered");

    }
    @When("Click Login")
    public void click_login() {
logInPage.clickLoginBtn();
log.info("Log in is in progress");
    }
    @Then("Page title Should be {string}")
    public void page_title_should_be(String expectedTitle) {

        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
        log.info("Page title is "+actualTitle);


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
            log.info("Customer created");
        }
        else{
            Assert.assertTrue(false);
            log.warn("This is not right message seems user is not created.");
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


    @When("User enters Customers information_new")
    public void user_enters_customers_information_new() {
        addCustomerPage.enterEmailId(generateRandomEmailID());
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


        addCustomerPage.enterEmailToSearch("victoria_victoria@nopCommerce.com");
    }
    @When("User hit on Search button")
    public void user_hit_on_search_button() {
        addCustomerPage.hitSearchBtn();


    }
    @Then("User Email should be listed in the table")
    public void user_email_should_be_listed_in_the_table() {

       String numberOFPages = addCustomerPage.numberofPagesInSearchResults();

        boolean isEmailFound = addCustomerPage.checkEmailInSearchResults("victoria_victoria@nopCommerce.com");
        System.out.println("000000000 the isEmailFound value is "+ isEmailFound);
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
//        driver.quit();
    }

    @BeforeStep(order = 1)

    public void beforeStepMethod(){

        System.out.println("Order 1---This is Before step =====================");
    }

    @BeforeStep(order = 0)

    public void beforeStepMethod1(){

        System.out.println("Order 0---This is Before step =====================");
    }

    @AfterStep(order = 1)
    public void afterStepMethod(Scenario scenario){

        System.out.println("Order 1--This is After step =====================");
        if (scenario.isFailed() == true){
            //WebDriver is converted to Take Screenshot object
            String filePath = "D:\\Cucumber\\Proj1\\PageFactoryModel\\target\\ScreenShots\\test.png";
            TakesScreenshot screenShot =((TakesScreenshot) driver);

            //Create Image file
            File ScrnShotFile = screenShot.getScreenshotAs(OutputType.FILE);

            File destinationFile = new File(filePath);

            try {
                FileUtils.copyFile(ScrnShotFile,destinationFile);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
    }

    @AfterStep(order = 2)
    public void afterStepMethodScreenShot(Scenario scenario){
    final byte[]screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    scenario.attach(screenshot,"image/png",scenario.getName());

        System.out.println("Order 2--This is After step =====================");
        log.info("A step was executed....");
    }

    @After
    public void teardown(){

    driver.quit();
        System.out.println("Teardown method Executed");
    }


}
