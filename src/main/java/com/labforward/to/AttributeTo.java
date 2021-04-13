package com.labforward.to;

import com.labforward.model.Attribute;
import com.labforward.model.Category;

public class AttributeTo {
    private Long id;
    private String name;
    private Attribute.AttributeType type;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Attribute.AttributeType getType() {
        return type;
    }

     public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Attribute.AttributeType type) {
        this.type = type;
    }

}
