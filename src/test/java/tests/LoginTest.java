package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(priority = 2, description = "Проверка входа в систему без пароля",
            invocationCount = 3, testName = "Вход в систему без пароля",
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
        loginPage.open()
                .auth("standard_user", "")
                .verifyAuthError("Epic sadface: Password is required");
    }

    @Test(priority = 1, description = "Проверка входа в систему c валидными данными",
            invocationCount = 3, testName = "Вход в систему",
            groups = {"Smoke"})
    public void checkLogin() {
        loginPage.open()
                .auth("standard_user", "secret_sauce")
                .verifySuccessfulLogin(); // Возвращает ProductsPage
    }

    @DataProvider(name = "LoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"test", "test", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @Test(dataProvider = "LoginData")
    public void checkLoginWithNegativeValue(String user, String password, String expectedMessage) {
        loginPage.open()
                .auth(user, password)
                .verifyAuthError(expectedMessage);
    }
}