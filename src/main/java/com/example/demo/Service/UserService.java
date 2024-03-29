package com.example.demo.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;


import com.example.demo.Entity.Category;
import com.example.demo.Entity.LikeStory;
import com.example.demo.Entity.Story;
import com.example.demo.Entity.StoryDetail;
import com.example.demo.Repository.CategoryRepository;
import com.example.demo.Repository.LikeStoryRepository;
import com.example.demo.Repository.StoryRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {

    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private LikeStoryRepository likeStoryRepository;

    public void getJson() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<StoryDetail> horrorStory = objectMapper.readValue(new File("src/main/resources/horrordata.json"), new TypeReference<List<StoryDetail>>(){});
        List<StoryDetail> comedyStory = objectMapper.readValue(new File("src/main/resources/comedydata.json"), new TypeReference<List<StoryDetail>>(){});
        List<Story> stories = new ArrayList<>();
        horrorStory.forEach(g -> stories.add(new Story(g.getTitle(), g.getStoryDetail(), g.getAuthor())));
        comedyStory.forEach(g -> stories.add(new Story(g.getTitle(), g.getStoryDetail(), g.getAuthor())));

        // if(story!=null && !story.isEmpty()){
        //     List<Story> stories = new ArrayList<>();
        //     story.forEach(g -> stories.add(new Story(g.getTitle(), g.getStoryDetail(), g.getAuthor())));

        //     gagRepository.saveAll(gags);
        // }
    }

    public List<Story> allGags(){
        return storyRepository.findAll();
    }

    public Story getRandomGag(){
        double count = storyRepository.count();
        double random = Math.random() * count + 1;
        Optional<Story> result = storyRepository.findById((int) random);
        return result.get();
    }

    public Story getRandomHorror(){
        List<Category> getHorrorCategory = categoryRepository.findByCategoryName("เรื่องสยอง");
        if(getHorrorCategory.isEmpty()){
            return new Story();
        }
        int random = (int) (Math.random() * getHorrorCategory.size());
        int categoryId = getHorrorCategory.get(random).getStory().getId();
        Optional<Story> result = storyRepository.findById(categoryId);
        return result.get();
    }

    public Story getRandomComedy(){
        List<Category> getComedyCategory = categoryRepository.findByCategoryName("เรื่องตลก");
        if(getComedyCategory.isEmpty()){
            return new Story();
        }
        int random = (int) (Math.random() * getComedyCategory.size());
        int categoryId = getComedyCategory.get(random).getStory().getId();
        Optional<Story> result = storyRepository.findById(categoryId);
        return result.get();
    }

    public void saveStory(Story story){
        if(story.getTitle().equals("")){
            story.setTitle("ไม่ระบุชื่อเรื่อง");
        }
        if(story.getAuthor().equals("")){
            story.setAuthor("ไม่ระบุผู้เขียน");
        }
        storyRepository.save(story);
    }

    public List<Category> saveCategory(String category){
        if(category == "เรื่องตลก"){
            Category comedy = new Category("เรื่องตลก");
            return List.of(comedy);
        } else {
            Category horror = new Category("เรื่องสยอง");
            return List.of(horror);
        }
    }

    public List<Story> getSpecificCategory(String category){
        List<Category> getMatchCategory = categoryRepository.findByCategoryName(category);
        List<Story> match = new ArrayList<Story>();
        getMatchCategory.forEach(g -> match.add(g.getStory()));
        return match;
    }

    public void saveLikeStory(Integer storyId){
        Optional<LikeStory> list = likeStoryRepository.findByStoryId(storyId);
        if(!list.isEmpty()){
            LikeStory like = list.get();
            like.increaseCount();
            likeStoryRepository.save(like);
        } else {
            LikeStory story = new LikeStory(storyRepository.findById(storyId).get());
            story.increaseCount();
            likeStoryRepository.save(story);
        }
    }

    public List<LikeStory> getLikeStory(){
        return likeStoryRepository.findAll(Sort.by(Order.by("count")));
    }
}
