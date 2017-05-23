package com.shop.bean;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response
    implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("results")
    private Results[] results;

    @JsonProperty("customerDetails")
    private CustomerDetails customerDetails;

    public Results[] getResults() {

        return results;
    }

    public void setResults(Results[] results) {

        this.results = results;
    }


    public CustomerDetails getCustomerDetails() {

        return customerDetails;
    }


    public void setCustomerDetails(CustomerDetails customerDetails) {

        this.customerDetails = customerDetails;
    }

}
