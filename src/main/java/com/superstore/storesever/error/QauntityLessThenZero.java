package com.superstore.storesever.error;

public class QauntityLessThenZero extends Throwable {
    public QauntityLessThenZero(String ean, int qauntity) {
        super(String.format("Item with id %s can be reduced with %d quantity", ean, qauntity));
    }
}
