package com.example.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * ClassName:Role
 * Package:com.example.shiro.entity
 * Description:TODO
 *
 * @Date:2021/4/27 0027 上午 10:38
 * @author:ypd
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    private Integer id;
    private String name;

    //定义权限的集合
    private List<Perms> perms;

}
