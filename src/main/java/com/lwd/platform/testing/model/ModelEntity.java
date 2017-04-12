package com.lwd.platform.testing.model;

public class ModelEntity {

    ModelEntity(int id) {
        this.id = id;
    }

    ModelEntity() {
    }

    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
