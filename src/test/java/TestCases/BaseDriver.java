package TestCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseDriver {

    public WebDriver driver;

    public WebDriverWait wait;

    public void initializeDriver() throws IOException {
        //properties class
        Properties prop = new Properties();

        FileInputStream fis = new FileInputStream("src\\test\\java\\TestCases\\GlobalData.properties");
        prop.load(fis);

        String browserName = prop.getProperty("browser");


        //checar los logs
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();



        } else if (browserName.equalsIgnoreCase("edge")) {

            driver = new EdgeDriver();


        } else if (browserName.equalsIgnoreCase("firefox")) {

            driver = new FirefoxDriver();

        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    }
}
