import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Пользователь" +
                "не перенаправлен на страницу каталога");
        assertEquals(driver.findElement(By.cssSelector("span[class='title']")).getText(), "Products",
                "Заголовок страницы каталога не соответствует заданному");
        driver.quit();
    }

    @Test
    public void checkLockedOutUserLogin() {
        driver.findElement(By.cssSelector("#user-name")).sendKeys("locked_out_user");
        driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("#login-button")).click();

        assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/", "Пользователь был " +
                "перенаправлен со страницы авторизации");
        assertEquals(driver.findElement(By.cssSelector("div[class='login_logo']")).getText(), "Swag Labs",
                "Пользователь был перенаправлен со страницы авторизации");
        assertTrue(driver.findElement(By.cssSelector("h3[data-test='error']")).isDisplayed());
        assertEquals(driver.findElement(By.cssSelector("h3[data-test='error")).getText(), "Epic sadface: Sorry," +
                " this user has been locked out.", "Текст ошибки не совпадает с ожидаемым");
    }
}
