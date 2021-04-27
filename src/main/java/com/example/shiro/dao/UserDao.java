package com.example.shiro.dao;

import com.example.shiro.entity.Perms;
import com.example.shiro.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * ClassName:UserDao
 * Package:com.example.shiro.dao
 * Description:TODO
 *
 * @Date:2021/4/26 0026 下午 3:12
 * @author:ypd
 */
@Mapper
public interface UserDao {

    void save(User user);

    User findByUserName(String username);

    //根据用户名查询所有角色
    User findRolesByUserName(String usernanme);

    //根据角色id查询权限信息方法
    List<Perms> findPermsByRoleId(Integer id);

}
