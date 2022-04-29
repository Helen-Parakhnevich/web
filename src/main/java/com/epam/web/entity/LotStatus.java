package com.epam.web.entity;

import java.util.HashMap;
import java.util.Map;

public enum LotStatus {
    NEW ("new"),
    CURRENT ("current"),
    SOLD ("sold"),
    BLOCKED ("blocked");

    private final String title;

    LotStatus(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    private static final Map<String, LotStatus> LOOKUP_MAP = new HashMap<>();

    static {
        for (LotStatus status : values()) {
            LOOKUP_MAP.put(status.getTitle(), status);
        }
    }

    public static LotStatus geStatusByTitle(String title) {
        return LOOKUP_MAP.get(title);
    }

}
