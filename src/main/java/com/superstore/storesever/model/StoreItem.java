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
    @OneToOne(targetEntity = Attributes.class, cascade = CascadeType.ALL)
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

}
