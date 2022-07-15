package login;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.JobsPage;
import pages.LoginPage;
import util.DriverFactory;

public class TestAddJob {
    public WebDriver driver;
    public JobsPage jobsPage;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;

    Faker fake;

    @BeforeClass
    public void setup() {
        driver = DriverFactory.getDriver("chrome");
        jobsPage = new JobsPage(driver);
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        fake = new Faker();
        DriverFactory.LaunchUrl("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown() {
        //DriverFactory.CloseDriver();
    }

    @Test
    public void login() {
        loginPage.EnterUserName("Admin");
        loginPage.EnterPassword("admin123");
        loginPage.ClickOnLogin();

        Assert.assertTrue(dashBoardPage.getWelcomeMassage().contains("Welcome"));
    }

    @Test
    public void testAddJob() {
        jobsPage.goToAdmin();
        jobsPage.goToJob();
        jobsPage.gotoJobTitle();
        jobsPage.clickOnAddNtn();
        jobsPage.enterTitle(String.valueOf(fake.food()));
        jobsPage.enterDescription(String.valueOf(fake.name()));
        // jobsPage.chooseFile("C:\\Users\\Mahesh Rane\\Desktop\\Testing");
        jobsPage.jobNote(String.valueOf(fake.book()));
        // jobsPage.successMessage();
        jobsPage.clickOnSaveButton();
    }
}
