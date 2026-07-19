package tests;

import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class ProductsTest extends BaseTest {
    @Test(description = "Добавление товаров в корзину")
    public void checkGoodsAddded() {
        System.out.println("ProductTest.checkGoodsAdded is running in Thread" + Thread.currentThread().getId());
        List<String> goodsList =
                List.of(
                        "Sauce Labs Onesie",
                        "Sauce Labs Fleece Jacket",
                        "Test.allTheThings() T-Shirt (Red)");
        loginPage.open();
        loginPage.login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(),
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
