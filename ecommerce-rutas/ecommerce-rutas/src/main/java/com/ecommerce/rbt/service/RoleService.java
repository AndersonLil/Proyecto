package com.ecommerce.rbt.service;

import com.ecommerce.rbt.dao.RoleDao;
import com.ecommerce.rbt.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    private RoleDao roleDao;

    public Role createNewRole(Role role) {
        return roleDao.save(role);
    }
}
