package com.example.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * ClassName:User
 * Package:com.example.shiro.entity
 * Description:TODO
 *
 * @Date:2021/4/26 0026 下午 3:07
 * @author:ypd
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
    private String salt;
    //定义角色集合
    private List<Role> roles;
}
