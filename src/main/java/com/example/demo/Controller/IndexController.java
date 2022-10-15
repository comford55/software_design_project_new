package com.example.demo.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Entity.Gag;
import com.example.demo.Entity.User;
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

    @GetMapping()
    public String index(){
        return "index";
    }

    @GetMapping("/gags")
    public String gags() throws JsonParseException, JsonMappingException, IOException{
        userService.getJson();
        return "index";
    }

    @GetMapping("/allgags")
    public String showAllGag(Model model){
        List<Gag> gags = userService.allGags();
        model.addAttribute("gags", gags);
        return "allGags";
    }

    @GetMapping("/randomgag")
    public String randomGag(Model model){
        Gag gag = userService.getRandomGag();
        model.addAttribute("gags", gag);
        return "randomGag";
    }

    @GetMapping("/register")
    public String register(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register_success")
    public String registerSuccess(User user){
        userService.saveUser(user);
        return "registerSuccess";
    }
}
