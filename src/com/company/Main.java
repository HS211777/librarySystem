package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// when you type an isbn, you get a recursive IME :( like the MM tho
//same as above

public class Main {

    private static ArrayList<ArrayList<String>> booksArray = new ArrayList<>();
    private static File booksFile = new File("books.txt");
    public static void main(String[] args) {
        boolean end = false;
        while (!end){
            createFile();
            int selection = mainMenu();
            if (selection == 1){
                addBook();
            }
            else if (selection == 2){
                printBooks();
            }
            else if (selection == 3){
                deleteBook(findBook());
            }
            else if (selection == 4){
                end = true;
            }
            else{
                System.out.println("please enter a valid option");
            }
        }

    }

    public static void addBook(){
        try{
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            System.out.println("Title: (if there are spaces use _ instead)");
            String title = inputString();
            System.out.println("ISBN:");
            String ISBN = inputString();
            System.out.println("Author:");
            String Author = inputString();
            System.out.println("Genre:");
            String Genre = inputString();

            String toFile = title+","+ISBN+","+Author+","+Genre+"\n";
            myWriter.write(toFile);
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("Error: "+e);
        }

    }

    public static void printBooks(){
        try{
            Scanner myReader = new Scanner(booksFile);
            while(myReader.hasNextLine()){
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        }
        catch (FileNotFoundException e){
            System.out.println("Error found");
            e.printStackTrace();
        }
    }

    public static void deleteBook(int bookIndex){
        //find a book name and delete that line of the file
    }

    public static int mainMenu(){
        System.out.println("--Main Menu--");
        System.out.println("1 - add a book to the system");
        System.out.println("2 - see the book list");
        System.out.println("3 - remove a book from the system");
        System.out.println("4 - exit");
        return inputInt();
    }

    public static int inputInt(){
        Scanner input = new Scanner(System.in);
        int out = 0;
        boolean valid = false;
        while(!valid){
            try{
                out = input.nextInt();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error: "+e);
            }
        }
        return out;
    }

    public static String inputString(){
        Scanner input = new Scanner(System.in);
        String out = "";
        boolean valid = false;
        while(!valid){
            try{
                out = input.next();
                valid = true;
            }
            catch (Exception e){
                System.out.println("Error: "+e);
            }
        }
        return out;
    }

    public static void createFile(){
        try {
            if (booksFile.createNewFile()) {
                System.out.println("File created: " + booksFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static int findBook(){
        //finds the index of a book with a given title
        return 0;
    }
}
