package com.example.gunz.price;

import com.example.gunz.accessories.Accessories;
import com.example.gunz.accessories.AccessoriesService;
import com.example.gunz.accessories.RegisterAccessoriesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/price")
public class PriceController {

    @Autowired
    private PriceService priceSerive;
    @RequestMapping("/api/v1/price")
    public ResponseEntity<Price> savePrice(@RequestBody RegisterPriceDto registerPriceDto){
        return priceSerive.savePrice(registerPriceDto);
    }

}
