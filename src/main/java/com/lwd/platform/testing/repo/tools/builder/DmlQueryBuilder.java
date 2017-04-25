package com.lwd.platform.testing.repo.tools.builder;

public interface DmlQueryBuilder {

    DmlQueryBuilder select(String fields);

    DmlQueryBuilder insert();

    DmlQueryBuilder delete();

    DmlQueryBuilder update();
}