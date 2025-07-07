package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{

    @Test (priority = 2, description = "Проверка входа в систему без пароля", invocationCount = 3, testName = "Вход в систему без пароля",
            groups = {"Smoke"}, dependsOnMethods = {"checkLogin"})
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.auth("standard-user", "");
        Assert.assertEquals(loginPage.authError(),
                "Epic sadface: Password is required",
                "Сообщение не соответствует");
    }

    @Test (priority = 1, description = "Проверка входа в систему c валидными данными", invocationCount = 3, testName = "Вход в систему",
            groups = {"Smoke"})
    public void checkLogin() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        assertTrue(productsPage.isPageProducts());
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][] {
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test (dataProvider = "LoginData")
    public void checkLoginWithNegativeValue (String user, String password, String expectedMessage){
        loginPage.open();
        loginPage.auth(user, password);
        Assert.assertEquals(loginPage.authError(), expectedMessage, "Сообщение не соответствует");
    }
}
