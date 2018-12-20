package com.sufanx.service;

import org.springframework.util.StringUtils;

/**
 * 登录服务
 */
public class LoginService {

    /**
     * 用户名
     */
    private final String username = "admin";
    /**
     * 密码
     */
    private final String password = "123456";

    /**
     * 登录验证
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录是否成功
     */
    public boolean login(String username, String password) {
        System.out.println("  开始进行登录验证。。。");
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            throw new RuntimeException("用户名和密码不可为空");
        }
        return this.username.equalsIgnoreCase(username) && this.password.equals(password);
    }
}
