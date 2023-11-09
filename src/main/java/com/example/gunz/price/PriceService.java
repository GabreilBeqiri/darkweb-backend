package com.example.gunz.price;


import com.example.gunz.armet.Armet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;

    public ResponseEntity<Price> savePrice(RegisterPriceDto registerPriceDto) {
        Price price = new Price();
        price = this.priceRepository.save(price);
        return new ResponseEntity<>(price, HttpStatus.OK);
    }
}



