package tests;

import org.testng.annotations.Test;
import pages.CartPage;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

public class CartTest extends BaseTest {
    @Test
    public void cartIsNotEmpty() {
        loginPage.open();
        loginPage.auth("standard_user", "secret_sauce");
        productsPage.getItems();
        productsPage.clickAddToCartByIndex(0);
        productsPage.clickAddToCartByIndex(2);
        productsPage.clickCartButton();
        cartPage.isCartEmpty();
        assertFalse(cartPage.isCartEmpty());
    }
    //Проверка что корзина пустая после удаления товаров
    @Test
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
}
