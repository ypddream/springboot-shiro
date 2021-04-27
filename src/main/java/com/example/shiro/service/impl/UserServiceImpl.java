package com.example.shiro.service.impl;

import com.example.shiro.dao.UserDao;
import com.example.shiro.entity.Role;
import com.example.shiro.entity.User;
import com.example.shiro.service.UserService;
import com.example.shiro.utils.SaltUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ClassName:UserServiceImp
 * Package:com.example.shiro.service.impl
 * Description:TODO
 *
 * @Date:2021/4/26 0026 下午 3:30
 * @author:ypd
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void register(User user) {
        //处理业务调用dao
        //明文密码进行md5 + salt +hash散列
        //1.生成随机salt
        String salt = SaltUtil.getSalt(8);
        //2.将生成的随机盐保存到数据库
        user.setSalt(salt);
        //3.明文密码进行md5+salt+hash散列
        Md5Hash md5Hash = new Md5Hash(user.getPassword(), salt, 1024);
        user.setPassword(md5Hash.toHex());

        userDao.save(user);


    }

    @Override
    public User findByUserName(String username) {

        return userDao.findByUserName(username);
    }


    @Override
    public User findRolesByUserName(String usernanme) {
        return userDao.findRolesByUserName(usernanme);
    }
}
