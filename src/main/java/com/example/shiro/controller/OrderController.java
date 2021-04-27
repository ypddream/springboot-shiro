package com.example.shiro.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:OrderController
 * Package:com.example.shiro.controller
 * Description:实现权限的方式： 1.代码方式授权  两种方式 1.1基于角色  1.2基于权限
 *                              2.注解方式授权
 *                               3. 页面资源授权
 *
 * @Date:2021/4/26 0026 下午 10:24
 * @author:ypd
 */
@Controller
@RequestMapping("order")
public class OrderController {

    @RequestMapping("save")
//    @RequiresRoles("admin")
//@RequiresRoles(value = {"admin","user"}) //同时具有admin,user权限
    @RequiresPermissions("user:update:01")
    public String save() {

        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        //代码的方式
        if (subject.hasRole("admin")) {
            System.out.println("保存订单");
        }else {
            System.out.println("无权访问");
        }

        //基于权限字符串

        return "redirect:/index.jsp";
    }
}
