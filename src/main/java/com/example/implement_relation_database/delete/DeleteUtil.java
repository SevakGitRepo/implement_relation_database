package com.example.implement_relation_database.delete;

import com.example.implement_relation_database.filter.FilterListByFilters;
import com.example.implement_relation_database.models.User;
import com.example.implement_relation_database.util.SerializationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteUtil {


    public static String deleteAllUser(String query){
        if(!ValidationQuery.validQuery(query.split("\\s+"))){
            return "Query is incorrect";
        }

        ArrayList<User> result = SerializationUtil.deSerialization();
        ArrayList<User> filterUsers = FilterListByFilters.filter(result, getAllFilters(query));

        result.removeAll(filterUsers);
        SerializationUtil.serialization(result);

        return "OK";

    }

    private static Map<String, String> getAllFilters(String query) {
        Map<String, String> result = new HashMap<>();

        List<String> filterPart = Arrays
                .stream(query.split("\\s+"))
                .skip(4)
                .filter(elem -> !elem.equalsIgnoreCase("and"))
                .collect(Collectors.toList());

        for (String s : filterPart) {
            String[] split = s.split("=");
            result.put(split[0].trim().toLowerCase(Locale.ROOT), split[1].trim());

        }
        return result;
    }
}
