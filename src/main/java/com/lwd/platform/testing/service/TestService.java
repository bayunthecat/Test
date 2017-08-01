package com.lwd.platform.testing.service;

import com.lwd.platform.testing.model.business.Test;

import java.util.List;

public interface TestService extends CrudService<Test> {

    List<Test> getAll(int count, int offset);

}
