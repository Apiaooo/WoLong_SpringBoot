package com.apiao.wolongspringboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 课程类型
 */
@Entity //类可以跟表绑定
@Data //自动生成get和set方法
public class CourseClass {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置自增
    private Integer id;
    private String name;
    private String room;
    private Integer value;
}
