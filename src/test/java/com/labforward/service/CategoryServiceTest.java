package com.labforward.service;

import com.labforward.mapper.AttributeMapper;
import com.labforward.mapper.CategoryMapper;
import com.labforward.model.Attribute;
import com.labforward.repository.AttributeRepository;
import com.labforward.service.impl.CategoryServiceImpl;
import com.labforward.to.AttributeTo;
import com.labforward.to.CategoryTo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
//@SpringBootTest
public class CategoryServiceTest {

    @Mock
    CategoryServiceImpl categoryService;

    @Mock
    CategoryMapper categoryMapper;

    @Mock
    AttributeRepository attributeRepository;

    @Mock
    AttributeMapper attributeMapper;

    private CategoryTo initCategoryForTest() {
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

    @Test
    public void saveCategoryTest() throws Exception {
        CategoryTo categoryRequet = initCategoryForTest();
        assertNotNull(categoryService.saveCategory(categoryRequet));
        categoryService.saveCategory(categoryRequet);
    }

    @Test
    public void getCategoryTest() {
        Long categoryId = 1L;
        when(categoryService.getCategory(categoryId)).thenReturn(initCategoryForTest());
        assertNotNull(categoryService.getCategory(categoryId));
        categoryService.getCategory(categoryId);
    }

}
