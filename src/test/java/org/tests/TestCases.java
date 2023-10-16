package org.tests;

import org.POM.HomePage;
import org.POM.LoginPage;
import org.junit.Test;

import java.io.IOException;

public class TestCases extends BaseTest{


    @Test

    public void login() throws IOException {
        page.GetInstance(LoginPage.class).loginUser();
    }

    @Test
    public void addCoat() throws IOException {
        page.GetInstance(LoginPage.class).loginUser();
        page.GetInstance(HomePage.class).addZaraCoat();
    }
}
