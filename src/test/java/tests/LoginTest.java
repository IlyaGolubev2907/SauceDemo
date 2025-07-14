package tests;

import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class LoginTest extends BaseTest{

    @Test (priority = 2, description = "Проверка входа в систему без пароля", invocationCount = 3, testName = "Вход в систему без пароля",
            groups = {"Smoke"}, dependsOnMethods = {"checkLogin"})
    @Severity(SeverityLevel.NORMAL)
    @Owner("Ilya Golubev")
    @Link("https://saucedemo.com")
    @Epic("Login Page")
    @Feature("Login")
    @Story("Login without password")
    @TmsLink("ITM-4")
    @Issue("ITM-4-1")
    @Description("Проверка недоступности логина без ввода валидного пароля")
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
                {"standard_user", "", "Epic sadface: Password is require"},
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
