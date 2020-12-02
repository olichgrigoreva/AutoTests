import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class WeatherTest extends TestBase {
    @DataProvider
    public Iterator<Object[]> listOfCity() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"London, GB"});
        list.add(new Object[]{"Yoshkar-Ola, RU"});
        list.add(new Object[]{"Moscow, RU"});
        return list.iterator();
    }

    @Test(dataProvider = "listOfCity")
    public void testWeather(String city) {
        open("https://openweathermap.org/");
        $(By.xpath("//label[@for='metric']")).click();
        $(By.cssSelector(".search-container > input")).setValue(city).pressEnter();
        String strCelsius = $(By.cssSelector(".search-dropdown-menu > li > span:nth-child(2)")).getText();
        float celsiusDegrees = Integer.parseInt(strCelsius.replaceAll("[°CF]", ""));
        $(By.xpath("//label[@for='imperial']")).click();
        $(By.cssSelector(".search-container > input")).setValue(city).pressEnter();
        String strFahrenheit = $(By.cssSelector(".search-dropdown-menu > li > span:nth-child(2)")).getText();
        float fahrenheitDegrees = Integer.parseInt(strFahrenheit.replaceAll("[°CF]", ""));
        Assert.assertEquals(fahrenheitDegrees, celsiusToFahrenheit(celsiusDegrees));
    }
}