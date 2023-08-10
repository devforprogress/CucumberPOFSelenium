package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {

    WebDriver ldriver;

    public DashBoardPage(WebDriver rDriver){
        ldriver = rDriver;
        PageFactory.initElements(rDriver,this);
    }
    @FindBy(linkText = "Logout")
    WebElement logout;

    @FindBy(xpath = "//a[@href ='#']//p[contains(text(),'Customers')]")
    WebElement customerMainLink;

    @FindBy(xpath = "//a[@href ='/Admin/Customer/List']//p[contains(text(),'Customers')]")
    WebElement customerLink;


public void logOut(){
    logout.click();
}

public void expandCustomerMenu(){
    customerMainLink.click();

}
    public void goToCreateCustomerPage(){

        customerLink.click();
    }
}
