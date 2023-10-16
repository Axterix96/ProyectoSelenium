package org.tests;

import org.POM.BaseDriver;
import org.POM.Page;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

public class BaseTest  {


     BaseDriver base = new BaseDriver();
    public Page page;
    @Before
    public void setup () throws IOException {
        base.initializeDriver();
        base.driver.manage().window().maximize();
        base.driver.get("https://rahulshettyacademy.com/client/");

        page = new Page(base.driver,base.wait);
    }
    @After
    public void teardown () {
        base.driver.quit();
    }
}
