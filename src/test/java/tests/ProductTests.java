package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ProductTests extends BaseTest{

    //Добавление товара в корзину
    @Test (priority = 1, description = "Проверка добавления товара в корзину", testName = "Добавление товара в корзину",
            groups = {"Smoke"})
    public void AddToCart() {
        //Логин
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        //Проверка что на странице каталога
        assertTrue(productsPage.isPageProducts());
        //Получаем список товаров
        productsPage.getItems();
        //Добавляем товары в корзину
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        //Проверяем что кнопка add to cart поменялась на remove
        assertTrue(productsPage.isRemoveButtonDisplayed());
    }
    //Удаление товара из корзины
    @Test (priority = 2, description = "Проверка удаления товара из корзины", testName = "Удаление товара из корзины",
            groups = {"Smoke"})
    public void RemoveFromCart() {
        //Логин
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        //Проверка что на странице каталога
        assertTrue(productsPage.isPageProducts());
        //Получаем список товаров
        productsPage.getItems();
        //Добавляем товары в корзину
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        //Проверяем что кнопка add to cart поменялась на remove
        assertTrue(productsPage.isRemoveButtonDisplayed());
        productsPage.clickRemoveFromCartByIndex(0);
        productsPage.clickRemoveFromCartByIndex(0);
    }
    //Переход в корзину
    @Test (priority = 3, description = "Проверка нажатия на кнопку корзины", testName = "Нажатие на кнопку корзины",
            groups = {"Smoke"})
    public void CartButtonClick() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        //Проверка что на странице каталога
        assertTrue(productsPage.isPageProducts());
        //Получаем список товаров
        productsPage.getItems();
        //Добавляем товары в корзину
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        //Проверка что иконка корзины отображается
        assertTrue(productsPage.isCartButtonDisplayed());
        //Переход в корзину
        productsPage.clickCartButton();
    }
}
