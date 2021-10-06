package com.example.implement_relation_database.insert;

import com.example.implement_relation_database.models.User;
import com.example.implement_relation_database.util.SerializationUtil;

import java.util.ArrayList;
import java.util.UUID;

public class InsertUtil {

    public static String addUser(String query){
        if(!ValidationQuery.validQuery(query.split("\\s+"))){
            return "Query is incorrect";
        }
        String param = query.substring(query.indexOf("(")+1, query.indexOf(")")).trim();
        String[] split = param.split(", ");

        String uniqueID = UUID.randomUUID().toString();
        User user = new User(uniqueID, split[0], split[1], split[2], Integer.parseInt(split[3]));

        ArrayList<User> userList= SerializationUtil.deSerialization();
        userList.add(user);
        SerializationUtil.serialization(userList);

        return "OK";

    }
}
