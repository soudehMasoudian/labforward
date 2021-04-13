package com.labforward.repository;

import com.labforward.model.AttributeValuePair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeValuePairRepository extends JpaRepository<AttributeValuePair, Long> {
}
