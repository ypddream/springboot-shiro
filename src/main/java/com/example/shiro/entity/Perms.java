package com.example.shiro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * ClassName:Perms
 * Package:com.example.shiro.entity
 * Description:TODO
 *
 * @Date:2021/4/27 0027 上午 10:39
 * @author:ypd
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Perms {
    private Integer id;
    private String name;
    private String url;
}
