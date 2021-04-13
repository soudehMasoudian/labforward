package com.labforward.model;

import javax.persistence.*;

import lombok.Data;

import java.util.List;

@Entity
@Table(name = "CATEGORY")
@Data
public class Category extends BaseModel {

    @Column(name = "TITLE", length = 60)
    private String title;

    @Column(name = "CATEGORY_VERSION", length = 10)
    private String categoryVersion;

    @Transient
    private List<Attribute> attributes;
}
