package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Img;
import com.apiao.wolongspringboot.repository.ImgRepository;
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
@RequestMapping("/img")
public class ImgHandler {
    @Autowired
    private ImgRepository imgRepository;

    //图片上传
    @RequestMapping("/upload")
    public String imgUpload(Img model,@RequestParam(value = "file", required = false) MultipartFile file,
                          HttpServletRequest request)throws IllegalStateException, IOException {
        if(!file.isEmpty()){
//            String str = "src/main/resources/static/upload/";
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
            model.setFileName(fileName);
            imgRepository.save(model);
            return "redirect:list";
        }else {
            imgRepository.save(model);
            return "redirect:list";
        }
    }
    @GetMapping("/findAll/{page}/{size}")
    public Page<Img> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return imgRepository.findAll(request);
    }

    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        imgRepository.deleteById(id);
    }
}
