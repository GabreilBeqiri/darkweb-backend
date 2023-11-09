package com.example.gunz.price;

public class RegisterPriceDto {
    public Integer sales ;

    public RegisterPriceDto(Integer sales) {
        this.sales = sales;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
