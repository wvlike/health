package com.ismyself.service;

import com.ismyself.pojo.User;

/**
 * package com.ismyself.service;
 *
 * @auther txw
 * @create 2019-08-04  19:08
 * @description：
 */
public interface UserService {
    User findUserByUname(String username);
}