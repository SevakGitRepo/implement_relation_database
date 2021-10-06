package com.example.implement_relation_database.update;

import com.example.implement_relation_database.filter.FilterListByFilters;
import com.example.implement_relation_database.insert.ValidationQuery;
import com.example.implement_relation_database.models.User;
import com.example.implement_relation_database.util.SerializationUtil;

import java.util.*;
import java.util.stream.Collectors;

public class UpdateUtil {

    public static ArrayList<String> answer(String query) {

        ArrayList<String> result = new ArrayList<>();

        ArrayList<User> filterUser = FilterListByFilters.filter(SerializationUtil.deSerialization(), getAllFilters(query));

        ArrayList<User> users = changeUser(filterUser, columnWitchWeMustChange(query));

        for (User user : users) {
            result.add(user.toString());
        }
        return result;

    }

    private static Map<String, String> getAllFilters(String query) {
        Map<String, String> result = new HashMap<>();
        String afterWherePart = query.substring(query.indexOf(")")+1).trim();

        List<String> filterPart = Arrays
                .stream(afterWherePart.split("\\s+"))
                .skip(1)
                .collect(Collectors.toList());

        for (String s : filterPart) {
            String[] split = s.split("=");
            result.put(split[0].trim().toLowerCase(Locale.ROOT), split[1].trim());

        }
        return result;
    }

    //map e vor@ talis e vor syunakum inch piti grenq
    private static Map<String, String> columnWitchWeMustChange (String query){
        String param = query.substring(query.indexOf("(")+1, query.indexOf(")")).trim();
        String[] splitColumn = param.split(", ");

        Map<String, String> changeColumn = new HashMap<>();

        for (String s : splitColumn) {
            String[] split = s.split("=");
            changeColumn.put(split[0].trim().toLowerCase(Locale.ROOT), split[1].trim());
        }

        return changeColumn;
    }

    private static ArrayList<User> changeUser(ArrayList<User> users, Map<String, String> columns){

        for (User user : users) {
            for (Map.Entry<String, String> column : columns.entrySet()) {
                if(column.getKey().equals("name")){
                    user.setName(column.getValue());
                }
                if(column.getKey().equals("surname")){
                    user.setSurname(column.getValue());
                }
                if(column.getKey().equals("email")){
                    user.setEmail(column.getValue());
                }
                if(column.getKey().equals("age")){
                    user.setAge(Integer.parseInt(column.getValue()));
                }
            }

            ArrayList<User> usersDb = SerializationUtil.deSerialization();
            for (int i = 0; i < usersDb.size(); i++) {
                if(usersDb.get(i).getId().equals(user.getId())){
                    usersDb.set(i, user);
                    break;
                }
            }
            SerializationUtil.serialization(usersDb);
        }
        return SerializationUtil.deSerialization();
    }
}
