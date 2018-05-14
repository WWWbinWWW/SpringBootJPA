package com.dbtest.mdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class MdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(MdataApplication.class, args);
    }

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/query")
    public List<User> query(){
        return userInfoService.query();
    }

    @RequestMapping("/find")
    public User findUser(String name){
        return userInfoService.findUser(name);
    }

    @RequestMapping("/save")
    public void testAdd(){
        for(Integer i = 12; i < 15; i++) {
            User user = new User();
            user.setName("月色"+i);
            user.setAge(18+i);
            userInfoService.save(user);
        }
    }
    @RequestMapping("/del")
    public void testDel(String name){
        userInfoService.del(name);
    }

    @RequestMapping("/upd")
    public void testUpd(String name, Integer age){
        userInfoService.upd(name, age);
    }
}
