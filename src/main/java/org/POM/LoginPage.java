package org.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    By usernameInput = By.id("userEmail");

    By passwordInput = By.id("userPassword");

    By loginBtn = By.id("login");

    public void loginUser() throws IOException {
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("src\\main\\java\\org\\POM\\GlobalData.properties");
        prop.load(fis);

        String username = prop.getProperty("username");
        String password = prop.getProperty("password");

        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();



    }



}
