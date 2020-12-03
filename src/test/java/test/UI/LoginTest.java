package test.UI;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.SignIn;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.WebDriverRunner.url;

public class LoginTest {

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://home.openweathermap.org/users/sign_in";
    }

    @DataProvider
    public Iterator<Object[]> autorizationData() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"mznlhaxuocsiztzpox@miucce.online", "qwerty123"});
        return list.iterator();
    }

    @Test(dataProvider = "autorizationData")
    public void testLoginForm(String email, String password) {
        SignIn signInPage = new SignIn();
        signInPage.open();
        signInPage.fillForm(email, password);
        Assert.assertEquals(url(), "https://home.openweathermap.org/");
    }
}
