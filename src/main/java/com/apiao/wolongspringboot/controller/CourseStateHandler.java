package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.CourseState;
import com.apiao.wolongspringboot.repository.CourseStateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/courseState")
public class CourseStateHandler {
    @Autowired
    private CourseStateRepository courseStateRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<CourseState> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return courseStateRepository.findAll(request);
    }

}
