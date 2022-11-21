package com.tyut.mimi.controller;

import com.tyut.mimi.pojo.Admin;
import com.tyut.mimi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    // 所有的控制层一定有业务逻辑层对象
    @Autowired
     AdminService adminService;

    /**
     * admin登录判断
     * @param name  admin姓名
     * @param pwd   admin密码
     * @return  查询结果对象
     */
    @RequestMapping("login.action")
    public String adminLogin(String name, String pwd, HttpServletRequest request){
        Admin admin = adminService.login(name, pwd);
        if (admin != null) {
            request.setAttribute("admin",admin);
            return "main";
        }else {
            request.setAttribute("errmsg","用户名或密码不正确！！");
            return "login";
        }
    }
}
