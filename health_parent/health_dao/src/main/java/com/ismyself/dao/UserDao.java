package com.ismyself.dao;

import com.github.pagehelper.Page;
import com.ismyself.pojo.User;

import java.util.HashMap;
import java.util.List;

/**
 * package com.ismyself.dao;
 *
 * @auther txw
 * @create 2019-08-04  19:24
 * @description：
 */
public interface UserDao {

    User findUserByUsername(String username);


    //分页查询
    Page<User> selectByCondition(String queryString);

    //新增用户,返回自增主键
    void addUser(User user);

    //往用户和角色中间表插入数据
    void setUserAndRole(HashMap<String, Integer> map);

    //根据用户id删除用户和角色关联表的
    void deleteUserAndRoleByUid(Integer userId);

    //根据用户id删除用户
    void deleteUserById(Integer userId);

    //根据ID查询用户信息
    User findUserById(Integer id);

    //根据用户ID查询用户角色列表
    List<Integer> findRoleIdsByUserId(Integer uid);

    //编辑用户信息
    void editUser(User user);
}
