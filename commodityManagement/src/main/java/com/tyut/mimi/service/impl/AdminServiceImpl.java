package com.tyut.mimi.service.impl;

import com.tyut.mimi.mapper.AdminMapper;
import com.tyut.mimi.pojo.Admin;
import com.tyut.mimi.pojo.AdminExample;
import com.tyut.mimi.service.AdminService;
import com.tyut.mimi.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    //所有业务逻辑层，一定有持久层对象
    @Autowired
    AdminMapper adminMapper;

    /**
     * 登录功能的实现
     * @param name 用户名
     * @param pwd  密码
     * @return  查询结果对象
     */
    @Override
    public Admin login(String name, String pwd) {

        //根据传入的用户名和密码，去DB中查询响应的用户对象
        //如果有条件，一定要创建AdminExample的对象，用来分装查询条件
        AdminExample example = new AdminExample();
        /**
         * 如何添加条件
         *  select * from admin  where a_name = "admin"
          */
        //添加用户名条件
        example.createCriteria().andANameEqualTo(name);
        //查询
        List<Admin> admins = adminMapper.selectByExample(example);
        if (admins.size() > 0 ){
            Admin admin = admins.get(0);

            //如果查到数据，再进行账号密码对比,注意密码是密文的

            if (admin.getaPass().equals(MD5Util.getMD5(pwd))){
                return admin;
            }
        }
        return null;
    }
}
