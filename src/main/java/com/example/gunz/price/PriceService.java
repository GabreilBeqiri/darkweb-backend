package com.example.gunz.price;


import com.example.gunz.accessories.Accessories;
import com.example.gunz.armet.Armet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public ResponseEntity<Price> savePrice(String pr) {
        Price price = new Price(Integer.parseInt(pr));
        price = this.priceRepository.save(price);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getPrice(){
       Integer cc = priceRepository.findsumm();
        return new ResponseEntity<Integer>( cc, HttpStatus.OK);
    }

    public ResponseEntity<Integer> getTodayPrice(){
        Integer cc = priceRepository.findstodaysumm();
        return new ResponseEntity<Integer>( cc, HttpStatus.OK);
    }
}



