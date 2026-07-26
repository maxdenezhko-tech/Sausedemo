package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static user.UserFactory.*;

@Epic("Блок онлайн оплаты")
@Feature("Оплата банковской картой")
@Owner("Denezhko Maksim Aleksandrovich maxdenezhko@gmail.com")
public class LoginTest extends BaseTest {

    @Story("Ввод персональных данных")
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("Sausedemo")
    @Issue("Sausedemo/pulls")
    @Test(description = "Проверка корректной авторизации", priority = 1)
    public void checkCorrectLogin() {
        System.out.println("LoginTest.checkCorrectLogin is running in Thraed" + Thread.currentThread().getId());
        loginPage
                .open()
                .login(withAdminPermission());

        assertEquals(productsPage.getTitle(), PRODUCTS.getDisplayName(),
                "Заголовок страницы каталога не соответствует заданному");

    }

    @DataProvider(name = "incorrectLoginData")
    public Object[][] loginData() {
        return new Object[][]{
                {withEmptyLoginPermission(), "Epic sadface: Username is required"},
                {withEmptyPasswordPermission(), "Epic sadface: Password is required"},
                {withIncorrectCredentialsPermission(), "Epic sadface: Username and password do not match any user in " +
                        "this service"},
                {withLockedPermission(), "Epic sadface: Sorry, this user has been locked out."}
        };
    }

    @Story("Ввод персональных данных")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("Sausedemo")
    @Test(description = "Проверка некорректной авторизации", dataProvider = "incorrectLoginData", enabled = true,
            invocationCount = 1, priority = 2)
    public void checkIncorrectLogin(User user, String errorMessage) {
        System.out.println("LoginTest.checkIncorrectLogin is running in Thread" + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(user);

        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMessage);
    }
}
