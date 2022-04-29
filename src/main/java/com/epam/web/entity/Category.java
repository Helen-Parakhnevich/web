package com.epam.web.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Category extends Entity {

    public static final String TABLE = "category";

    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String EN = "en";
    public static final String BE = "be";
    public static final String RU = "ru";

    private Long id;
    private String name;
    private String en;
    private String be;
    private String ru;

    public Category(Long id, String name, String en, String be, String ru) {
        this.id = id;
        this.name = name;
        this.en = en;
        this.be = be;
        this.ru = ru;
    }
}
