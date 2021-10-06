package com.example.implement_relation_database.select;

import com.example.implement_relation_database.filter.FilterListByFilters;
import com.example.implement_relation_database.models.User;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class AnswerByFilter {
    public static ArrayList<String> returnAllUsers(ArrayList<User> users, Map<String, String> filter){
       ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.toString());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersById(ArrayList<User> users, Map<String, String> filter){
        ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.getId());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersByName(ArrayList<User> users, Map<String, String> filter){
        ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.getName());
        }
        return result;
    }
    public static ArrayList<String> returnAllUsersBySurname(ArrayList<User> users, Map<String, String> filter){
        ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.getSurname());
        }
        return result;
    }
    public static ArrayList<String> returnAllUsersByEmail(ArrayList<User> users, Map<String, String> filter){
        ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.getEmail());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersByAge(ArrayList<User> users, Map<String, String> filter){
        ArrayList<User> filterUsers = FilterListByFilters.filter(users, filter);
        ArrayList<String> result = new ArrayList<>();
        for (User user : filterUsers) {
            result.add(user.getAge()+"");
        }
        return result;
    }


}
