package com.labforward.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "CATEGORY_ATTRIBUTE")
@Data
public class Attribute extends BaseModel {

    @Column(name = "NAME", length = 60)
    private String name;

    @Column
    private Long categoryId;

    public enum AttributeType {
        String, Numerical
    }

    @Column(name = "TYPE")
    private AttributeType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public AttributeType getType() {
        return type;
    }

    public void setType(AttributeType type) {
        this.type = type;
    }
}