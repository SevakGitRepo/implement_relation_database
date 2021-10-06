package com.example.implement_relation_database.insert;

import java.util.Locale;
import java.util.Set;

public class ValidationQuery {

    public static boolean validQuery(String []parts){
        return parts[1].equalsIgnoreCase("into")
                && parts[2].equalsIgnoreCase("user")
                && parts[3].equalsIgnoreCase("values")
                && parts.length > 4;
    }
}
