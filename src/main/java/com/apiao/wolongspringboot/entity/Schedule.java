package com.apiao.wolongspringboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 课程表
 */
@Entity //类可以跟表绑定
@Data //自动生成get和set方法
public class Schedule {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置自增
    private Integer id;
    private String label;
    private String oneCourse;
    private String oneTeacher;
//    private String oneRoom;
    private String twoCourse;
    private String twoTeacher;
//    private String twoRoom;
    private String threeCourse;
    private String threeTeacher;
//    private String threeRoom;
    private String fourCourse;
    private String fourTeacher;
//    private String fourRoom;
    private String fiveCourse;
    private String fiveTeacher;
//    private String fiveRoom;

}
