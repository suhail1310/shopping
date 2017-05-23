package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerDetails
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("customer_address")
    private String customerAddress;

    @JsonProperty("custLat")
    private float customerLatitude;

    @JsonProperty("custLng")
    private float customerLongitute;


    public float getLatitude() {

        return customerLatitude;
    }

    public void setLatitude(float latitude) {

        this.customerLatitude = latitude;
    }

    public float getLongitute() {

        return customerLongitute;
    }

    public void setLongitute(float longitute) {

        this.customerLongitute = longitute;
    }


    public String getCustomerAddress() {

        return customerAddress;
    }


    public void setCustomerAddress(String customerAddress) {

        this.customerAddress = customerAddress;
    }
}
