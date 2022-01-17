package com.company.systems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.company.objects.users;
import com.company.systems.inputSystems;


public class loginSystems {
    private static File usersFile = new File("users.txt");
    private static ArrayList<String> currentUser = new ArrayList<>();

    public static void createArray(){
        for(int i = 0; i < 3; i++){
            currentUser.add("");
        }
    }

    public void getCurrentUser(){
        ArrayList<String> out = new ArrayList<>();
        if (!currentUser.isEmpty()){
            out = currentUser;
        }
        return out;
        //figure out a way to make current user never null
    }

    public static boolean logIn(){
        System.out.println("Username:");
        String username = inputSystems.inputString();
        System.out.println("Password:");
        String password = inputSystems.inputString();
        password = Integer.toString(password.hashCode());
        boolean valid = false;
        try{
            Scanner myReader = new Scanner(usersFile);
            while(myReader.hasNextLine()){
                String splitLine[] = myReader.nextLine().split(",");
                System.out.println(splitLine);
                if (splitLine[0].equals(username) && splitLine[1].equals(password)){
                    valid = true;
                    for (int i = 0; i < splitLine.length; i++){
                        currentUser.set(i,splitLine[i]);
                    }
                }
            }
        }
        catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
        return valid;
    }
    public static void signUp(){
        System.out.println("Enter Username: ");
        String username = inputSystems.inputString();
        System.out.println("Enter Password:");
        String password = inputSystems.inputString();
        System.out.println("Confirm Password:");
        String confPassword = inputSystems.inputString();
        if (password.equals(confPassword)){
            password = Integer.toString(password.hashCode());
            try{
                FileWriter myWriter = new FileWriter(usersFile.getName(),true);
                if (findUser(username)){
                    System.out.println("That username already exists");
                }
                else{
                    users myUser = new users(username,password,false);
                    String toFile = myUser.toString() + "\n";
                    System.out.println(toFile);
                    myWriter.write(toFile);
                }
                myWriter.close();
            }
            catch(IOException e){
                System.out.println("Error");
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Your passwords do not match");
        }
    }
    public static boolean findUser(String name){
        //finds the index of a book with a given title
        int lineCount = 0;
        int lineKey = -1;
        boolean valid = false;
        try{
            Scanner myReader = new Scanner(usersFile);
            int numLines = 1;
            while(myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                String splitList[] = currentLine.split(",");
                //System.out.println(splitList[0]);
                if (splitList[0].equals(name)) {
                    lineKey = lineCount;
                } else {
                    lineCount++;
                }
                numLines++;
            }
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
        if(lineKey >= 0){
            valid = true;
        }
        return valid;
    }
    public static void createusersFile(){
        try {
            if (usersFile.createNewFile()) {
                System.out.println("File created: " + usersFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
