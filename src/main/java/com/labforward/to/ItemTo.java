package com.labforward.to;

import java.util.List;

public class ItemTo {
    private Long id;
    private CategoryTo category;
    private List<AttributeValuePairTo> attributeValuePairs;

    public ItemTo(Long id, CategoryTo category, List<AttributeValuePairTo> attributeValuePairs) {
        this.id = id;
        this.category = category;
        this.attributeValuePairs = attributeValuePairs;
    }

    public Long getId() {
        return id;
    }

    public CategoryTo getCategory() {
        return category;
    }

    public List<AttributeValuePairTo> getAttributeValuePairs() {
        return attributeValuePairs;
    }
}
