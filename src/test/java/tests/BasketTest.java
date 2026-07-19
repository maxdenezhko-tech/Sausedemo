package tests;

import org.testng.annotations.Test;

import java.util.List;

import static enums.TitleNaming.BASKET;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.withAdminPermission;

public class BasketTest extends BaseTest {

    @Test(description = "Проверка наличия товара в корзине", priority = 1)
    public void checkGoodsAdddedToBasket() {
        System.out.println("BasketTest.checkGoodsAddedToBasket is running in Thread" + Thread.currentThread().getId());
        List<String> goodsList =
                List.of(
                        "Sauce Labs Backpack",
                        "Sauce Labs Bolt T-Shirt");
        loginPage.open();
        loginPage.login(withAdminPermission());

        for (String goods : goodsList) {
            productsPage.addGoodsToCart(goods);
        }
        productsPage.navigationPanel.switchToBasket();

        assertEquals(basketPage.getTitle(), BASKET.getDisplayName(),
                "Заголовок страницы каталога не соответствует заданному");

        assertTrue(basketPage.getProductNames().equals(goodsList));
        assertTrue(basketPage.getProductNames().contains("Sauce Labs Bolt T-Shirt"));
    }
}
