package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Course;
import com.apiao.wolongspringboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/course")
public class CourseHandler {
    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Course> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return courseRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody Course course){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        Course result = courseRepository.save(course);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Course findById(@PathVariable("id") Integer id){
        return courseRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Course course){
        Course result = courseRepository.save(course);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        courseRepository.deleteById(id);
    }

}
