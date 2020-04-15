package com.apiao.wolongspringboot.repository;

import com.apiao.wolongspringboot.entity.Img;
import com.apiao.wolongspringboot.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository里面包含了各种查询方法
public interface ImgRepository extends JpaRepository<Img,Integer> {
}
