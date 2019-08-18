package cn.hwd.service;

import cn.hwd.domain.Role;
import cn.hwd.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<UserInfo> findAll(int page, int size);

    void save(UserInfo userInfo);

    UserInfo findById(Integer userId);

    List<Role> findOtherRole(int userId);

    void addRoleToUser(Integer userId, Integer[] ids);
}
