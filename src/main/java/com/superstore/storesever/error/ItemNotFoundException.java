package com.superstore.storesever.error;

public class ItemNotFoundException extends Exception{
    public ItemNotFoundException(String ean) {
        super(String.format("Item with id %s has not  been fount", ean));
    }
}
