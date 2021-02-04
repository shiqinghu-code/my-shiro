package com.qing.hu.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

/**
 * created by CaiBaoHong at 2018/4/18 16:08<br>
 */
@Service
public class RoleService {

    /**
     * 模拟根据用户id查询返回用户的所有角色，实际查询语句参考：
     * SELECT r.rval FROM role r, user_role ur
     * WHERE r.rid = ur.role_id AND ur.user_id = #{userId}
     * @param uid
     * @return
     */
    public Set<String> getRolesByUserId(Long uid){
        Set<String> roles = new HashSet<String>();
        //三种编程语言代表三种角色：js程序员、java程序员、c++程序员
        roles.add("js");
        roles.add("java");
        roles.add("cpp");
        return roles;
    }

}
