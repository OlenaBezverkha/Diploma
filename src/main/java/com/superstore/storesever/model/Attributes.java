package com.superstore.storesever.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="attributes")
public class Attributes {
    @JsonProperty(value = "ean")
    @Id
    @Column(name = "ean")
    private String ean;
    @JsonProperty(value = "quantity")
    @Column(name = "qauntity")
    private int qauntity;
    @JsonProperty(value = "reason_code")
    @Column(name = "reasonCode")
    private String reasonCode;

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public int getQauntity() {
        return qauntity;
    }

    public void setQauntity(int qauntity) {
        this.qauntity = qauntity;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }
}
