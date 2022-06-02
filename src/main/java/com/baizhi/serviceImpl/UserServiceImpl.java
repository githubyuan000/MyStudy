package com.baizhi.serviceImpl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.util.MybatisUtil;

import java.util.UUID;

public class UserServiceImpl implements UserService {
    @Override
    public void register(User user) {
        try{
            //获取dao的实现类对象
            UserDao userDao =  MybatisUtil.openSession().getMapper(UserDao.class);
            String id = UUID.randomUUID().toString();
            user.setId("23");
            userDao.save(user);
            MybatisUtil.commit();
        }catch (Exception e){
            e.printStackTrace();
            MybatisUtil.rollback();

        }

    }
}
