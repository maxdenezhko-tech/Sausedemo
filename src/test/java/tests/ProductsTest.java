package tests;

import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAddded() {
        System.out.println("ProductTest.checkGoodsAdded is running in Thread" + Thread.currentThread().getId());
        List<String> goodsList =
                List.of(
                        "Sauce Labs Onesie",
                        "Sauce Labs Fleece Jacket",
                        "Test.allTheThings() T-Shirt (Red)");
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products",
                "Заголовок страницы каталога не соответствует заданному");

        productsPage.addGoodsToCart(1);
        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }

        assertTrue(productsPage.isCounterDisplayed());
        assertEquals(productsPage.getCounterText(), "4");
        assertEquals(productsPage.checkCounterColor(), "rgba(226, 35, 26, 1)");
    }
}
