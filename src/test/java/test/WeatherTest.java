package test;

import com.codeborne.selenide.Configuration;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.Weather;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WeatherTest {

    @BeforeClass
    public static void setup() {
        Configuration.baseUrl = "https://openweathermap.org/";
    }

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
        Weather weatherPage = new Weather();
        weatherPage.open();
        weatherPage.useMetric("//label[@for='metric']");
        float celsiusDegrees = weatherPage.getTemtepature(city);
        weatherPage.useMetric("//label[@for='imperial']");
        float fahrenheitDegrees = weatherPage.getTemtepature(city);
        Assert.assertEquals(fahrenheitDegrees, weatherPage.celsiusToFahrenheit(celsiusDegrees));
    }
}