package com.apiao.wolongspringboot;

import com.apiao.wolongspringboot.entity.Book;
import com.apiao.wolongspringboot.entity.User;
import com.apiao.wolongspringboot.repository.BookRepository;
import com.apiao.wolongspringboot.repository.ScheduleRepository;
import com.apiao.wolongspringboot.repository.TeacherRepository;
import com.apiao.wolongspringboot.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.util.List;

@SpringBootTest
class WolongspringbootApplicationTests {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;


    @Test
    void testSave1(){
        User user = new User();
        user.setUsername("表弟");
        user.setSex("男");
        user.setTell(13665956700l);
        user.setAddress("安溪");
        user.setTime(new Date(1));
        user.setMoney(100);
        User user1 = userRepository.save(user);
        System.out.println(user1);
    }
    @Test
    void login(){
        System.out.println(userRepository.findByUsername("admin"));
    }
//    @Test
//    void testTimeAndCount(){
//
//    }List<Object[]> list = userRepository.findMoneyAndCount();
//        for (Object[] user : list){
//            for (int i=0;i<user.length;i++){
//                System.out.println(String.valueOf(user[i])+"---------------");
//                System.out.println(String.valueOf(user[0])+"+"+String.valueOf(user[1]));
//            }
//            System.out.println();
//        }
    @Test
    void teacher(){
        System.out.println(teacherRepository.findAll());
    }
    @Test
    void schedule(){
        System.out.println(scheduleRepository.findAll());
    }
}
