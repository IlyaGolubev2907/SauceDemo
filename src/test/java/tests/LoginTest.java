package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.auth("standard-user", "");
        Assert.assertEquals(loginPage.authError(),
                "Epic sadface: Password is required",
                "Сообщение не соответствует");
    }

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageProducts());
    }
}
