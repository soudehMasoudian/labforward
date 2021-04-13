package com.labforward.controller;

import com.labforward.model.Category;
import com.labforward.service.CategoryService;
import com.labforward.to.CategoryTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @RequestMapping(method = RequestMethod.POST)
    public CategoryTo saveCategory(@RequestBody CategoryTo category) {
        return categoryService.saveCategory(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public CategoryTo getCategory(@PathVariable Long id) {
        return categoryService.getCategory(id);
    }
}
