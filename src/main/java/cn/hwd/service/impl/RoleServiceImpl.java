package cn.hwd.service.impl;

import cn.hwd.dao.RolesDao;
import cn.hwd.domain.Permission;
import cn.hwd.domain.Role;
import cn.hwd.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RolesDao rolesDao;

    @Override
    public List<Role> findAll() {

        return rolesDao.findAll();
    }

    @Override
    public void save(Role role) {
        rolesDao.save(role);
    }

    @Override
    public Role findById(Integer id) {

        return rolesDao.findById(id);
    }

    @Override
    public List<Permission> findAllPermission(Integer id) {

        return rolesDao.findAllPermission(id);
    }

    @Override
    public void addPermissionToRole(Integer roleId, Integer[] ids) {
        for (Integer permissionId :
                ids) {
            rolesDao.addPermissionToRole(permissionId,roleId);
        }
    }
}
