package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BasketTest extends BaseTest {

    @Test
    public void checkGoodsAdddedToBasket() {
        System.out.println("BasketTest.checkGoodsAddedToBasket is running in Thread" + Thread.currentThread().getId());
        List<String> goodsList =
                List.of(
                        "Sauce Labs Backpack",
                        "Sauce Labs Bolt T-Shirt");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }
        productsPage.switchToBasket();

        assertEquals(basketPage.getTitle(), "Your Cart",
                "Заголовок страницы каталога не соответствует заданному");

        assertTrue(basketPage.getProductNames().equals(goodsList));
        assertTrue(basketPage.getProductNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
