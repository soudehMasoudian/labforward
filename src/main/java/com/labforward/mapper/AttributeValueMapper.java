package com.labforward.mapper;

import com.labforward.model.AttributeValuePair;
import com.labforward.to.AttributeTo;
import com.labforward.to.AttributeValuePairTo;
import org.springframework.stereotype.Component;

@Component
public class AttributeValueMapper {
    public AttributeValuePairTo mapToDto(AttributeValuePair attributeValuePair) {
        return new AttributeValuePairTo(attributeValuePair.getId(), null
        , new AttributeTo() //,attributeValuePair.getAttributeId()
        , attributeValuePair.getValue());
    }

    public AttributeValuePair mapToDomain(AttributeValuePairTo attributeValuePairTo) {
        return new AttributeValuePair(attributeValuePairTo.getId()
                , null
                , attributeValuePairTo.getAttribute().getId()
                , attributeValuePairTo.getValue()
        );
    }

}
