package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    List<Category> findByCategoryName(String name);
}
