package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Results
    implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("formatted_address")
    private String formattedAddress;

    @JsonProperty("geometry")
    private Geometry geometry;

    public String getFormattedAddress() {

        return formattedAddress;
    }

    public void setFormattedAddress(String formattedAddress) {

        this.formattedAddress = formattedAddress;
    }


    public Geometry getGeometry() {

        return geometry;
    }


    public void setGeometry(Geometry geometry) {

        this.geometry = geometry;
    }
}
