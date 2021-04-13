package com.labforward.service.impl;

import com.labforward.mapper.AttributeValueMapper;
import com.labforward.mapper.ItemMapper;
import com.labforward.model.AttributeValuePair;
import com.labforward.model.Item;
import com.labforward.repository.AttributeValuePairRepository;
import com.labforward.repository.ItemRepository;
import com.labforward.service.ItemService;
import com.labforward.to.AttributeValuePairTo;
import com.labforward.to.ItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private AttributeValueMapper attributeValueMapper;

    @Autowired
    private AttributeValuePairRepository attributeValuePairRepository;

    @Override
    public ItemTo get(Long id) {
        return itemMapper.mapToDto(itemRepository.getOne(id));
    }

    @Override
    @Transactional
    public ItemTo save(ItemTo itemTo) {
        Item item = itemMapper.mapToDomain(itemTo);
        item = itemRepository.save(item);
        List<AttributeValuePair> createdAvps = new ArrayList<>();

        for (AttributeValuePairTo avpTo:itemTo.getAttributeValuePairs()) {
            AttributeValuePair avp = attributeValueMapper.mapToDomain(avpTo);
            avp.setItemId(item.getId());
            createdAvps.add(attributeValuePairRepository.save(avp));
        }
        item.setAttributeValuePairs(createdAvps);
        return itemMapper.mapToDto(item);
    }
}
