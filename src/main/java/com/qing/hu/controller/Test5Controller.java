package com.qing.hu.controller;

import org.apache.shiro.authz.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by CaiBaoHong at 2018/4/18 15:51<br>
 *     测试shiro提供的注解及功能解释
 */
@RestController
@RequestMapping("/t5")
public class Test5Controller {

    // 由于ShiroConfig中配置了该路径可以匿名访问，所以这接口不需要登录就能访问
    @GetMapping("/hello")
    public String hello() {
        return "hello spring boot";
    }

    // 如果ShiroConfig中没有配置该路径可以匿名访问，所以直接被登录过滤了。
    // 如果配置了可以匿名访问，那这里在没有登录的时候可以访问，但是用户登录后就不能访问
    @RequiresGuest
    @GetMapping("/guest")
    public String guest() {
        return "@RequiresGuest";
    }

    @RequiresAuthentication
    @GetMapping("/authn")
    public String authn() {
        return "@RequiresAuthentication";
    }

    @RequiresUser
    @GetMapping("/user")
    public String user() {
        return "@RequiresUser";
    }

    @RequiresPermissions("mvn:install")
    @GetMapping("/mvnInstall")
    public String mvnInstall() {
        return "mvn:install";
    }

    @RequiresPermissions("gradleBuild")
    @GetMapping("/gradleBuild")
    public String gradleBuild() {
        return "gradleBuild";
    }


    @RequiresRoles("js")
    @GetMapping("/js")
    public String js() {
        return "js programmer";
    }


    @RequiresRoles("python")
    @GetMapping("/python")
    public String python() {
        return "python programmer";
    }

}
