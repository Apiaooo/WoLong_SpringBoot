package com.apiao.wolongspringboot.repository;

import com.apiao.wolongspringboot.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    List<Admin> findByName(String name);
}
