package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.NewsLeft;
import com.apiao.wolongspringboot.repository.NewsLeftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;


@RestController
@RequestMapping("/newsLeft")
public class NewsLeftHandler {
    @Autowired
    private NewsLeftRepository newsLeftRepository;

    //图片上传
    @RequestMapping("/upload")
    public String imgUpload(NewsLeft model, @RequestParam(value = "file", required = false) MultipartFile file,
                            HttpServletRequest request)throws IllegalStateException, IOException {
        if(!file.isEmpty()){
            String str = "/www/wwwroot/Wolong/image/";
            String fileName = file.getOriginalFilename();
            fileName = UUID.randomUUID().toString().replace("-","")+fileName.substring(fileName.lastIndexOf("."));
            File saveFile = new File(str + fileName);
            if (!saveFile.getParentFile().exists()){
                saveFile.getParentFile().mkdirs();
            }
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
            out.write(file.getBytes());
            out.flush();
            out.close();
            model.setImgName(fileName);
            newsLeftRepository.save(model);
            return "redirect:list";
        }else {
            newsLeftRepository.save(model);
            return "redirect:list";
        }
    }
    @GetMapping("/findAll/{page}/{size}")
    public Page<NewsLeft> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return newsLeftRepository.findAll(request);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        newsLeftRepository.deleteById(id);
    }
    @GetMapping("/findById/{id}")
    public NewsLeft findById(@PathVariable("id") Integer id){
        return newsLeftRepository.findById(id).get();
    }

    @PutMapping("/update")
    public String update(@RequestBody NewsLeft newsLeft){
        NewsLeft result = newsLeftRepository.save(newsLeft);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
}
