package POM;

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

    By productsCards = By.xpath("//div[@class='card-body']//b");

    By toastContainer = By.cssSelector("#toast-container");

    By loadingIcon = By.cssSelector(".ng-animating");

    By cartBtn = By.xpath("//button[@routerlink='/dashboard/cart']");

    By spinner = By.xpath("//div[@class='ngx-spinner-overlay ng-tns-c31-1 ng-trigger ng-trigger-fadeIn ng-star-inserted']");

    public void addProduct(String productName)
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productsCards));

       List<WebElement> products = driver.findElements(productsCards);

       for(int i =0; i <products.size();i++)
       {
           if(products.get(i).getText().toLowerCase().equals(productName))
           {
               WebElement prod = products.get(i).findElement(By.xpath("//b[(text()='"+productName+"')]/../..//button[contains(text(),' Add To Cart')]"));
               prod.click();

           }
       }
        wait.until(ExpectedConditions.visibilityOfElementLocated(toastContainer));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        driver.findElement(cartBtn).click();


    }

    public void goToCheckout()
    {
        driver.findElement(cartBtn).click();
    }




}
