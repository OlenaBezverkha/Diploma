package com.superstore.storesever.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name ="items")
public class StoreItem {
    @JsonProperty(value = "id")
    @Id
    @Column(name = "id")
    private String id;
    @JsonProperty(value = "type")
    @Column(name = "type")
    private String type;
    @JsonProperty(value = "attributes")
    @OneToOne(targetEntity = Attributes.class)
    @JoinColumn(name = "attributes")
    private Attributes attributes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

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
}
