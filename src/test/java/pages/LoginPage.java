package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class LoginPage extends BasePage {

    private final By LOGIN_FIELD = By.id("user-name");
    private final By PASSWORD_FIELD = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");
    private final By ERROR_MESSAGE = By.cssSelector("[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Открытие страницы логина")
    public LoginPage open() {
        driver.get(BASE_URL);
        return this;
    }

    @Step("Вход в систему с данными {user}: пользователь, {password}: пароль")
    public LoginPage auth(String user, String password) {
        driver.findElement(LOGIN_FIELD).sendKeys(user);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    @Step("Проверка ошибки авторизации")
    public LoginPage verifyAuthError(String expectedError) {
        String actualError = driver.findElement(ERROR_MESSAGE).getText();
        Assert.assertEquals(actualError, expectedError, "Текст ошибки не совпадает");
        return this;
    }

    @Step("Проверка успешного входа (переход на страницу продуктов)")
    public ProductsPage verifySuccessfulLogin() {
        return new ProductsPage(driver); // Возвращаем следующую страницу
    }
}