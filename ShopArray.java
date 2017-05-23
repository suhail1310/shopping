package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shop.bean.ShopAddress;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ShopArray
    implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @JsonProperty("shopDetails")
    private ShopDetails[] shopDetails;


    public ShopDetails[] getShopDetails() {

        return shopDetails;
    }


    public void setShopDetails(ShopDetails[] shopDetails) {

        this.shopDetails = shopDetails;
    }


}
