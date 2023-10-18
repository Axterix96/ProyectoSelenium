package TestCases;

import POM.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;
import org.junit.runners.Parameterized;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestCase extends BaseTest {


    @Test

    public void login() throws IOException {
        page.GetInstance(LoginPage.class).loginUser();
    }

    @Test
    public void addProduct() throws IOException {
        page.GetInstance(LoginPage.class).loginUser();
        page.GetInstance(HomePage.class).addProduct("adidas original");
    }

    @Test
    public void goToPay() throws IOException {
        page.GetInstance(LoginPage.class).loginUser();
        page.GetInstance(HomePage.class).addProduct("adidas original");
        page.GetInstance(HomePage.class).goToCheckout();
        page.GetInstance(CartPage.class).goToPaymentPage();
        page.GetInstance(PaymentPage.class).pay();
    }


 @Test
    public void registerUser() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader("src\\test\\java\\TestCases\\data.json");
        Object obj = jsonParser.parse(reader);

        JSONObject userRegisterJsonObject =(JSONObject) obj;
        JSONArray userRegisterArray = (JSONArray) userRegisterJsonObject.get("clientsInfo");

        page.GetInstance(LoginPage.class).goToRegisterMenu();

        String arrayJson[] = new String[userRegisterArray.size()];
        for(int i = 0; i < userRegisterArray.size();i++)
        {
            page.GetInstance(LoginPage.class).goToRegisterMenu();
            JSONObject users = (JSONObject)userRegisterArray.get(i);
            String firstname =(String) users.get("firstname");

            String lastname =(String) users.get("lastname");
            int random = (int) Math.random();
            String stringRandom = String.valueOf(random);
            String email =(String) users.get("email");
            String [] emailParts = email.split("@");
            String finalEmail = emailParts[0] + stringRandom +"@"+ emailParts[1];
            String phoneNumber =(String) users.get("phoneNumber");
            String occupation =(String) users.get("occupation");
            String gender =(String) users.get("phoneNumber");
            String password =(String) users.get("password");
            String confirmPassword =(String) users.get("confirmPassword");
            String older =(String) users.get("older");

            page.GetInstance(RegisterPage.class).registerUser(firstname,lastname,finalEmail,phoneNumber,occupation,gender,password,confirmPassword,
                    older);

            page.GetInstance(RegisterPage.class).goToRegisterPage();


        }
    }
}
