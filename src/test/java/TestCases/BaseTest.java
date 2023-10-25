package TestCases;

import POM.Page;
import org.junit.After;
import org.junit.Before;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    BaseDriver base = new BaseDriver();
    public Page page;


    @Before
    public void Setup() throws IOException {
        base.initializeDriver();
       // base.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        base.driver.manage().window().maximize();
        base.driver.get("https://rahulshettyacademy.com/client/");
        page = new Page(base.driver,base.wait);


    }

    @After
    public void cleanup()
    {
        base.driver.quit();
    }

}

