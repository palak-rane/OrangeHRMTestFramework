package login;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import pages.UserPage;
import util.DriverFactory;

public class TestAddUser {
    public WebDriver driver;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;
    public UserPage userpage;
    public Faker faker;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        userpage = new UserPage(driver);
        faker = new Faker();
        DriverFactory.LaunchUrl("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() {
        DriverFactory.CloseDriver();
    }

    @Test
    public void testLogin() {
        loginPage.EnterUserName("Admin");
        loginPage.EnterPassword("admin123");
        loginPage.ClickOnLogin();

        Assert.assertTrue(dashBoardPage.getWelcomeMassage().contains("Welcome"));
        dashBoardPage.goToAdmin();
        dashBoardPage.goToUserManagement();
        dashBoardPage.goToUser();
        userpage.clickOnAddBtn();
        userpage.userRoleDropDown("admin");
        userpage.enterEmployeeName("a");
        userpage.enterUserName(String.valueOf(faker.name()));
        userpage.checkStatus("Enabled");
        userpage.enterPassword("Abcd123$");
        userpage.enterConfirmPassword("Abcd123$");
        userpage.clickOnSaveBtn();
        //Assert.assertTrue(dashBoardPage.getWelcomeMassage().contains("successfully saved"));
    }

}
