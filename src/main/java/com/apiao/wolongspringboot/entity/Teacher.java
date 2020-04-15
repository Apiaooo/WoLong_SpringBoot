package com.apiao.wolongspringboot.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 教师
 */
@Entity //类可以跟表绑定
@Data //自动生成get和set方法
public class Teacher {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置自增
    Integer id;
    String name;
    String teaching;
    Integer teachState;//教学进度

}
