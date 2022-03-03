package com.epam.web.entity;

import java.io.Serializable;

public abstract class Entity implements Serializable, Identifiable {

    private long id;

    public Entity() {
    }

    public Entity(long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
