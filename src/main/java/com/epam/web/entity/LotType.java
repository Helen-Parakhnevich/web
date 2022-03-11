package com.epam.web.entity;

import java.util.HashMap;
import java.util.Map;

public enum LotType {
    DIRECT("direct"),
    REVERSE ("reverse");

    private final String title;

    LotType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, LotType> LOOKUP_MAP = new HashMap<>();

    static {
        for (LotType type : values()) {
            LOOKUP_MAP.put(type.getTitle(), type);
        }
    }

    public static LotType geTypeByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }

}
