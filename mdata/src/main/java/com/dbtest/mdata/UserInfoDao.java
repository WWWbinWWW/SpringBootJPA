package com.dbtest.mdata;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface UserInfoDao extends CrudRepository<User, Integer> {

    @Query("select name,age from User")
    List<User> query();

    @Query("FROM User u WHERE u.name=:name")
    User findUser(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("delete from User where name=:name")
    void del(@Param("name") String name);

    @Transactional
    @Modifying
    @Query("update User u set u.age=:age where u.name=:name")
    void upd(@Param("name") String name, @Param("age") Integer age);
}
