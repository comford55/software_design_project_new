package com.example.demo.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Gag;
import com.example.demo.Entity.GagDetail;
import com.example.demo.Repository.GagRepository;
import com.example.demo.Repository.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GagRepository gagRepository;

    public void getJson() throws JsonParseException, JsonMappingException, IOException{
        ObjectMapper objectMapper = new ObjectMapper();
        List<GagDetail> gag = objectMapper.readValue(new File("src/main/resources/test.json"), new TypeReference<List<GagDetail>>(){});
        if(gag!=null && !gag.isEmpty()){
            List<Gag> gags = new ArrayList<>();
            gag.forEach(g -> gags.add(new Gag(g.getId(), g.getGagDetail(), g.getAuthor())));

            // gagRepository.saveAll(gags);

            // List<Gag> a = gagRepository.findAll();
            // for(int i=0;i<gag.size();i++){
            //     if((a.get(i).getGagId())!=(gag.get(i).getId())){
            //         System.out.println(a.get(i).getGagId());
            //         System.out.println(gag.get(i).getId());
            //     }
            // }
        }
    }

    public List<Gag> allGags(){
        return gagRepository.findAll();
    }

    public Gag getRandomGag(){
        double count = gagRepository.count();
        double random = Math.random() * count + 1;
        Optional<Gag> result = gagRepository.findById((int) random);
        return result.get();
    }
}
