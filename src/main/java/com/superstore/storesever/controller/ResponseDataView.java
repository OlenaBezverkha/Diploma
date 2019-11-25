package com.superstore.storesever.controller;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseDataView<T> {
    @JsonProperty("data")
    private T data;

    public ResponseDataView(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
