package com.labforward.service.impl;

import com.labforward.mapper.AttributeMapper;
import com.labforward.mapper.CategoryMapper;
import com.labforward.model.Attribute;
import com.labforward.model.Category;
import com.labforward.repository.AttributeRepository;
import com.labforward.repository.CategoryRepository;
import com.labforward.service.CategoryService;
import com.labforward.to.AttributeTo;
import com.labforward.to.CategoryTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private AttributeRepository attributeRepository;

    @Autowired
    private AttributeMapper attributeMapper;

    public CategoryTo saveCategory(CategoryTo categoryTo) {
        Category category = categoryMapper.mapToDomain(categoryTo);
        category = categoryRepository.save(category);
        List<Attribute> attributes = new ArrayList<>();
        for (AttributeTo attributeTo:categoryTo.getAttributes()) {
            Attribute attribute = attributeMapper.mapToDomain(attributeTo);
            attribute.setCategoryId(category.getId());
            attribute = attributeRepository.save(attribute);
            attributes.add(attribute);
        }
        category.setAttributes(attributes);
        return categoryMapper.mapToDto(category);
    }

    public CategoryTo getCategory(Long id) {
        return categoryMapper.mapToDto(categoryRepository.findById(id).get());
    }
}
