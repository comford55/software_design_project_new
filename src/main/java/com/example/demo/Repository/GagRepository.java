package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Gag;

public interface GagRepository extends JpaRepository<Gag, Integer>{
    
}
