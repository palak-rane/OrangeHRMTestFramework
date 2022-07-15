package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class JobsPage {
    WebDriver driver;
    Actions actions;
    public JobsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        actions = new Actions(driver);
    }

    @FindBy(id = "menu_admin_viewAdminModule")
    WebElement admin;

    @FindBy(id="menu_admin_Job")
    WebElement adminMenuJob;

    @FindBy(id = "menu_admin_viewJobTitleList")
    WebElement jobTitle;

    @FindBy(id="btnAdd")
    WebElement addBtn;

    @FindBy(name = "jobTitle[jobTitle]")
    WebElement title;

    @FindBy(name = "jobTitle[jobDescription]")
    WebElement description;

    @FindBy(name = "jobTitle[jobSpec]")
    WebElement upload_file;

    @FindBy(name = "jobTitle[note]")
    WebElement jobNote;

    @FindBy(name = "btnSave")
    WebElement saveBtn;

    @FindBy(id = "successBodyEdit")
    WebElement successfullySavedMassage;

    public void goToAdmin(){
        actions.moveToElement(admin);
    }
    public void goToJob(){
        actions.moveToElement(adminMenuJob);
    }
    public void gotoJobTitle(){
        actions.moveToElement(jobTitle).build().perform();
        jobTitle.click();
    }
    public void clickOnAddNtn()
    {
        addBtn.click();
    }
    public void enterTitle(String jobTitle){
        title.sendKeys(jobTitle);
    }
    public void enterDescription(String jobDescription){
        description.sendKeys(jobDescription);
    }
    public void chooseFile(String chooseFile){
        upload_file.sendKeys(chooseFile);
    }
    public void jobNote(String note) {
        jobNote.sendKeys(note);
    }
    public void clickOnSaveBtn(){
        saveBtn.click();
    }

    public String successMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("successBodyEdit")));

        return successfullySavedMassage.getText();
    }
    public void clickOnSaveButton(){
        saveBtn.click();

    }
}
