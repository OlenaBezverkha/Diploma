package com.superstore.storesever.model;

import com.fasterxml.jackson.annotation.JsonValue;

public class PatchOperation {

    private String ean;
    private Action action;
    private int quantity;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


    public enum Action {

        DECREMENT("decrement-quantity"), INCEMENT("increment-quantity");

        private String action;

        Action(String action) {
            this.action = action;
        }

        @JsonValue
        public String getAction() {
            return action;
        }

    }
}
