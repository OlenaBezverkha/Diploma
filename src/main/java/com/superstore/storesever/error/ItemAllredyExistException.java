package com.superstore.storesever.error;


public class ItemAllredyExistException extends Throwable {
    public ItemAllredyExistException(String ean) {
        super(String.format("Item with id %s has allredy exists", ean));
    }
}
