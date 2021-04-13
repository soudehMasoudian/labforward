package com.labforward.service;

import com.labforward.mapper.AttributeValueMapper;
import com.labforward.mapper.ItemMapper;
import com.labforward.model.Attribute;
import com.labforward.model.Item;
import com.labforward.repository.AttributeValuePairRepository;
import com.labforward.service.impl.ItemServiceImpl;
import com.labforward.to.AttributeTo;
import com.labforward.to.AttributeValuePairTo;
import com.labforward.to.CategoryTo;
import com.labforward.to.ItemTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemServiceIntegrationTest {
    @Autowired
    ItemServiceImpl itemService;

    @MockBean
    ItemMapper itemMapper;

    @MockBean
    AttributeValueMapper attributeValueMapper;

    @MockBean
    AttributeValuePairRepository attributeValuePairRepository;

    private ItemTo initItemToForTest() {
        CategoryTo category = new CategoryTo("test-item", "1.0");
        category.setId(1L);
        AttributeTo attributeTo = new AttributeTo();
        attributeTo.setId(1L);
        attributeTo.setName("test-attr-item");
        attributeTo.setType(Attribute.AttributeType.String);
        AttributeValuePairTo attributeValuePairTo = new AttributeValuePairTo(1L, null, attributeTo, "value");
        List<AttributeValuePairTo> attributes = new ArrayList<>();
        attributes.add(attributeValuePairTo);
        ItemTo itemRequest = new ItemTo(1L, category, attributes);
        return itemRequest;
    }

    private Item initItemForTest() {
        Item item = new Item();
        item.setId(1L);
        AttributeTo attributeTo = new AttributeTo();
        attributeTo.setId(1L);
        attributeTo.setName("test-attr-item");
        attributeTo.setType(Attribute.AttributeType.String);
        AttributeValuePairTo attributeValuePairTo = new AttributeValuePairTo(1L, initItemToForTest(), attributeTo, "value");
        List<AttributeValuePairTo> attributes = new ArrayList<>();
        attributes.add(attributeValuePairTo);
        return item;
    }

    @Test
    public void saveItemIntegrationTest() {

    }
}
