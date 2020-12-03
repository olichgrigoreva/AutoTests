package test.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    public String cod;
    public int message;
    public int cnt;
    @JsonProperty("list")
    public List<Parameter> parameter;
    public City city;

    public static String listToString(List<?> list) {
        String result = "+";
        for (int i = 0; i < list.size(); i++) {
            result += " " + list.get(i);
        }
        return result;
    }
}
