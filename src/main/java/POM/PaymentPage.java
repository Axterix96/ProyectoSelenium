package POM;


import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class PaymentPage extends  BasePage{

    public PaymentPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By placeOrderBtn = By.xpath("//a[text()='Place Order ']");

    By cvvInput = By.cssSelector(".small input");

    By expireDateFirst = By.cssSelector("select.ddl:last-of-type");

    By expireDateLast = By.cssSelector("select.ddl:last-of-type");

    By nameOnCardInput = By.xpath("//div[@class='row']//div[@class='field']//input[@class='input txt']");

    By applyCouponInput = By.xpath("//input[@name='coupon']");

    By loadingIcon = By.cssSelector(".ng-animating");

    By applyCouponBtn = By.xpath("//button[@class='btn btn-primary mt-1']");

    By toastContainer = By.id("toast-container");

    By regionInput = By.cssSelector("input[placeholder='Select Country']");

    By searchRegion = By.cssSelector("button.ta-item:nth-child(2)");

    By spinner = By.xpath("//div[@class='ngx-spinner-overlay ng-tns-c31-3 ng-trigger ng-trigger-fadeIn ng-star-inserted']");

    public void placeOrderWithoutRegion(String expireDateFirst, String expireDateLast, String cvv, String name, String coupon) throws InterruptedException {
        Select expireDateFirstSelect = new Select(driver.findElement(this.expireDateFirst));
        expireDateFirstSelect.selectByVisibleText(expireDateFirst);

        Select expireDateLastSelect = new Select(driver.findElement(this.expireDateLast));
        expireDateLastSelect.selectByVisibleText(expireDateLast);

        driver.findElement(cvvInput).sendKeys(cvv);
        driver.findElement(nameOnCardInput).sendKeys(name);
        driver.findElement(applyCouponInput).sendKeys(coupon);
        driver.findElement(applyCouponBtn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));


       driver.findElement(placeOrderBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(toastContainer));

            Assert.assertEquals("Si funciono la prueba",driver.findElement(toastContainer).getText(),"Please Enter Full Shipping Information");

        System.out.println(driver.findElement(toastContainer).getText());



    }

    public void placeOrderWithRegion(String region, String expireDateFirst, String expireDateLast, String cvv, String name, String coupon)
    {
        Select expireDateFirstSelect = new Select(driver.findElement(this.expireDateFirst));
        expireDateFirstSelect.selectByVisibleText(expireDateFirst);

        Select expireDateLastSelect = new Select(driver.findElement(this.expireDateLast));
        expireDateLastSelect.selectByVisibleText(expireDateLast);

        driver.findElement(cvvInput).sendKeys(cvv);
        driver.findElement(nameOnCardInput).sendKeys(name);
        driver.findElement(applyCouponInput).sendKeys(coupon);
        driver.findElement(applyCouponBtn).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
        driver.findElement(regionInput).sendKeys(region);
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchRegion));
        driver.findElement(searchRegion).click();


        driver.findElement(placeOrderBtn).click();

        wait.until(ExpectedConditions.elementToBeClickable(toastContainer));
        Assert.assertEquals("Si funciono la prueba",driver.findElement(toastContainer).getText(),"Order Placed Successfully");


    }

}
