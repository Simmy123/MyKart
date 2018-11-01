package com.example.rsrimone.mycart;

public class Product {
    String itemBrandName;
    String itemType;
    Boolean isImported;
    Double price;
    Integer itemCount;

    public Product(String itemBrandName, String itemType, Boolean isImported, Double price, Integer itemCount) {
        this.itemBrandName = itemBrandName;
        this.itemType = itemType;
        this.isImported = isImported;
        this.price = price;
        this.itemCount = itemCount;
    }
}
