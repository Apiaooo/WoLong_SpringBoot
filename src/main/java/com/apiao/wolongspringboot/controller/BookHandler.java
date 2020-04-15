package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Book;
import com.apiao.wolongspringboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return bookRepository.findAll(request);
    }
    @PostMapping("/save")
    public String save(@RequestBody Book book){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        Book result = bookRepository.save(book);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        return bookRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result = bookRepository.save(book);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        bookRepository.deleteById(id);
    }
}
