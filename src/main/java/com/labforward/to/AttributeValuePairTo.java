package com.labforward.to;

import com.labforward.model.Attribute;
import com.labforward.model.Item;

public class AttributeValuePairTo {
    private Long id;
    private ItemTo item;
    private AttributeTo attribute;
    private String value;

    public AttributeValuePairTo(Long id, ItemTo item, AttributeTo attribute, String value) {
        this.id = id;
        this.item = item;
        this.attribute = attribute;
        this.value = value;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setItem(ItemTo item) {
        this.item = item;
    }

    public void setAttribute(AttributeTo attribute) {
        this.attribute = attribute;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public ItemTo getItem() {
        return item;
    }

    public AttributeTo getAttribute() {
        return attribute;
    }

    public String getValue() {
        return value;
    }

    public Long getId() {
        return id;
    }
}
