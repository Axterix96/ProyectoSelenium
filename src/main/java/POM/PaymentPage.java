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


    public void placeOrderWithoutRegion() throws InterruptedException {
        Select expireDateFirstSelect = new Select(driver.findElement(expireDateFirst));
        expireDateFirstSelect.selectByVisibleText("07");

        Select expireDateLastSelect = new Select(driver.findElement(expireDateLast));
        expireDateLastSelect.selectByVisibleText("27");

        driver.findElement(cvvInput).sendKeys("123");
        driver.findElement(nameOnCardInput).sendKeys("Nicolas Sogbi Rodriguez");
        driver.findElement(applyCouponInput).sendKeys("coupon");
        driver.findElement(applyCouponBtn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderBtn));


       driver.findElement(placeOrderBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(toastContainer));

            Assert.assertEquals(driver.findElement(toastContainer).getText(),"Please Enter Full Shipping Information");

        System.out.println(driver.findElement(toastContainer).getText());



    }

    public void placeOrderWithRegion(String region)
    {
        Select expireDateFirstSelect = new Select(driver.findElement(expireDateFirst));
        expireDateFirstSelect.selectByVisibleText("07");

        Select expireDateLastSelect = new Select(driver.findElement(expireDateLast));
        expireDateLastSelect.selectByVisibleText("27");

        driver.findElement(cvvInput).sendKeys("123");
        driver.findElement(nameOnCardInput).sendKeys("Nicolas Sogbi Rodriguez");
        driver.findElement(applyCouponInput).sendKeys("coupon");
        driver.findElement(applyCouponBtn).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(loadingIcon));
        driver.findElement(regionInput).sendKeys(region);
        driver.findElement(searchRegion).click();

        driver.findElement(placeOrderBtn).click();
        wait.until(ExpectedConditions.elementToBeClickable(toastContainer));


    }

}
