package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    public static final String ADD_TO_CART =
            "//*[text()='%s']//ancestor::div[@class='inventory_item']//child::button[text()=" +
                    "'Add to cart']";
    public static final String ADD_TO_CART_BY_INDEX ="//*[text()='Add to cart']";
    private final By titleElement = By.cssSelector("span[class='title']");
    private final By counter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
       return driver.findElement(titleElement).getText();
    }

    public void addGoodsToCart(String goodsName) {
        By addToCart = By.xpath(String.format(ADD_TO_CART,goodsName));
       // By addToCart = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(addToCart).click();
    }

    public void addGoodsToCart(int goodsIndex) {
        driver.findElements(By.xpath(ADD_TO_CART_BY_INDEX)).get(goodsIndex).click();
    }

    public boolean isCounterDisplayed() {
        return driver.findElement(counter).isDisplayed();
    }

    public String getCounterText() {
        return driver.findElement(counter).getText();
    }

    public String checkCounterValue() {
         return driver.findElement(counter).getCssValue("background-color");
    }
}
