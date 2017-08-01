package com.lwd.platform.testing.repo;

import java.util.List;

import com.lwd.platform.testing.model.business.Role;

public interface RoleDao extends CrudDao<Role> {

    List<Integer> getRolesForUser(int id);

}