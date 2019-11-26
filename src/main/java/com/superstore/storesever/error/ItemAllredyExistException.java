package com.superstore.storesever.error;


public class ItemAllredyExistException extends Exception {
    public ItemAllredyExistException(String ean) {
        super(String.format("Item with id %s has allredy exists", ean));
    }
}
