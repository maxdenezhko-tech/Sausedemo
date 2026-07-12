package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPanel {
    public final WebDriver driver;

    private final By cartLink = By.cssSelector(".shopping_cart_link");

    public NavigationPanel(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToBasket() {
        driver.findElement(cartLink).click();
    }

}
