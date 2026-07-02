package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {
    @Test
    public void checkGoodsAddded() throws InterruptedException {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products",
                "Заголовок страницы каталога не соответствует заданному");

        productsPage.addGoodsToCart("Sauce Labs Onesie");
        productsPage.addGoodsToCart(1);
        Thread.sleep(5000);
        assertTrue(productsPage.isCounterDisplayed());
        assertEquals(productsPage.getCounterText(), "2");
        assertEquals(productsPage.checkCounterValue(), "rgb(226, 35, 26)");
    }
}
