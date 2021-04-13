package com.labforward.service;

import com.labforward.model.Item;
import com.labforward.to.ItemTo;
import org.springframework.stereotype.Service;


public interface ItemService {
    ItemTo get(Long id);
    ItemTo save(ItemTo item);
}
