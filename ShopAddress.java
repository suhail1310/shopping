package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class ShopAddress implements Serializable{

    private static final long serialVersionUID = 1L;

    @JsonProperty("number")
    private String number ;

    @JsonProperty("postalCode")
	private int postalCode;

    @JsonProperty("latitude")
    private float latitude;

    @JsonProperty("longitude")
    private float longitude;

	public int getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}


    public float getLatitude() {

        return latitude;
    }


    public void setLatitude(float latitude) {

        this.latitude = latitude;
    }


    public float getLongitude() {

        return longitude;
    }


    public void setLongitude(float longitude) {

        this.longitude = longitude;
    }


    public String getNumber() {

        return number;
    }


    public void setNumber(String number) {

        this.number = number;
    }
}
