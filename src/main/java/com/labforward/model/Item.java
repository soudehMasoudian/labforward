package com.labforward.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

@Entity
@Table(name = "ITEM")
@Data
public class Item extends BaseModel {
    @Column
    private Long categoryId;

    @Transient
    private List<AttributeValuePair> attributeValuePairs;

    @Transient
    private Category category;

    public Long getCategoryId() {
        return categoryId;
    }

    public List<AttributeValuePair> getAttributeValuePairs() {
        return attributeValuePairs;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setAttributeValuePairs(List<AttributeValuePair> attributeValuePairs) {
        this.attributeValuePairs = attributeValuePairs;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
