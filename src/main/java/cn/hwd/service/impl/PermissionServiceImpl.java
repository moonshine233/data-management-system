package cn.hwd.service.impl;

import cn.hwd.dao.permissionDao;
import cn.hwd.domain.Permission;
import cn.hwd.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private cn.hwd.dao.permissionDao permissionDao;
    @Override
    public List<Permission> findAll() {

        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) {
        permissionDao.save(permission);
    }
}
