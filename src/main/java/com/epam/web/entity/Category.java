package com.epam.web.entity;

public class Category extends Entity {

    public static final String TABLE = "category";

    public static final String ID = "id";
    public static final String NAME = "name";

    private Long id;
    private String name;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
