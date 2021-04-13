package com.labforward.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ATTRIBUTE_VALUE")
@Data
public class AttributeValuePair extends BaseModel {
    @Column
    private Long itemId;

    @Column
    private Long attributeId;

    @Column
    private String value;

    public AttributeValuePair(Long id, Long itemId, Long attributeId, String value) {
        this.id = id;
        this.itemId = itemId;
        this.attributeId = attributeId;
        this.value = value;
    }


    public Long getAttributeId() {
        return attributeId;
    }

    public Long getItemId() {
        return itemId;
    }

    public String getValue() {
        return value;
    }
}
