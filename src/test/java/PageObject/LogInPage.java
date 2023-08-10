package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPage {

    WebDriver ldriver;
    public LogInPage(WebDriver rDriver){

        ldriver = rDriver;
        PageFactory.initElements(rDriver,this);


    }
    @FindBy(id = "Email")
    WebElement email;
    @FindBy(id = "Password")
    WebElement pwd;
    @FindBy(xpath = "//button[text()=\"Log in\"]")
    WebElement logInBtn;

    public void enterEmail(String emailId){
        email.clear();
        email.sendKeys(emailId);
    }
    public void enterPassword(String passwd){
        pwd.clear();
        pwd.sendKeys(passwd);
    }
    public void clickLoginBtn(){
        logInBtn.click();
    }
}
