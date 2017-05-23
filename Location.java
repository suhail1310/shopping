package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Location
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("lat")
    private float latitude;

    @JsonProperty("lng")
    private float longitute;


    public float getLatitude() {

        return latitude;
    }

    public void setLatitude(float latitude) {

        this.latitude = latitude;
    }

    public float getLongitute() {

        return longitute;
    }

    public void setLongitute(float longitute) {

        this.longitute = longitute;
    }
}
