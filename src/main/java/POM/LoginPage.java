package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    By registerBtn = By.xpath("//div[@class='banner']//a[@class='btn1']");

    By usernameInput = By.id("userEmail");

    By passwordInput = By.id("userPassword");

    By loginBtn = By.id("login");


public void goToRegisterMenu()
{
    driver.findElement(registerBtn).click();

}
    public void loginUser() throws IOException, FileNotFoundException {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("src\\test\\java\\TestCases\\GlobalData.properties");
        prop.load(fis);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();



    }



}
