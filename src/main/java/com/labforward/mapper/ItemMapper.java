package com.labforward.mapper;

import com.labforward.model.AttributeValuePair;
import com.labforward.model.Item;
import com.labforward.service.CategoryService;
import com.labforward.to.AttributeValuePairTo;
import com.labforward.to.ItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ItemMapper {
    @Autowired
    AttributeValueMapper attributeValueMapper;

    @Autowired
    CategoryService categoryService;

    public Item mapToDomain(ItemTo itemTo) {
        List<AttributeValuePair> avps = new ArrayList<>();
        for (AttributeValuePairTo avp:itemTo.getAttributeValuePairs()) {
            avps.add(new AttributeValuePair(avp.getId(), null
                    , avp.getAttribute().getId()
                    , avp.getValue())
            );

        }
        Item item = new Item();
        item.setCategoryId(itemTo.getCategory().getId());
        //item.setCategory(categoryMapper.itemTo.getCategory());
        return item;
    }

    public ItemTo mapToDto(Item item) {

        List<AttributeValuePairTo> avpTos = new ArrayList<>();
        for (AttributeValuePair avp:item.getAttributeValuePairs()) {
            avpTos.add(attributeValueMapper.mapToDto(avp));
        }
        ItemTo itemTo = new ItemTo(item.getId(), categoryService.getCategory(item.getCategoryId()),  avpTos);
        return itemTo;
    }
}
