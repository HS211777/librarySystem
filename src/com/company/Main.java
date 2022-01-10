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

    private static File booksFile = new File("books.txt");
    private static File usersFile = new File("users.txt");
    private static ArrayList<String> currentUser = new ArrayList<>();

    public static void main(String[] args) {
        LibrarySytems.createbooksFile();
        loginSystems.createusersFile();
        createArray();
        //String i = "password";
        //System.out.println(i.hashCode());
        boolean end = false;
        while (!end){
            System.out.println("Log in (1), Sign up (2) or Exit(3)?");
            int choice = inputInt();
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
                int selection = mainMenu();
                if (selection == 1 && LibrarySytems.isAdmin()){
                    LibrarySytems.addBook();
                }
                else if (selection == 2){
                    LibrarySytems.printBooks();
                }
                else if (selection == 3 && LibrarySytems.isAdmin()){
                    System.out.println("Enter the name of the book: (if there are spaces use _ instead)");
                    LibrarySytems.deleteBook(LibrarySytems.findBook(inputString()));
                }
                else if (selection == 4 && LibrarySytems.isAdmin()){
                    System.out.println("What is the name of the book you want to amend");
                    String bookName = inputString();
                    System.out.println("Which part would you like to amend?");
                    System.out.println("1 - Title");
                    System.out.println("2 - ISBN");
                    System.out.println("3 - Author");
                    System.out.println("4 - Genre");
                    int selection1 = inputInt();
                    if (selection1 == 1){
                        LibrarySytems.amendTitle(LibrarySytems.findBook(bookName));
                    }
                    else if (selection1 == 2){
                        LibrarySytems.amendISBN(LibrarySytems.findBook(bookName));
                    }
                    else if (selection1 == 3){
                        LibrarySytems.amendAuthor(LibrarySytems.findBook(bookName));
                    }
                    else if (selection1 == 4){
                        LibrarySytems.amendGenre(LibrarySytems.findBook(bookName));
                    }
                    else{
                        System.out.println("Please select a valid option");
                    }
                }
                else if (selection == 5){
                    System.out.println("Enter the name of the book: (if there are spaces use _ instead)");
                    System.out.println("What would you like to search by?");
                    System.out.println("1 - Title");
                    System.out.println("2 - ISBN");
                    System.out.println("3 - Author");
                    int selection1 = inputInt();
                    LibrarySytems.findSpecificBook(LibrarySytems.findBook(inputString()));
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



    public static int mainMenu(){
        System.out.println("--Main Menu--");
        System.out.println("1 - add a book to the system *Admin only");
        System.out.println("2 - see the book list");
        System.out.println("3 - remove a book from the system * Admin only");
        System.out.println("4 - amend a book *Admin only");
        System.out.println("5 - find a specific book");
        System.out.println("6 - exit");
        return inputInt();
    }







    public static void deleteFileContents(){
        try{
            FileWriter myWriter = new FileWriter(booksFile.getName(),false);
            myWriter.write("");
        }
        catch (IOException e){
            System.out.println("an Error occurred:");
            e.printStackTrace();
        }

    }





    public static int findUserIndex(String name){
        //finds the index of a book with a given title
        int lineCount = 0;
        int lineKey = 0;
        try{
            Scanner myReader = new Scanner(usersFile);
            while(myReader.hasNextLine()) {
                String currentLine = myReader.nextLine();
                String splitList[] = currentLine.split(",");
                //System.out.println(splitList[0]);
                if (splitList[0].equals(name)) {
                    lineKey = lineCount;
                } else {
                    lineCount++;
                }
            }
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
        return lineKey;
    }


    public static void createArray(){
        for(int i = 0; i < 3; i++){
            currentUser.add("");
        }
    }


}