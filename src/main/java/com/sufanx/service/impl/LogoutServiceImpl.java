package com.sufanx.service.impl;

import com.sufanx.service.LogoutService;

/**
 * @author shuyufan
 */
public class LogoutServiceImpl implements LogoutService {

    @Override
    public void logout() {
        System.out.println("> Introduction：退出");
    }
}
