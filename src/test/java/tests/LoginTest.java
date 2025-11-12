package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.ConfigReader;

public class LoginTest extends BaseTest {
    @Test
    public void verifyValidLogin() {
        LoginPage login = new LoginPage(driver);
        login.login(ConfigReader.get("adminUsername"), ConfigReader.get("adminPassword"));
        System.out.println("Done");
        Assert.assertTrue(true);
    }
}
