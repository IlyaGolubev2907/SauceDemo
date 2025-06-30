package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class ProductTests extends BaseTest{

    //Добавление товара в корзину
    @Test
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
    @Test
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
    @Test
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
