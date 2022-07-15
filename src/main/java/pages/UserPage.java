package pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserPage {
    WebDriver driver;

    public UserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@value='Add']")
    WebElement addBtn;

    @FindBy(css = "select[id='systemUser_userType']")
    WebElement userRole;

    @FindBy(id = "systemUser_employeeName_empName")
    WebElement employeeName;

    @FindBy(name = "systemUser[userName]")
    WebElement userName;

    @FindBy(css = "select[id='systemUser_status']")
    WebElement status;

    @FindBy(id = "systemUser_password")
    WebElement password;

    @FindBy(id = "systemUser_confirmPassword")
    WebElement confirmPassword;

    @FindBy(name = "btnSave")
    WebElement saveBtn;



    public void clickOnAddBtn() {
        addBtn.click();
    }

    public void userRoleDropDown(String role) {
        Select drpUserRole = new Select(userRole);
        if (role.equals("admin"))
            drpUserRole.selectByVisibleText("Admin");
        else if (role.equals("ess")) {
            drpUserRole.selectByVisibleText("Admin");
        }
    }

    public void enterEmployeeName(String eName) {
        employeeName.sendKeys(eName);
        employeeName.sendKeys(Keys.ENTER);
    }

    public void enterUserName(String uname) {
        userName.sendKeys(uname);
    }

    public void checkStatus(String stt) {
        Select drpStatus = new Select(status);
        if (stt.equals("Enabled"))
            drpStatus.selectByVisibleText("Enabled");
        else if (stt.equals("Disabled")) {
            drpStatus.selectByVisibleText("Disabled");
        }
    }

    public void enterPassword(String pwd) {
        password.sendKeys(pwd);
    }

    public void enterConfirmPassword(String confirmPwd) {
        confirmPassword.sendKeys(confirmPwd);
    }

    public void clickOnSaveBtn() {
        saveBtn.click();
    }


}
