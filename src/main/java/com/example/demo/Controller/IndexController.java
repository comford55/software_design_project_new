package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Entity.Category;
import com.example.demo.Entity.LikeStory;
import com.example.demo.Entity.Story;
import com.example.demo.Service.UserService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

@Controller
public class IndexController {

    private UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "index";
    }

    @GetMapping("/addBaseStory")
    public String gags() throws JsonParseException, JsonMappingException, IOException{
        userService.getJson();
        return "index";
    }

    // @GetMapping("/allgags")
    // public String showAllGag(Model model){
    //     List<Story> gags = userService.allGags();
    //     model.addAttribute("gags", gags);
    //     return "allGags";
    // }

    // @GetMapping("/randomgag")
    // public String randomGag(Model model){
    //     Story gag = userService.getRandomGag();
    //     model.addAttribute("gags", gag);
    //     return "randomGag";
    // }

    @GetMapping("/category/comedy")
    public String comedyIndex(Model model){
        return "comedyIndex";
    }

    @GetMapping("/category/comedy/all")
    public String allComedy(Model model){
        Object comedy = userService.getSpecificCategory("เรื่องตลก");
        model.addAttribute("comedies", comedy);
        return "comedy";
    }

    @GetMapping("/category/comedy/random")
    public String randomComedy(Model model){
        Story comedy = userService.getRandomComedy();
        model.addAttribute("comedies", comedy);
        return "comedy";
    }

    @GetMapping("/category/horror")
    public String horrorIndex(Model model){
        return "horrorIndex";
    }

    @GetMapping("/category/horror/all")
    public String allHorror(Model model){
        List<Story> horror = userService.getSpecificCategory("เรื่องสยอง");
        model.addAttribute("horrors", horror);
        return "horror";
    }

    @GetMapping("/category/horror/random")
    public String randomHorror(Model model){
        Story horror = userService.getRandomHorror();
        model.addAttribute("horrors", horror);
        return "horror";
    }

    @GetMapping("/category/horror/add")
    public String addHorror(Model model){
        Story story = new Story();
        model.addAttribute("horror", story);
        return "addHorror";
    }

    @PostMapping("/addHorror")
    public String addHorrorSuccess(Story story){
        List<Category> category = userService.saveCategory("เรื่องสยอง");
        story.setCategory(category);
        userService.saveStory(story);
        return "horrorIndex";
    }

    @GetMapping("/category/comedy/add")
    public String addComedy(Model model){
        Story story = new Story();
        model.addAttribute("comedy", story);
        return "addComedy";
    }

    @PostMapping("/addComedy")
    public String addComedy(Story story){
        List<Category> category = userService.saveCategory("เรื่องตลก");
        story.setCategory(category);
        userService.saveStory(story);
        return "comedyIndex";
    }

    @GetMapping("/addGag")
    public String addGag(Model model){
        Story gag = new Story();
        model.addAttribute("gag", gag);
        return "register";
    }

    @PostMapping("/like_story")
    public String likeStory(@RequestParam Integer storyId){
        userService.saveLikeStory(storyId);
        return "index";
    }

    @GetMapping("/mostlike")
    public String mostLike(Model model){
        List<LikeStory> list = userService.getLikeStory();
        model.addAttribute("allLike", list);
        return "likeStory";
    }
}
