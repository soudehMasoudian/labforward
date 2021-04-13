package com.labforward.service;

import com.labforward.mapper.AttributeMapper;
import com.labforward.mapper.CategoryMapper;
import com.labforward.model.Attribute;
import com.labforward.model.Category;
import com.labforward.repository.AttributeRepository;
import com.labforward.repository.CategoryRepository;
import com.labforward.service.impl.CategoryServiceImpl;
import com.labforward.to.AttributeTo;
import com.labforward.to.CategoryTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryServiceIntegrationTest {

    @Autowired
    CategoryServiceImpl categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    AttributeMapper attributeMapper;

    private CategoryTo initCategoryToForTest() {
        CategoryTo categoryRequet = new CategoryTo("test", "1.0");
        categoryRequet.setId(1L);

        AttributeTo attribute = new AttributeTo();
//        attribute.setId(1L);
        attribute.setName("testAttribute");
        attribute.setType(Attribute.AttributeType.String);
        List<AttributeTo> attributes = new ArrayList<>();
        attributes.add(attribute);
        categoryRequet.setAttributes(attributes);
        return categoryRequet;
    }

    private Category initCategoryForTest() {
        Category categoryRequet = new Category();
        categoryRequet.setCategoryVersion("1.0");
        categoryRequet.setTitle("category-test");
        Attribute attribute = new Attribute();
//        attribute.setId(1L);
        attribute.setName("testAttribute");
        attribute.setType(Attribute.AttributeType.String);
        List<Attribute> attributes = new ArrayList<>();
        attributes.add(attribute);
        categoryRequet.setAttributes(attributes);
        return categoryRequet;
    }

    @Test
    public void saveCategoryTest() {
        CategoryTo categoryRequet = initCategoryToForTest();
        Attribute attribute = new Attribute();
        attribute.setCategoryId(categoryRequet.getId());
        attribute.setName("attr-name");
        CategoryTo resultCategory = categoryService.saveCategory(categoryRequet);
        assertNotNull(resultCategory.getId());
        assertEquals(resultCategory.getTitle(), categoryRequet.getTitle());
    }

    @Test
    public void getCategoryTest() {
        // save an item before getting
        CategoryTo categoryRequet = initCategoryToForTest();
        Attribute attribute = new Attribute();
        attribute.setCategoryId(categoryRequet.getId());
        attribute.setName("attr-name");
        CategoryTo savedCategory = categoryService.saveCategory(categoryRequet);

        // get category by id
        CategoryTo getCategory = categoryService.getCategory(savedCategory.getId());
        assertEquals(getCategory.getTitle(), savedCategory.getTitle());
    }
}
