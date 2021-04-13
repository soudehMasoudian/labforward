package com.labforward.to;

import java.util.List;

public class CategoryTo {
    private Long id;
    private String title;
    private String categoryVersion;
    private List<AttributeTo> attributes;

    public CategoryTo(String title, String categoryVersion) {
        this.title = title;
        this.categoryVersion = categoryVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getCategoryVersion() {
        return categoryVersion;
    }

    public Long getId() {
        return id;
    }

    public List<AttributeTo> getAttributes() {
        return attributes;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategoryVersion(String categoryVersion) {
        this.categoryVersion = categoryVersion;
    }

    public void setAttributes(List<AttributeTo> attributes) {
        this.attributes = attributes;
    }
}
