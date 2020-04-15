package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Course;
import com.apiao.wolongspringboot.entity.CourseClass;
import com.apiao.wolongspringboot.repository.CourseClassRepository;
import com.apiao.wolongspringboot.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/courseClass")
public class CourseClassHandler {
    @Autowired
    private CourseClassRepository courseClassRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<CourseClass> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return courseClassRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody CourseClass courseClass){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        CourseClass result = courseClassRepository.save(courseClass);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public CourseClass findById(@PathVariable("id") Integer id){
        return courseClassRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody CourseClass courseClass){
        CourseClass result = courseClassRepository.save(courseClass);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        courseClassRepository.deleteById(id);
    }

}
