package com.apiao.wolongspringboot.repository;

import com.apiao.wolongspringboot.entity.CourseState;
import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository里面包含了各种查询方法
public interface CourseStateRepository extends JpaRepository<CourseState,Integer> {
}
