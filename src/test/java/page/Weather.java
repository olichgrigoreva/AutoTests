package page;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Weather {
    public Weather open() {
        Selenide.open("/");
        return this;
    }

    public float getTemtepature(String city) {
        $(By.cssSelector(".search-container > input")).setValue(city).pressEnter();
        String str = $(By.cssSelector(".search-dropdown-menu > li > span:nth-child(2)")).getText();
        return Integer.parseInt(str.replaceAll("[°CF]", ""));
    }

    public void useMetric(String xpath) {
        $(By.xpath(xpath)).click();
    }

    public float celsiusToFahrenheit(float celsiusDegrees) {
        return Math.round(celsiusDegrees * 1.8 + 32);
    }
}
