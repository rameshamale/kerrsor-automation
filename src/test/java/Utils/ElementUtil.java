package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class ElementUtil {
    WebDriver driver;

    public ElementUtil(WebDriver driver) {
        this.driver = driver;  // Reuse the driver from BaseTest
    }

    public void selectDropdownByVisibleText(WebElement element, String text) {
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
    }

    public void enterDate(By locator, String date) {
        WebElement dateField = driver.findElement(locator);
        dateField.clear();
        dateField.sendKeys(date);
    }

    public void enterDateTime(By locator, String dateTime) {
        WebElement dateTimeField = driver.findElement(locator);
        dateTimeField.clear();
        dateTimeField.sendKeys(dateTime);
    }

}
