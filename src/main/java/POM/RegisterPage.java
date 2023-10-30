package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage extends BasePage{
    public RegisterPage (WebDriver driver, WebDriverWait wait){
        super(driver,wait);
    }

    By firstNameInput = By.id("firstName");

    By lastNameInput = By.id("lastName");

    By emailInput = By.id("userEmail");

    By phoneNumberInput = By.id("userMobile");

    By occupationSelect = By.xpath("//div[@class='form-group col-md-6']//select[@formcontrolname='occupation']");

    By maleRadioBtn = By.xpath("//div[@class='form-group col-md-6']//input[@value='Male']");

    By femaleRadioBtn = By.xpath("//div[@class='form-group col-md-6']//input[@value='Female']");

    By passwordInput = By.id("userPassword");

    By confirmPasswordInput = By.id("confirmPassword");

    By chkbox18 = By.xpath("//div[@class='col-md-1']//input[@type='checkbox']");

    By registerBtnForm = By.id("login");
    By registerBtn = By.xpath("//div[@class='banner']//a[@class='btn1']");

    By loginBtn = By.cssSelector("[routerlink='/auth']");

    public void registerUser(String firstname,String lastname, String email, String phone, String occupation, String radioGender, String password,
                             String passwordConfirm, String check)
    {
        driver.findElement(firstNameInput).sendKeys(firstname);
        driver.findElement(lastNameInput).sendKeys(lastname);

        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(phoneNumberInput).sendKeys(phone);
        Select drpOccupation = new Select(driver.findElement(occupationSelect));
        drpOccupation.selectByVisibleText(occupation);
        if(radioGender.equals("Male") )
        {
            driver.findElement(maleRadioBtn).click();

        }
        else
        {
            driver.findElement(femaleRadioBtn).click();
        }
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(confirmPasswordInput).sendKeys(passwordConfirm);

        if(check.equals("Yes"))
        {
            driver.findElement(chkbox18).click();
        }
        else
        {
            driver.findElement(chkbox18).click();
            driver.findElement(chkbox18).click();
        }
        driver.findElement(registerBtnForm).click();
        driver.findElement(registerBtn).click();
    }

    public void goToRegisterPage()
    {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginBtn));
        //toast para validar la creacion de usuario
        //falto la validacion de la creacion del usuario
        // se requiere para la realizacion de los reportes y no todos entenderan como funciona el codigo
        driver.findElement(loginBtn).click();
    }
}
