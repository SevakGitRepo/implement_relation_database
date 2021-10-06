package com.example.implement_relation_database.util;

import com.example.implement_relation_database.models.User;

import java.io.*;
import java.util.ArrayList;

public class SerializationUtil {

    private static final String FILE_NAME = "Sata";

    public static void serialization(ArrayList<User> users) {
        try(FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<User> deSerialization(){
        ArrayList<User> users = null;
        try(FileInputStream fileInputStream = new FileInputStream(FILE_NAME);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            System.out.println("");
            users = (ArrayList<User>) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    return users;
    }
}