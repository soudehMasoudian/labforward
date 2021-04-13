package com.labforward.repository;

import com.labforward.model.Category;
import com.labforward.to.CategoryTo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
