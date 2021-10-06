package com.example.implement_relation_database.filter;

import com.example.implement_relation_database.models.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterListByFilters {
    public static ArrayList<User> filter(ArrayList<User> users, Map<String, String> filterMap){
        for (Map.Entry<String, String> stringStringEntry : filterMap.entrySet()) {
            if(stringStringEntry.getKey().equals("id")){
                users = (ArrayList<User>)users.stream()
                        .filter(user -> user.getId().equals(stringStringEntry.getValue()))
                        .collect(Collectors.toList());

            }

            if(stringStringEntry.getKey().equals("name")){
                users = (ArrayList<User>)users.stream()
                        .filter(user -> user.getName().equals(stringStringEntry.getValue()))
                        .collect(Collectors.toList());

            }


            if(stringStringEntry.getKey().equals("surname")){
                users = (ArrayList<User>)users.stream()
                        .filter(user -> user.getSurname().equals(stringStringEntry.getValue()))
                        .collect(Collectors.toList());

            }


            if(stringStringEntry.getKey().equals("email")){
                users = (ArrayList<User>)users.stream()
                        .filter(user -> user.getEmail().equals(stringStringEntry.getValue()))
                        .collect(Collectors.toList());

            }


            if(stringStringEntry.getKey().equals("age")){
                users = (ArrayList<User>)users.stream()
                        .filter(user -> (user.getAge()+"").equals(stringStringEntry.getValue()))
                        .collect(Collectors.toList());
            }
        }
        return users;
    }
}
