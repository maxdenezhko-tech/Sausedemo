package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    WebDriver driver;
    private final By titleElement = By.cssSelector("span[class='title']");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
       return driver.findElement(titleElement).getText();
    }
}
