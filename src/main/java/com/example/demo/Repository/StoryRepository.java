package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer>{
    Story getById(String storyId);
}
