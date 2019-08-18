package cn.hwd.dao;

import cn.hwd.domain.Role;
import cn.hwd.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.hwd.dao.RolesDao.findByUserId"))

    })
    public UserInfo findByUsername(String username);


    @Select("select * from users")
    List<UserInfo> findAll();


    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{userId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roles",column = "id",javaType = List.class,many = @Many(select = "cn.hwd.dao.RolesDao.findByUserId"))
    })
    UserInfo findByUserId(Integer userId);

    @Select("select * from role where id not in(select roleId from user_role where userId=#{userId})")
    List<Role> findOtherRole(int userId);

    @Insert("insert into user_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") Integer userId, @Param("roleId") Integer roleId);
}
