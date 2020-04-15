package com.apiao.wolongspringboot.controller;

import com.apiao.wolongspringboot.entity.Admin;
import com.apiao.wolongspringboot.entity.ResultBean;
import com.apiao.wolongspringboot.repository.AdminRepository;
import com.apiao.wolongspringboot.util.TokenUtil;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/admin")
public class AdminHandler {
    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Admin> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest request = PageRequest.of(page,size);
        return adminRepository.findAll(request);
    }

    //登录验证
    @PostMapping("/login")
    public ResultBean login(@RequestBody Admin admin){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        List<Admin> result = adminRepository.findByName(admin.getName());
        for (Admin temp:result){
            System.out.println(temp.getName());
            if (result!=null){
                if((temp.getPassword().equals(admin.getPassword()))){
                    Map<String,Object> map = new HashMap<>();
                    map.put("apiao",temp);
                    return ResultBean.result(200,"登录成功",temp,true, TokenUtil.creatToken(map));
                }
                return ResultBean.result(401,"登录失败",admin,false,null);
            }
        }
        return ResultBean.result(400,"用户名不存在",admin,false,null);
    }
    @PostMapping("/save")
    public String save(@RequestBody Admin admin){//该注解的作用是将前端传过来的Json格式数据转换为java格式
        Admin result = adminRepository.save(admin);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Admin findById(@PathVariable("id") Integer id){
        return adminRepository.findById(id).get();
    }
    @PutMapping("/update")
    public String update(@RequestBody Admin admin){
        Admin result = adminRepository.save(admin);
        if (result!=null){
            return "success";
        }else {
            return "error";
        }
    }
    @DeleteMapping("/deleteById/{id}")
    public void delete(@PathVariable("id") Integer id){
        adminRepository.deleteById(id);
    }
    //图片上传
    @RequestMapping("/upload")
    public String imgUpload(Admin model, @RequestParam(value = "file", required = false) MultipartFile file,
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
            model.setHeadImg(fileName);
            adminRepository.save(model);
            return "redirect:list";
        }else {
            adminRepository.save(model);
            return "redirect:list";
        }
    }
}
