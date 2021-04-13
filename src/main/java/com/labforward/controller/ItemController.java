package com.labforward.controller;

import com.labforward.service.ItemService;
import com.labforward.to.ItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ItemTo get(@PathVariable("id") Long id) {
        return itemService.get(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ItemTo create(@RequestBody ItemTo itemTo) {
        return itemService.save(itemTo);
    }
}