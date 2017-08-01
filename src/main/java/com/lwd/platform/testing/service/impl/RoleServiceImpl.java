package com.lwd.platform.testing.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.lwd.platform.testing.model.business.Role;
import com.lwd.platform.testing.repo.CrudDao;
import com.lwd.platform.testing.repo.RoleDao;
import com.lwd.platform.testing.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends AbstractCrudService<Role> implements RoleService {

    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    protected CrudDao<Role> getCrudDao() {
        return roleDao;
    }

    @Override
    public List<Role> getRolesForUser(int id) {
        List<Integer> roleIds = roleDao.getRolesForUser(id);
        List<Role> roles = new ArrayList<>();
        roleIds.forEach(roleId -> {
            Role role = roleDao.read(roleId);
            if (role != null) {
                roles.add(role);
            }
        });
        return roles;
    }
}