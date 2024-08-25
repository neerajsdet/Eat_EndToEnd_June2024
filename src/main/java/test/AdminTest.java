package test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.BasePage;
import pages.LoginPage;
import setup.DriverFactory;
import setup.Util;

public class AdminTest {


    WebDriver driver;
    LoginPage loginPage;
    BasePage basePage;
    AdminPage adminPage;

    @BeforeClass
    public void tearUP(){
        driver = DriverFactory.getDriver("chrome");
        loginPage = new LoginPage(driver);
        basePage = new BasePage(driver);
        adminPage = new AdminPage(driver);
    }

    @Test
    public void verifyIfUserIsAbleToLogin(){
        basePage.launchApplication("https://opensource-demo.orangehrmlive.com/");
        Util.pauseExecutionForSeconds(1);
        loginPage.enterUserName("Admin");
        Util.pauseExecutionForSeconds(1);
        loginPage.enterPassword("admin123");
        Util.pauseExecutionForSeconds(1);
        loginPage.clickOnLoginButton();
        Util.pauseExecutionForSeconds(3);
        Assert.assertTrue(basePage.checkIfUserIconDisplayed());
    }


    @AfterClass
    public void tearDown(){
        basePage.closeBrowser();
    }

}
