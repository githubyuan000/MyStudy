package com.baizhi.action;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.serviceImpl.UserServiceImpl;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport {
    //接收数据
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    public  String register(){
       //调用service
        UserService userService = new UserServiceImpl();
        userService.register(user);
        //跳转页面
        return  "index";
    }
}
