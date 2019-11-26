package com.superstore.storesever.error;

public class QuantityLessThenZero extends Exception {
    public QuantityLessThenZero(String ean, int quantity) {
        super(String.format("Item with id %s can not be reduced with %d quantity", ean, quantity));
    }
}
