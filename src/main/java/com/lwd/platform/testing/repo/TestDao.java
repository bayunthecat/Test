package com.lwd.platform.testing.repo;

import com.lwd.platform.testing.model.Test;

import java.util.List;

public interface TestDao extends CrudDao<Test> {

    List<Test> getTests(int count, int offset);
}
