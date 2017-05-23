package com.shop.rest;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.bean.Response;
import com.shop.bean.ShopArray;
import com.shop.service.ShoppingService;

@RestController
public class ShopController {

    @RequestMapping(value = "/shopping", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody List<Response> address(@RequestBody String requestSD)
        throws IOException {

        ShoppingService shoppingService = new ShoppingService();
        List<Response> jsonInString = shoppingService.getResponse(requestSD);
        return jsonInString;
    }

    @RequestMapping(value = "/customerShopping", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public @ResponseBody String customerAddress(@RequestBody String customerData)
        throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        Response resp = objectMapper.readValue(
            customerData.getBytes(Charset.forName("UTF-8")), Response.class);

        System.out.println("CusResp.."+resp.getCustomerDetails().getLatitude());
        return null;
    }
}
