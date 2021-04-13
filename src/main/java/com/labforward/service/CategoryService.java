package com.labforward.service;

import com.labforward.to.CategoryTo;

public interface CategoryService {
    CategoryTo saveCategory(CategoryTo category);
    CategoryTo getCategory(Long id);
}
