package com.learnspringboot.repository;

import com.learnspringboot.domain.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author coderChenMing
 * @create 2021-03-25-23:11
 * @description repository
 */
public interface UserRepository extends JpaRepository<Items,Long>{
    public List<Items> findAll();
}
