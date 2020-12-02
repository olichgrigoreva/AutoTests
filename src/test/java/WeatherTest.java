import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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

        gotoUrl("https://openweathermap.org/");
        useDegreeMetric("//label[@for='metric']");
        enterCity(city);

        String strCelsius = driver.findElement(By.cssSelector(".search-dropdown-menu > li > span:nth-child(2)")).getText();
        float celsiusDegrees = Integer.parseInt(strCelsius.replaceAll("[°CF]", ""));
        System.out.println(celsiusDegrees);

        useDegreeMetric("//label[@for='imperial']");
        enterCity(city);

        String strFahrenheit = driver.findElement(By.cssSelector(".search-dropdown-menu > li > span:nth-child(2)")).getText();
        float fahrenheitDegrees = Integer.parseInt(strFahrenheit.replaceAll("[°CF]", ""));
        System.out.println(fahrenheitDegrees);
        System.out.println(celsiusToFahrenheit(celsiusDegrees));

        Assert.assertEquals(fahrenheitDegrees, celsiusToFahrenheit(celsiusDegrees));
    }

}
