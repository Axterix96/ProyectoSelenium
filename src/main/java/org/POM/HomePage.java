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

    By productsCards = By.xpath("//div[@class='card-body']");

    By toastContainer = By.cssSelector("#toast-container");

    By loadingIcon = By.cssSelector(".ng-animating");

    By cartBtn = By.cssSelector("[routerlink*='cart']");


    public void addProduct(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsCards));

        driver.findElement(By.xpath("//b[contains(text(),'"+productName+"')]/../..//button[contains(text(),' Add To Cart')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
    }

    public void goToCheckout()
    {
        driver.findElement(cartBtn).click();
    }

    public void addProduct1(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsCards));
        List<WebElement> products = driver.findElements(productsCards);
        WebElement prod = products.stream().filter(product->
                product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals(productName)).findFirst().orElse(null);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body button:last-of-type")));
        prod.findElement(By.xpath("//b[contains(text(),'"+productName+"')]/../..//button[contains(text(),' Add To Cart')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
    }

}
