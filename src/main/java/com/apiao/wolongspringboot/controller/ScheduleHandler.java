package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Book;
import com.apiao.wolongspringboot.entity.Schedule;
import com.apiao.wolongspringboot.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/schedule")
public class ScheduleHandler {
    @Autowired
    private ScheduleRepository scheduleRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Schedule> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return scheduleRepository.findAll(request);
    }

    @GetMapping("/findById/{id}")
    public Schedule findById(@PathVariable("id") Integer id){
        return scheduleRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody Schedule schedule){
        Schedule result = scheduleRepository.save(schedule);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }

}
