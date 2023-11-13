package com.example.gunz.price;

import com.example.gunz.accessories.Accessories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/v1/price")
public class PriceController {

    @Autowired
    private PriceService priceSerive;
    @RequestMapping("/add/{pr}")
    public ResponseEntity<Price> savePrice(@PathVariable String pr){

        System.out.println("-adsdfasa  gabirlei : "+ pr);
        return priceSerive.savePrice(pr);
    }
    @GetMapping("/get")
    public ResponseEntity<Integer> getAllSales() {
        return priceSerive.getPrice();
    }

    @GetMapping("/get/today")
    public ResponseEntity<Integer> getTodaySales() {
        return priceSerive.getTodayPrice();
    }
}
