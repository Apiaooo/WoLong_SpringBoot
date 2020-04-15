package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Reserve;
import com.apiao.wolongspringboot.repository.ReserveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/reserve")
public class ReserveHandler {
    @Autowired
    private ReserveRepository reserveRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Reserve> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return reserveRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody Reserve reserve){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        Reserve result = reserveRepository.save(reserve);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Reserve findById(@PathVariable("id") Integer id){
        return reserveRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Reserve reserve){
        Reserve result = reserveRepository.save(reserve);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        reserveRepository.deleteById(id);
    }

}
