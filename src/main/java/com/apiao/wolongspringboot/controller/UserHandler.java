package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.User;
import com.apiao.wolongspringboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<User> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return userRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody User user){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        User result = userRepository.save(user);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id){
        return userRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody User user){
        User result = userRepository.save(user);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        userRepository.deleteById(id);
    }

    @GetMapping("/findMoneyAndCount")
    public int[] findMoneyAndCount(){
        return userRepository.findMoneyAndCount();
    }

    @GetMapping("/findTimeAndCount")
    public int[] findTimeAndCount(){
        return userRepository.findTimeAndCount();
    }
}
