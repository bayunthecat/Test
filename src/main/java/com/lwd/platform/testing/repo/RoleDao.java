package com.lwd.platform.testing.repo;

import java.util.List;

import com.lwd.platform.testing.model.Role;

public interface RoleDao {

    List<Role> getRolesForUser(int id);
}