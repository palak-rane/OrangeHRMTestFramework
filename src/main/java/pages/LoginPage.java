package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(name = "txtPassword")
    WebElement password;


    @FindBy(className = "button")
    WebElement loginBtn;

    public void EnterUserName(String uname) {
        username.sendKeys(uname);
    }

    public void EnterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void ClickOnLogin() {
        loginBtn.click();
    }
}
