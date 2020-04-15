package com.apiao.wolongspringboot.repository;

import com.apiao.wolongspringboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository里面包含了各种查询方法
public interface UserRepository extends JpaRepository<User,Integer> {
    //通过名字相等查询
    List<User> findByUsername(String username);

    //查询每月的收入
    //@Query的nativeQuery属性值默认是false，表示使用JPQL语言。设为true表示使用本地sql（数据库对应的sql）
    @Query(value = "select sum(money) from user where year(time) = 2019  group by month (time)" ,nativeQuery=true)
    int[] findMoneyAndCount();

    //查询每月的报名人数
    @Query(value = "select count(username) from user where year(time) = 2019  group by month (time)",nativeQuery = true)
    int[] findTimeAndCount();
}
