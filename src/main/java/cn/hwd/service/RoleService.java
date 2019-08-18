package cn.hwd.service;

import cn.hwd.domain.Permission;
import cn.hwd.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    void save(Role role);

    Role findById(Integer id);

    List<Permission> findAllPermission(Integer id);

    void addPermissionToRole(Integer roleId, Integer[] ids);
}
