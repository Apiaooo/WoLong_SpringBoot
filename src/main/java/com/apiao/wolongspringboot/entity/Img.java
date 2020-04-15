package com.apiao.wolongspringboot.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 图片类
 */
@Entity //类可以跟表绑定
@Data //自动生成get和set方法
public class Img {
    @Id //主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置自增
    private Integer id;
    private String fileName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
