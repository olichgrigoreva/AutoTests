package test.API;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TestAPI {
    @Test
    private void testForecast() {
        try {
            URL jsonURL = new URL("http://api.openweathermap.org/data/2.5/forecast?q=Yoshkar-Ola,RU&units=metric&cnt=16&APPID=e5ce38bf6ffbd303e2f80398b3c54c69");
            ObjectMapper objectMapper = new ObjectMapper();
            Forecast forecast = objectMapper.readValue(jsonURL, Forecast.class);

            System.out.println(forecast.city.name + "\n" + forecast.parameter);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
