package com.example.implement_relation_database.delete;

public class ValidationQuery {

    public static boolean validQuery(String []parts){
        return parts[1].equalsIgnoreCase("from")
                && parts[2].equalsIgnoreCase("user")
                && parts[3].equalsIgnoreCase("where")
                && parts.length > 4;
    }
}
