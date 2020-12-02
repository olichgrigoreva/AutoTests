import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginTest extends TestBase {

    @DataProvider
    public Iterator<Object[]> autorizationData() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"mznlhaxuocsiztzpox@miucce.online", "qwerty123"});
        return list.iterator();
    }

    @Test(dataProvider = "autorizationData", enabled = false)
    public void testLoginForm(String email, String password) {
        gotoUrl("https://home.openweathermap.org/users/sign_in");
        fillLoginForm(email, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://home.openweathermap.org/");
    }

}
