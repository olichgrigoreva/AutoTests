import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

public class TestBase {
    protected float celsiusToFahrenheit(float celsiusDegrees) {
        return Math.round(celsiusDegrees * 1.8 + 32);
    }
}
