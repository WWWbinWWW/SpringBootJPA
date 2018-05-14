package com.dbtest.mdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    @Autowired
    private UserInfoDao userInfoDao;

    public List<User> query(){
        return userInfoDao.query();
    }

    public User findUser(String name){
        return userInfoDao.findUser(name);
    }

    public void save(User user){
        userInfoDao.save(user);
    }

    public void del(String name){
        userInfoDao.del(name);
    }

    public void upd(String name, Integer age){
        userInfoDao.upd(name, age);
    }
}
