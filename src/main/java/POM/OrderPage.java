package POM;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class OrderPage extends BasePage{


    By csvBtn = By.cssSelector("button.mt-3");

    By productId = By.xpath("//label[@class='ng-star-inserted']");

    By productName = By.xpath("//div[@class='ng-star-inserted']//td[@class='line-item product-info-column m-3']//div[@class='title']");

    By orderBtn = By.cssSelector("button[routerlink='/dashboard/myorders']");

    By tableOrders = By.xpath("//table//tr");

    By tableTh = By.xpath("//table//tr//th");

    By labelOrder = By.xpath("//td[@class='lead secondary mt-4']");

    By toastOrder = By.xpath("//div[@id='toast-container']");
    public OrderPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void downloadCsv() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(labelOrder));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(toastOrder));
        wait.until(ExpectedConditions.elementToBeClickable(csvBtn));
        driver.findElement(csvBtn).click();
        Thread.sleep(10000);

    }
//C:\Users\nicolas.sogbi\Downloads
            public void validateFileExist() {
                File f = new File("C:\\Users\\nicolas.sogbi\\Downloads\\order-invoice_xnicolaz96.csv");
                Assert.assertTrue(f.exists());
            }


    public void validateOrder(String productName) throws InterruptedException {
        Thread.sleep(5000);
        String productSString = driver.findElement(productId).getText().replace("| ","");
        String productStringFinal = productSString.replace(" |","");

        if(driver.findElement(this.productName).getText().equals(productName))
        {

            driver.findElement(orderBtn).click();

            for( int i = 0; i < driver.findElements(tableOrders).size();i++)
            {

                if(driver.findElements(tableTh).get(i).getText().equals(productStringFinal))
                {
                    Assert.assertEquals("Si paso la prueba",driver.findElements(tableTh).get(i).getText(),productStringFinal);
                }
            }
        }



    }

}
