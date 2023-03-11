package com.example.Demoproject.controller;


import com.example.Demoproject.model.Coin;
import com.example.Demoproject.repo.CoinRepo;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class CoinController {

    @Autowired
    private CoinRepo coinRepo;

    //5.測試呼叫 coindesk API,並顯示其內容。
    public CoinController()
    {
        final String uri = "https://api.coindesk.com/v1/bpi/currentprice.json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
        System.out.println(result);
    }
    //6.測試呼叫資料轉換的 API,並顯示其內容。
    @PostMapping("/addCoindesk")
    public ResponseEntity<List<Coin>> addCoindesk(){

        final String uri = "https://api.coindesk.com/v1/bpi/currentprice.json";
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri, String.class);
//        System.out.println(result);
        Coin coin1 = new Coin();
        Coin coin2 = new Coin();
        Coin coin3 = new Coin();
        try
        {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode node = objectMapper.readValue(result, JsonNode.class);

            JsonNode updatedISONode = node.get("time").get("updatedISO");
            String time1 = updatedISONode.asText();
//            System.out.println(time1);
            String time2 = time1.substring(0,time1.length()-6);
//            System.out.println(time2);
            //Coin time
            SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date time3 = parser.parse(time2);
//            System.out.println(time3);
//            System.out.println(format.format(time3));
            String time = format.format(time3);
//            System.out.println(time);

            //Coin disclaimer
            JsonNode disclaimerNode = node.get("disclaimer");
            String disclaimer = disclaimerNode.asText();
//            System.out.println(disclaimer);
            //Coin chartName
            JsonNode chartNameNode = node.get("chartName");
            String chartName = chartNameNode.asText();
//            System.out.println(chartName);
            //Coin 1 code
            JsonNode bpi1Node = node.get("bpi").get("USD").get("code");
            String bpi1 = bpi1Node.asText();
//            System.out.println(bpi1);
            //Coin 1 code
            JsonNode bpi1codeNode = node.get("bpi").get("USD").get("code");
            String bpi1code = bpi1codeNode.asText();
//            System.out.println(bpi1code);
            //Coin 1 symbol
            JsonNode bpi1symbolNode = node.get("bpi").get("USD").get("symbol");
            String bpi1symbol = bpi1symbolNode.asText();
//            System.out.println(bpi1symbol);
            //Coin 1 rate
            JsonNode bpi1rateNode = node.get("bpi").get("USD").get("rate");
            String bpi1rate = bpi1rateNode.asText();
//            System.out.println(bpi1rate);
            //Coin 1 description
            JsonNode bpi1descriptionNode = node.get("bpi").get("USD").get("description");
            String bpi1description = bpi1descriptionNode.asText();
//            System.out.println(bpi1description);
            //Coin 1 rate_float
            JsonNode bpi1rate_floatNode = node.get("bpi").get("USD").get("rate_float");
            String bpi1rate_float = bpi1rate_floatNode.asText();
            double bpi1rate_float_double = Double.parseDouble(bpi1rate_float);
//            System.out.println(bpi1rate_float_double);

            //Coin 2 code
            JsonNode bpi2Node = node.get("bpi").get("GBP").get("code");
            String bpi2 = bpi2Node.asText();
//            System.out.println(bpi2);
            //Coin 2 code
            JsonNode bpi2codeNode = node.get("bpi").get("GBP").get("code");
            String bpi2code = bpi2codeNode.asText();
//            System.out.println(bpi2code);
            //Coin 2 symbol
            JsonNode bpi2symbolNode = node.get("bpi").get("GBP").get("symbol");
            String bpi2symbol = bpi2symbolNode.asText();
//            System.out.println(bpi2symbol);
            //Coin 2 rate
            JsonNode bpi2rateNode = node.get("bpi").get("GBP").get("rate");
            String bpi2rate = bpi2rateNode.asText();
//            System.out.println(bpi2rate);
            //Coin 2 description
            JsonNode bpi2descriptionNode = node.get("bpi").get("GBP").get("description");
            String bpi2description = bpi2descriptionNode.asText();
//            System.out.println(bpi2description);
            //Coin 2 rate_float
            JsonNode bpi2rate_floatNode = node.get("bpi").get("GBP").get("rate_float");
            String bpi2rate_float = bpi2rate_floatNode.asText();
            double bpi2rate_float_double = Double.parseDouble(bpi1rate_float);
//            System.out.println(bpi2rate_float_double);

            //Coin 3 code
            JsonNode bpi3Node = node.get("bpi").get("EUR").get("code");
            String bpi3 = bpi3Node.asText();
//            System.out.println(bpi3);
            //Coin 3 code
            JsonNode bpi3codeNode = node.get("bpi").get("EUR").get("code");
            String bpi3code = bpi3codeNode.asText();
//            System.out.println(bpi3code);
            //Coin 3 symbol
            JsonNode bpi3symbolNode = node.get("bpi").get("EUR").get("symbol");
            String bpi3symbol = bpi3symbolNode.asText();
//            System.out.println(bpi3symbol);
            //Coin 3 rate
            JsonNode bpi3rateNode = node.get("bpi").get("EUR").get("rate");
            String bpi3rate = bpi3rateNode.asText();
//            System.out.println(bpi3rate);
            //Coin 3 description
            JsonNode bpi3descriptionNode = node.get("bpi").get("EUR").get("description");
            String bpi3description = bpi3descriptionNode.asText();
//            System.out.println(bpi3description);
            //Coin 3 rate_float
            JsonNode bpi3rate_floatNode = node.get("bpi").get("EUR").get("rate_float");
            String bpi3rate_float = bpi3rate_floatNode.asText();
            double bpi3rate_float_double = Double.parseDouble(bpi3rate_float);
//            System.out.println(bpi3rate_float_double);

            coin1.setTime(time);
            coin1.setDisclaimer(disclaimer);
            coin1.setChartname(chartName);
            coin1.setCoinchinesename("美元");
            coin1.setBpi(bpi1);
            coin1.setCode(bpi1code);
            coin1.setSymbol(bpi1symbol);
            coin1.setRate(bpi1rate);
            coin1.setDescription(bpi1description);
            coin1.setRatefloat(bpi1rate_float_double);
            coinRepo.save(coin1);

            coin2.setTime(time);
            coin2.setDisclaimer(disclaimer);
            coin2.setChartname(chartName);
            coin2.setCoinchinesename("英鎊");
            coin2.setBpi(bpi2);
            coin2.setCode(bpi2code);
            coin2.setSymbol(bpi2symbol);
            coin2.setRate(bpi2rate);
            coin2.setDescription(bpi2description);
            coin2.setRatefloat(bpi2rate_float_double);
            coinRepo.save(coin2);

            coin3.setTime(time);
            coin3.setDisclaimer(disclaimer);
            coin3.setChartname(chartName);
            coin3.setCoinchinesename("歐元");
            coin3.setBpi(bpi3);
            coin3.setCode(bpi3code);
            coin3.setSymbol(bpi3symbol);
            coin3.setRate(bpi3rate);
            coin3.setDescription(bpi3description);
            coin3.setRatefloat(bpi3rate_float_double);
            coinRepo.save(coin3);

            List<Coin> coinList = new ArrayList<>();
            coinRepo.findAll().forEach(coinList::add);

            return new ResponseEntity<>(coinList, HttpStatus.OK);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ParseException e)
        {
            throw new RuntimeException(e);
        }
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //1.測試呼叫查詢幣別對應表資料 API,並顯示其內容。
    //所有資料
    @GetMapping("/getAllCoins")
    public ResponseEntity<List<Coin>> getAllCoins(){
        try
        {
            List<Coin> coinList = new ArrayList<>();
            coinRepo.findAll().forEach(coinList::add);

            if(coinList.isEmpty()){
                return new ResponseEntity<>(coinList, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(coinList, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //1. 測試呼叫查詢幣別對應表資料 API,並顯示其內容。
    //單一資料
    @GetMapping("/getCoinById/{id}")
    public ResponseEntity<Coin> getCoinById(@PathVariable Long id){
        try
        {
            Optional<Coin> CoinData = coinRepo.findById(id);

            if(CoinData.isPresent()){
                return new ResponseEntity<>(CoinData.get(), HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //2.測試呼叫新增幣別對應表資料 API。
    @PostMapping("/addCoin")
    public ResponseEntity<Coin> addCoin(@RequestBody Coin coin){
        try
        {
            Coin coinObj = coinRepo.save(coin);
            return new ResponseEntity<>(coinObj, HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //3.測試呼叫更新幣別對應表資料 API,並顯示其內容。
    @PostMapping("/updateCoinById/{id}")
    public ResponseEntity<Coin> updateCoinById(@PathVariable Long id, @RequestBody Coin newCoinData){
        try
        {
            Optional<Coin> oldCoinData = coinRepo.findById(id);
            if(oldCoinData.isPresent()){
                Coin updatedCoinData = oldCoinData.get();
                updatedCoinData.setTime(newCoinData.getTime());
                updatedCoinData.setDisclaimer(newCoinData.getDisclaimer());
                updatedCoinData.setChartname(newCoinData.getChartname());
                updatedCoinData.setCoinchinesename(newCoinData.getCoinchinesename());
                updatedCoinData.setBpi(newCoinData.getBpi());
                updatedCoinData.setCode(newCoinData.getCode());
                updatedCoinData.setSymbol(newCoinData.getSymbol());
                updatedCoinData.setRate(newCoinData.getRate());
                updatedCoinData.setDescription(newCoinData.getDescription());
                updatedCoinData.setRatefloat(newCoinData.getRatefloat());

                Coin coinObj = coinRepo.save(updatedCoinData);
                return new ResponseEntity<>(coinObj, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    //4.測試呼叫刪除幣別對應表資料 API。
    @DeleteMapping("/deleteCoinById/{id}")
    public ResponseEntity<HttpStatus> deleteCoinById(@PathVariable Long id){
        try
        {
            coinRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
