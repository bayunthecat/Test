package com.lwd.platform.testing.service;

import java.util.List;

import com.lwd.platform.testing.model.business.Role;
import com.lwd.platform.testing.repo.CrudDao;

public interface RoleService extends CrudDao<Role> {

    List<Role> getRolesForUser(int id);

}