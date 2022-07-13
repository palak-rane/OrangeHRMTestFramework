package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashBoardPage {
    WebDriver driver;
    Actions actions;
    public DashBoardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }

    @FindBy(id = "welcome")
    WebElement WelcomeMassage;

    @FindBy(linkText = "Admin")
    WebElement Admin ;

    @FindBy(id = "menu_admin_UserManagement")
    WebElement UserManagement;

    @FindBy(id = "menu_admin_viewSystemUsers")
    WebElement User;

    public String getWelcomeMassage() {
        return WelcomeMassage.getText();
    }


    public void goToAdmin(){
        actions.moveToElement(Admin);
    }

    public void goToUserManagement() {
       actions.moveToElement(UserManagement);
    }
    public void goToUser(){
      actions.moveToElement(User).build().perform();
      User.click();
    }
}

