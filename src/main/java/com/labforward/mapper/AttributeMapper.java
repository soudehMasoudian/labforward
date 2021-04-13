package com.labforward.mapper;

import com.labforward.model.Attribute;
import com.labforward.to.AttributeTo;
import org.springframework.stereotype.Component;

@Component
public class AttributeMapper {

    public Attribute mapToDomain(AttributeTo attributeTo) {
        Attribute attribute = new Attribute();
        attribute.setName(attributeTo.getName());
        attribute.setType(attributeTo.getType());
        return attribute;
    }

    public AttributeTo mapToDto(Attribute attribute) {
        AttributeTo attributeTo = new AttributeTo();
        attributeTo.setName(attribute.getName());
        attributeTo.setType(attribute.getType());
        attributeTo.setId(attribute.getId());
        return attributeTo;
    }
}
