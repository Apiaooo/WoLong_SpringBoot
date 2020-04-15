package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Book;
import com.apiao.wolongspringboot.entity.NewsRight;
import com.apiao.wolongspringboot.repository.NewsRightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/newsRight")
public class NewsRightHandler {
    @Autowired
    private NewsRightRepository newsRightRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<NewsRight> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return newsRightRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody NewsRight newsRight){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        NewsRight result = newsRightRepository.save(newsRight);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public NewsRight findById(@PathVariable("id") Integer id){
        return newsRightRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody NewsRight newsRight){
        NewsRight result = newsRightRepository.save(newsRight);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        newsRightRepository.deleteById(id);
    }
}
