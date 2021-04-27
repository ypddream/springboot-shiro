package com.example.shiro.service;


import com.example.shiro.entity.Perms;
import com.example.shiro.entity.User;

import java.util.List;


/**
 * ClassName:UserService
 * Package:com.example.shiro.service
 * Description:TODO
 *
 * @Date:2021/4/26 0026 下午 3:28
 * @author:ypd
 */

public interface UserService {

    //用户注册
    void register(User user);

    //根据用户名查询
    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String usernanme);

    //根据角色id查询权限信息方法
    List<Perms> findPermsByRoleId(Integer id);
}
