package org.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class HomePage extends BasePage{


    public HomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By productsCards = By.cssSelector(".mb-3");

    By toastContainer = By.cssSelector("#toast-container");

    By loadingIcon = By.cssSelector(".ng-animating");

    By cartBtn = By.cssSelector("[routerlink*='cart']");

    public void addZaraCoat()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsCards));
        List<WebElement> products = driver.findElements(productsCards);
        WebElement prod = products.stream().filter(product->
                product.findElement(By.cssSelector("h5 b")).getText().equals("adidas original")).findFirst().orElse(null);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body button:last-of-type")));
        prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
    }

    public void goToCheckout()
    {
        driver.findElement(cartBtn).click();
    }

}
