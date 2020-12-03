package test.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import model.Forecast;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class TestAPI {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://api.openweathermap.org";
    }

    @DataProvider
    public Iterator<Object[]> connectionData() {
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{"Yoshkar-Ola", "metric", 16, "e5ce38bf6ffbd303e2f80398b3c54c69"});
        return list.iterator();
    }

    @Test(dataProvider = "connectionData")
    private void testForecast(String city, String metric, int cnt, String apiKey) {
        String url = String.format("/data/2.5/forecast?q=%s&units=%s&cnt=%d&APPID=%s", city, metric, cnt, apiKey);
        String jsonURL = "http://api.openweathermap.org" + url;

        when().
                get(url).
        then().
                statusCode(200).assertThat().
                body("city.name", equalTo(city));

        try {
            URL source = new URL(jsonURL);
            ObjectMapper objectMapper = new ObjectMapper();
            Forecast forecast = objectMapper.readValue(source, Forecast.class);

            System.out.println(forecast.city.name + "\n" + forecast.parameter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
