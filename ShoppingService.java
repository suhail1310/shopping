package com.shop.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shop.bean.Response;
import com.shop.bean.ShopArray;
import com.shop.bean.ShopDetails;

public class ShoppingService {

    String Api_key;
    ObjectMapper objectMapper;
    public List<Response> getResponse(String requestSD) throws JsonParseException, JsonMappingException, IOException{

        objectMapper = new ObjectMapper();

        ShopArray shopArray = objectMapper.readValue(
            requestSD.getBytes(Charset.forName("UTF-8")), ShopArray.class);

        Api_key = "AIzaSyAp4g7MmJDUMMiob1_Gec7XjLFE86fuajQ";
        List<Response> response = addresstoString(shopArray.getShopDetails());



        return response;
    }

    private List<Response> addresstoString(ShopDetails[] shopDetailsAry) throws IOException,
    JsonParseException,
    JsonMappingException,
    MalformedURLException,
    ProtocolException {

        List<Response> resLatLongList= new ArrayList<Response>();
        for (ShopDetails shopDetails : shopDetailsAry) {
            StringBuffer sb = new StringBuffer();

            if (shopDetails.getShopNumber() != null) {
                sb.append(shopDetails.getShopNumber());
            }
            if (shopDetails.getShopAddress() != null) {
                if (shopDetails.getShopAddress().getNumber() != null)

                {
                    sb.append(shopDetails.getShopAddress().getNumber());

                }
                if (shopDetails.getShopAddress().getPostalCode() != 0) {

                    sb.append(shopDetails.getShopAddress().getPostalCode());
                }
            }

            String addressRaw = sb.toString();
            String addressFormated = addressRaw.replaceAll("\\s", "%20");

            URL url =
                new URL("https://maps.googleapis.com/maps/api/geocode/json?address="
                    + addressFormated + "&key=" + Api_key);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException(
                    "Failed : HTTP error code : " + conn.getResponseCode());
            }
            System.out.println("url \n" + url);
            BufferedReader br =
                new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder apiOutput = new StringBuilder();
            String readLine;
            while ((readLine = br.readLine()) != null) {
                System.out.println(readLine);
                apiOutput.append(readLine.trim());
            }
            String jsonInString = apiOutput.toString();
            System.out.println("Output response " + jsonInString);
            conn.disconnect();

            Response results = objectMapper.readValue(
                jsonInString.getBytes(Charset.forName("UTF-8")), Response.class);

            System.out.println("address...." + results.getResults());
            resLatLongList.add(results);

        }


        return resLatLongList;
    }

}
