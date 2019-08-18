package cn.hwd.dao;

import cn.hwd.domain.Permission;
import cn.hwd.domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public interface RolesDao {

    @Select("select * from role where id in (select roleId from user_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "permissions",column = "id",javaType = List.class,many = @Many(select = "cn.hwd.dao.permissionDao.findByRoleId"))
    })
    public List<Role> findByUserId(Integer userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from role where id=#{id}")
    Role findById(Integer id);

    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findAllPermission(Integer id);

    @Insert("insert into role_permission(permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("permissionId") Integer permissionId, @Param("roleId") Integer roleId);
}
