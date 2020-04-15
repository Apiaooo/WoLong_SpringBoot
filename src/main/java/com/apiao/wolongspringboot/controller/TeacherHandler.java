package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Teacher;
import com.apiao.wolongspringboot.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/teacher")
public class TeacherHandler {
    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Teacher> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return teacherRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody Teacher teacher){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        Teacher result = teacherRepository.save(teacher);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Teacher findById(@PathVariable("id") Integer id){
        return teacherRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Teacher teacher){
        Teacher result = teacherRepository.save(teacher);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        teacherRepository.deleteById(id);
    }

    @GetMapping("/findAvgState")
    public int findAvg(){
        return teacherRepository.findAvgState();
    }

    @GetMapping("/findTeachState")
    public int[] findTeachState(){
        return teacherRepository.findTeachState();
    }

}
