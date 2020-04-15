package com.apiao.wolongspringboot.repository;

import com.apiao.wolongspringboot.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository里面包含了各种查询方法
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    //查询教学进度平均值
    @Query(value = "select avg(teach_state) from teacher",nativeQuery = true)
    int findAvgState();
    //查询教学进度
    @Query(value = "select teach_state from teacher",nativeQuery = true)
    int[] findTeachState();
}
