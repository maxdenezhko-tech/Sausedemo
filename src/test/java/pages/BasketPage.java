package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BasketPage extends BasePage {
    private final By goodsTitle = By.cssSelector(".inventory_item_name");
    private final By title = By.cssSelector("span[class='title']");

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @Step("Проверяем наименование страницы корзины товаров")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Проверяем наименование товаров в корзине")
    public ArrayList<String> getProductNames() {
        List<WebElement> allProducts = driver.findElements(goodsTitle);

        ArrayList<String> names = new ArrayList<>();

        for (WebElement product : allProducts) {
            names.add(product.getText());
        }
        return names;
    }
}
