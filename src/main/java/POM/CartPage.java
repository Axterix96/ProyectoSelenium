package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{

    By checkoutBtn = By.xpath("//button[text()='Checkout']");

    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void goToPaymentPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutBtn));
        driver.findElement(checkoutBtn).click();
    }

}
