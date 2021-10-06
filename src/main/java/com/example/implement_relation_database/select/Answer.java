package com.example.implement_relation_database.select;

import com.example.implement_relation_database.models.User;

import java.util.ArrayList;

public class Answer {
    public static ArrayList<String> returnAllUsers(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.toString());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersById(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getId());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersByName(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getName());
        }
        return result;
    }
    public static ArrayList<String> returnAllUsersBySurname(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getSurname());
        }
        return result;
    }
    public static ArrayList<String> returnAllUsersByEmail(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getEmail());
        }
        return result;
    }

    public static ArrayList<String> returnAllUsersByAge(ArrayList<User> users){
        ArrayList<String> result = new ArrayList<>();
        for (User user : users) {
            result.add(user.getAge()+"");
        }
        return result;
    }
}
