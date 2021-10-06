package com.example.implement_relation_database.select;

import java.util.Locale;
import java.util.Set;

public class ValidationQuery {
    public static boolean validQuery(String []parts){
        if(parts[2].equalsIgnoreCase("from")
                &&parts[3].equalsIgnoreCase("user")
                &&parts.length==4)
            return true;
        else return parts.length > 4
                && parts[2].equalsIgnoreCase("from")
                && parts[3].equalsIgnoreCase("user")
                && parts[4].equalsIgnoreCase("where");
    }

    private  static final Set<String> fieldSet = Set.of("*", "id", "name", "surname", "email", "age");
    public static boolean validParam(String [] parts){
        return fieldSet.contains(parts[1].toLowerCase(Locale.ROOT));
    }
}
