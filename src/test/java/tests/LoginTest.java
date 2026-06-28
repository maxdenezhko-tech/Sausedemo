package tests;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkCorrectLogin() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products",
                "Заголовок страницы каталога не соответствует заданному");

    }

    @Test
    public void checkEmptyLogin() {
        loginPage.open();
        loginPage.login("", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username is required", "Текст ошибки не " +
                "совпадает с ожидаемым");
    }

    @Test
    public void checkEmptyPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Password is required", "Текст ошибки не " +
                "совпадает с ожидаемым");
    }

    @Test
    public void checkIncorrectLogin() {
        loginPage.open();
        loginPage.login("Standard_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Username and password do not match any user in " +
                "this service", "Текст ошибки не совпадает с ожидаемым");
    }

    @Test
    public void checkLockedOutUserLogin() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), "Epic sadface: Sorry," +
                " this user has been locked out.", "Текст ошибки не совпадает с ожидаемым");
    }
}
