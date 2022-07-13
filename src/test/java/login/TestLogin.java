package login;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.DashBoardPage;
import pages.LoginPage;
import util.DriverFactory;

public class TestLogin {
    public WebDriver driver;
    public LoginPage loginPage;
    public DashBoardPage dashBoardPage;

    @BeforeClass
    public void setUp() {
        driver = DriverFactory.getDriver("chrome");
        loginPage = new LoginPage(driver);
        dashBoardPage = new DashBoardPage(driver);
        DriverFactory.LaunchUrl("https://opensource-demo.orangehrmlive.com/");
        driver.manage().window().maximize();
    }
    @AfterClass
    public void tearDown() {
       // DriverFactory.CloseDriver();
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

    }

}
