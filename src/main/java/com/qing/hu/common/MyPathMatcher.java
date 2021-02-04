package com.qing.hu.common;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

@Component
public class MyPathMatcher {

    private PathMatcher pathMatcher = new AntPathMatcher();

    /**
     * @param resources 拥有的资源
     * @param reqUrl    要访问的路径
     */
    public boolean isMatcher(Iterable<String> resources, String reqUrl) {

        if (resources == null || reqUrl == null) {
            System.out.println("参数错误");
        }
        for (String res : resources) {
            return pathMatcher.match(res, reqUrl);
        }
        return false;
    }

    public static void main(String[] args) {
        MyPathMatcher myPathMatcher = new MyPathMatcher();
        Set<String> strings = new HashSet<String>();
        strings.add("/user/**");
        boolean matcher = myPathMatcher.isMatcher(strings, "/user/find");
        System.out.println(matcher);
    }
}