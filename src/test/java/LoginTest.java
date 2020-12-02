import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.*;

public class LoginTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> autorizationData() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"mznlhaxuocsiztzpox@miucce.online", "qwerty123"});
        return list.iterator();
    }

    @Test(dataProvider = "autorizationData")
    public void testLoginForm(String email, String password) {
        open("https://home.openweathermap.org/users/sign_in");
        $("#user_email").setValue(email);
        $("#user_password").setValue(password).pressEnter();
        Assert.assertEquals(url(), "https://home.openweathermap.org/");
    }
}
