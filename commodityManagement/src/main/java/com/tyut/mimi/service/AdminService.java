package com.tyut.mimi.service;

import com.tyut.mimi.pojo.Admin;

public interface AdminService {
    /**
     * 登陆判断
     * @param name 用户名
     * @param pwd  密码
     * @return  查询结果对象
     */
    Admin login(String name, String pwd);
}
