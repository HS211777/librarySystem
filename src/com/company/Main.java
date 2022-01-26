package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import com.company.objects.books;
import com.company.objects.users;
import com.company.systems.inputSystems;
import com.company.systems.loginSystems;
import com.company.systems.menuSystems;
import com.company.systems.LibrarySytems;

// when you type an isbn, you get a recursive IME :( like the MM tho
//same as above

public class Main {


    public static void main(String[] args) {
        LibrarySytems.createbooksFile();
        loginSystems.createusersFile();
        //String i = "password";
        //System.out.println(i.hashCode());
        boolean end = false;
        while (!end){
            System.out.println("Log in (1), Sign up (2) or Exit(3)?");
            int choice = inputSystems.inputInt();
            boolean accessGranted = false;
            if (choice == 1){
                accessGranted = loginSystems.logIn();
            }
            else if (choice == 2){
                loginSystems.signUp();
            }
            else if (choice == 3){
                end = true;
            }
            else{
                System.out.println("Please enter a valid option");
            }
            while (accessGranted){
                int selection = menuSystems.mainMenu();
                if (selection == 1 && loginSystems.isAdmin()){
                    LibrarySytems.addBook();
                }
                else if (selection == 2){
                    LibrarySytems.printBooks();
                }
                else if (selection == 3 && loginSystems.isAdmin()){
                    System.out.println("Enter the name of the book: (if there are spaces use _ instead)");
                    LibrarySytems.deleteBook(LibrarySytems.findBookByTitle(inputSystems.inputString()));
                }
                else if (selection == 4 && loginSystems.isAdmin()){
                    System.out.println("What is the name of the book you want to amend");
                    String bookName = inputSystems.inputString();
                    int selection1 = menuSystems.amendBookMenu();
                    if (selection1 == 1){
                        LibrarySytems.amendTitle(LibrarySytems.findBookByTitle(bookName));
                    }
                    else if (selection1 == 2){
                        LibrarySytems.amendISBN(LibrarySytems.findBookByTitle(bookName));
                    }
                    else if (selection1 == 3){
                        LibrarySytems.amendAuthor(LibrarySytems.findBookByTitle(bookName));
                    }
                    else if (selection1 == 4){
                        LibrarySytems.amendGenre(LibrarySytems.findBookByTitle(bookName));
                    }
                    else{
                        System.out.println("Please select a valid option");
                    }
                }
                else if (selection == 5){
                    int selection1 = menuSystems.findBookMenu();
                    if (selection1 == 1){
                        LibrarySytems.findSpecificBook(LibrarySytems.findBookByTitle(inputSystems.inputString()));
                    }
                    else if (selection1 == 2){
                        //isbn search
                    }
                    else if (selection1 == 3){
                        //author name search
                    }
                    else{
                        System.out.println("please enter a valid option");
                    }
                }
                else if (selection == 6){
                    accessGranted = false;
                }
                else{
                    System.out.println("please enter a valid option");
                }
            }
            }


    }
    //public static int findUserIndex(String name){
        //finds the index of a book with a given title
        //int lineCount = 0;
        //int lineKey = 0;
        //try{
            //Scanner myReader = new Scanner(usersFile);
            //while(myReader.hasNextLine()) {
                //String currentLine = myReader.nextLine();
                //String splitList[] = currentLine.split(",");
                //System.out.println(splitList[0]);
               // if (splitList[0].equals(name)) {
                    //lineKey = lineCount;
                //} else {
                    //lineCount++;
                //}
            //}
        //}
        //catch (IOException e){
            //System.out.println("an Error occurred");
            //e.printStackTrace();
        //}
        //return lineKey;
    //}
}