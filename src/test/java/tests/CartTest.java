package tests;

import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CartTest extends BaseTest {

    @Test (priority = 1, description = "Проверка, что в корзине есть товары", invocationCount = 1, testName = "Проверка наличия товаров в корзине",
            groups = {"Smoke"})
    public void cartIsNotEmpty() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        productsPage.getItems();
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        productsPage.clickCartButton();
        cartPage.isPageCart();
        cartPage.isCartEmpty();
        assertFalse(cartPage.isCartEmpty());
    }
    //Проверка что корзина пустая после удаления товаров
    @Test (priority = 2, description = "Проверка удаления товара из корзины", testName = "Удаление товара из корзины",
            groups = {"Smoke"})
    public void RemoveFromCartTest() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        productsPage.getItems();
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        productsPage.clickCartButton();
        cartPage.getRemoveButtons();
        cartPage.clickRemoveFromCartByIndex(0);
        cartPage.clickRemoveFromCartByIndex(0);
        cartPage.isCartEmpty();
        assertTrue(cartPage.isCartEmpty());
    }
    @Test (priority = 3, description = "Проверка, что в корзине нет товаров", invocationCount = 1, testName = "Проверка отсутствия товаров в корзине",
            groups = {"Smoke"})
    //Зафейленый тест для скриншота
    public void cartIsEmpty() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        productsPage.isPageProducts();
        productsPage.getItems();
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        productsPage.clickCartButton();
        cartPage.isPageCart();
        cartPage.isCartEmpty();
        assertTrue(cartPage.isCartEmpty());
    }
}
