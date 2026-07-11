package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkCorrectLogin() {
        System.out.println("LoginTest.checkCorrectLogin is running in Thraed" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        assertEquals(productsPage.getTitle(), "Products",
                "Заголовок страницы каталога не соответствует заданному");

    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"Standard_user", "secret_sauce", "Epic sadface: Username and password do not match any user in " +
                        "this service"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Test(dataProvider = "incorrectLoginData", enabled = true, invocationCount = 1)
    public void checkIncorrectLogin(String user, String password, String errorMessage) {
        System.out.println("LoginTest.checkIncorrectLogin is running in Thread" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user, password);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMessage);
    }
}
