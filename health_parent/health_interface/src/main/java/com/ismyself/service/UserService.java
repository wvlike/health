package com.ismyself.service;

import com.ismyself.entity.Result;
<<<<<<< HEAD
import com.ismyself.pojo.Menu;
=======
>>>>>>> e01b3a32a27b161269bdc036bebc58ffd7672bf5
import com.ismyself.pojo.User;

import java.util.List;

/**
 * package com.ismyself.service;
 *
 * @auther txw
 * @create 2019-08-04  19:08
 * @description：
 */
public interface UserService {

    User findUserByUname(String username);

<<<<<<< HEAD
    List<Menu> findUserMenuByUsername(String username);

    List<Integer> findRoleIdsByUserId(Integer uid);

    User findUserById(Integer id);

    void addUser(List<Integer> roleIds, User user);

    Result findUser2Page(Integer currentPage, Integer pageSize, String queryString);

    void deleteUserById(Integer userId);

=======
    //分页查询用户信息列表
    Result findUser2Page(Integer currentPage, Integer pageSize, String queryString);

    //添加用户
    void addUser(List<Integer> roleIds, User user);

    //删除用户
    void deleteUserById(Integer userId);

    //根据ID查询用户信息
    User findUserById(Integer id);

    //根据用户ID查询用户的角色列表
    List<Integer> findRoleIdsByUserId(Integer uid);

    //编辑用户信息
>>>>>>> e01b3a32a27b161269bdc036bebc58ffd7672bf5
    void editUser(List<Integer> ids, User user);
}
