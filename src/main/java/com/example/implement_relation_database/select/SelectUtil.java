package com.example.implement_relation_database.select;

import com.example.implement_relation_database.models.User;
import com.example.implement_relation_database.util.SerializationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class SelectUtil {

    public static ArrayList<String> answerRequest(String query) {
        if (functionName(query).equals("getAllUser")) {
            return answerAll(query);
        } else if (functionName(query).equals("getAllUserWhere")) {
            return answerAllByFilter(query);
        } else {
            return null;
        }

    }


    private static String functionName(String query) {
        String[] parts = query.split("\\s+");
        if (parts.length >= 4 && ValidationQuery.validParam(parts) && ValidationQuery.validQuery(parts)) {
            return parts.length == 4 ? "getAllUser" : "getAllUserWhere";
        } else {
            return "BadRequest";
        }
    }

    private static ArrayList<String> answerAll(String query) {
        ArrayList<User> allUser = SerializationUtil.deSerialization();
        String[] filterBy = query.split("\\s+");
        switch (filterBy[1].toLowerCase(Locale.ROOT)) {
            case "*":
                return Answer.returnAllUsers(allUser);

            case "id":
                return Answer.returnAllUsersById(allUser);

            case "name":
                return Answer.returnAllUsersByName(allUser);

            case "surname":
                return Answer.returnAllUsersBySurname(allUser);

            case "email":
                return Answer.returnAllUsersByEmail(allUser);


            case "age":
                return Answer.returnAllUsersByAge(allUser);

            default:
                throw new IllegalArgumentException("Something wrong");
        }
    }

    //Sra hamar validacia chem grum
    //u chka > < ev ayln
    private static ArrayList<String> answerAllByFilter(String query) {
        ArrayList<User> allUser = SerializationUtil.deSerialization();
        Map<String, String> filter = getAllFilters(query);
        String[] filterBy = query.split("\\s+");
        switch (filterBy[1].toLowerCase(Locale.ROOT)) {
            case "*":
                return AnswerByFilter.returnAllUsers(allUser, filter);

            case "id":
                return AnswerByFilter.returnAllUsersById(allUser, filter);

            case "name":
                return AnswerByFilter.returnAllUsersByName(allUser, filter);

            case "surname":
                return AnswerByFilter.returnAllUsersBySurname(allUser, filter);

            case "email":
                return AnswerByFilter.returnAllUsersByEmail(allUser, filter);

            case "age":
                return AnswerByFilter.returnAllUsersByAge(allUser, filter);

            default:
                throw new IllegalArgumentException("Something wrong");
        }
    }

    private static Map<String, String> getAllFilters(String query) {
        Map<String, String> result = new HashMap<>();

        List<String> filterPart = Arrays
                .stream(query.split("\\s+"))
                .skip(5)
                .filter(elem -> !elem.equalsIgnoreCase("and"))
                .collect(Collectors.toList());

        for (String s : filterPart) {
            String[] split = s.split("=");
            result.put(split[0].trim().toLowerCase(Locale.ROOT), split[1].trim());

        }
        return result;
    }

}
