package com.labforward.mapper;

import com.labforward.model.Attribute;
import com.labforward.model.AttributeValuePair;
import com.labforward.model.Category;
import com.labforward.model.Item;
import com.labforward.to.AttributeTo;
import com.labforward.to.CategoryTo;
import com.labforward.to.ItemTo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
    private Long id;
    private String title;
    private String version;

    @Autowired
    private AttributeMapper attributeMapper;

    public Category mapToDomain(CategoryTo categoryTo) {
        Category category = new Category();
        category.setId(categoryTo.getId());
        category.setTitle(categoryTo.getTitle());
        category.setCategoryVersion(categoryTo.getCategoryVersion());

        List<Attribute> attributes = new ArrayList<>();
        for (AttributeTo attributeTo:categoryTo.getAttributes()) {
            attributes.add(attributeMapper.mapToDomain(attributeTo));
        }
        category.setAttributes(attributes);
        return category;
    }

    public CategoryTo mapToDto(Category category) {
        CategoryTo categoryTo = new CategoryTo(category.getTitle(), category.getCategoryVersion());
        categoryTo.setId(category.getId());
        List<AttributeTo> attributeTos = new ArrayList<>();
//        for (Attribute attribute:category.getAttributes()) {
//            attributeTos.add(attributeMapper.mapToDto(attribute));
//        }
        categoryTo.setAttributes(attributeTos);
        return categoryTo;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getVersion() {
        return version;
    }
}
