import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class TestBase {
    WebDriver driver;

    @BeforeSuite
    public void setup() {
        init();
    }

    protected void enterCity(String city) {
        driver.findElement(By.cssSelector(".search-container > input")).click();
        driver.findElement(By.cssSelector(".search-container > input")).clear();
        driver.findElement(By.cssSelector(".search-container > input")).sendKeys(city);
        driver.findElement(By.cssSelector(".search > .button-round")).click();
    }

    protected void useDegreeMetric(String xpath) {
        driver.findElement(By.xpath(xpath)).click();
    }

    protected void logOut() {
        gotoUrl("https://home.openweathermap.org/");
        driver.findElement(By.id("open-dropdown")).click();
        driver.findElement(By.cssSelector(".logout")).click();
    }

    protected void fillLoginForm(String email, String password) {
        driver.findElement(By.id("user_email")).click();
        driver.findElement(By.id("user_email")).clear();
        driver.findElement(By.id("user_email")).sendKeys(email);
        driver.findElement(By.id("user_password")).click();
        driver.findElement(By.id("user_password")).clear();
        driver.findElement(By.id("user_password")).sendKeys(password);
        driver.findElement(By.name("commit")).click();
    }

    @AfterSuite
    public void quitDriver() {
        stop();
    }

    private void stop() {
        driver.quit();
    }

    private void init() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void gotoUrl(String url) {
        driver.get(url);
    }

    protected float celsiusToFahrenheit(float celsiusDegrees) {
        return Math.round(celsiusDegrees * 1.8 + 32);
    }
}
