package com.example.implement_relation_database.controllers;

import com.example.implement_relation_database.models.User;
import com.example.implement_relation_database.util.SerializationUtil;
import com.example.implement_relation_database.util.Validation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

        ArrayList<User> userList= SerializationUtil.deSerialization();


    //REGISTRY
    @GetMapping
    public String registry(){
        return "registry";
    }
    @PostMapping
    public String registryPost(@RequestParam("name") String name, @RequestParam("surname") String surname,
                               @RequestParam("email") String email, @RequestParam("age") int age, Model model){
        String result = Validation.valid(name, surname, email, age);
        if(!result.equals("ok")){
            model.addAttribute("isIncorrect", true);
            model.addAttribute("result", result);
            return "registry";
        }

        String uniqueID = UUID.randomUUID().toString();
        User user = new User(uniqueID, name, surname, email, age);
        //if file is empty
        if(userList == null){
            userList = new ArrayList<>();
        }

        userList.add(user);
        SerializationUtil.serialization(userList);
        userList.forEach(System.out::println);
        return "ok";
    }
}
