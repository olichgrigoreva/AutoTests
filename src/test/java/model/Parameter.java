package model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Parameter {
    public int dt;
    @JsonProperty("main")
    public Temp temp;
    public List<Weather> weather;
    public Clouds clouds;
    public Wind wind;
    public int visibility;
    public int pop;
    public Sys sys;
    public String dt_txt;

    @Override
    public String toString() {
        return "\n" + dt_txt + " " + temp;
    }
}
