package com.lwd.platform.testing.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ModelEntity {

    public ModelEntity(int id) {
        this.id = id;
    }

    public ModelEntity() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
