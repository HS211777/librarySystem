package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// when you type an isbn, you get a recursive IME :( like the MM tho
//same as above

public class Main {

    private static File booksFile = new File("books.txt");

    public static void main(String[] args) {
        createFile();
        boolean end = false;
        while (!end){
            int selection = mainMenu();
            if (selection == 1){
                addBook();
            }
            else if (selection == 2){
                printBooks();
            }
            else if (selection == 3){
                System.out.println("Enter the name of the book: (if there are spaces use _ instead)");
                deleteBook(findBook(inputString()));
            }
            else if (selection == 4){
                System.out.println("What is the name of the book you want to amend");
                String bookName = inputString();
                System.out.println("Which part would you like to amend?");
                System.out.println("1 - Title");
                System.out.println("2 - ISBN");
                System.out.println("3 - Author");
                System.out.println("4 - Genre");
                int selection1 = inputInt();
                if (selection1 == 1){
                    amendTitle(findBook(bookName));
                }
                else if (selection1 == 2){
                    amendISBN(findBook(bookName));
                }
                else if (selection1 == 3){
                    amendAuthor(findBook(bookName));
                }
                else if (selection1 == 4){
                    amendGenre(findBook(bookName));
                }
                else{
                    System.out.println("Please select a valid option");
                }
            }
            else if (selection == 5){
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
            System.out.println("Genre: (if there are spaces use _ instead)");
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
        //System.out.println(bookIndex);
        try{
            ArrayList<String> savedBooks = new ArrayList<>();
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            Scanner myReader = new Scanner(booksFile);
            int count = 0;
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                if (count != bookIndex){
                    savedBooks.add(currentLine);
                }
                count++;
            }
            deleteFileContents();
            for (int i = 0; i < savedBooks.size(); i++){ //prints arraylist into file
                myWriter.write(savedBooks.get(i)+"\n");
            }
            myReader.close();
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
    }

    public static int mainMenu(){
        System.out.println("--Main Menu--");
        System.out.println("1 - add a book to the system");
        System.out.println("2 - see the book list");
        System.out.println("3 - remove a book from the system");
        System.out.println("4 - amend a book");
        System.out.println("5 - exit");
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
    public static int findBook(String name){
        //finds the index of a book with a given title
        int lineCount = 0;
        int lineKey = 0;
        try{
            Scanner myReader = new Scanner(booksFile);
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
    public static void amendTitle(int bookIndex){
        try{
            ArrayList<String> savedBooks = new ArrayList<>();
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            Scanner myReader = new Scanner(booksFile);
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                savedBooks.add(currentLine);
            }
            deleteFileContents();
            String splitLine[] = savedBooks.get(bookIndex).split(",");
            System.out.println("Enter the correct Title: (if there are spaces use _ instead)");
            splitLine[0] = inputString();
            String compileLine = "";
            for (int i = 0; i < 4; i++){
                compileLine = compileLine + splitLine[i] + ",";
            }
            savedBooks.set(bookIndex,compileLine);
            for (int i = 0; i < savedBooks.size(); i++){ //prints arraylist into file
                myWriter.write(savedBooks.get(i)+"\n");
            }
            myReader.close();
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
    }
    public static void amendISBN(int bookIndex){
        try{
            ArrayList<String> savedBooks = new ArrayList<>();
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            Scanner myReader = new Scanner(booksFile);
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                savedBooks.add(currentLine);
            }
            deleteFileContents();
            String splitLine[] = savedBooks.get(bookIndex).split(",");
            System.out.println("Enter the correct ISBN:");
            splitLine[1] = inputString();
            String compileLine = "";
            for (int i = 0; i < 4; i++){
                compileLine = compileLine + splitLine[i] + ",";
            }
            savedBooks.set(bookIndex,compileLine);
            for (int i = 0; i < savedBooks.size(); i++){ //prints arraylist into file
                myWriter.write(savedBooks.get(i)+"\n");
            }
            myReader.close();
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
    }
    public static void amendAuthor(int bookIndex){
        try{
            ArrayList<String> savedBooks = new ArrayList<>();
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            Scanner myReader = new Scanner(booksFile);
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                savedBooks.add(currentLine);
            }
            deleteFileContents();
            String splitLine[] = savedBooks.get(bookIndex).split(",");
            System.out.println("Enter the correct Author: (if there are spaces use _ instead)");
            splitLine[2] = inputString();
            String compileLine = "";
            for (int i = 0; i < 4; i++){
                compileLine = compileLine + splitLine[i] + ",";
            }
            savedBooks.set(bookIndex,compileLine);
            for (int i = 0; i < savedBooks.size(); i++){ //prints arraylist into file
                myWriter.write(savedBooks.get(i)+"\n");
            }
            myReader.close();
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
    }
    public static void amendGenre(int bookIndex){
        try{
            ArrayList<String> savedBooks = new ArrayList<>();
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            Scanner myReader = new Scanner(booksFile);
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                savedBooks.add(currentLine);
            }
            deleteFileContents();
            String splitLine[] = savedBooks.get(bookIndex).split(",");
            System.out.println("Enter the correct Genre: (if there are spaces use _ instead)");
            splitLine[3] = inputString();
            String compileLine = "";
            for (int i = 0; i < 4; i++){
                compileLine = compileLine + splitLine[i] + ",";
            }
            savedBooks.set(bookIndex,compileLine);
            for (int i = 0; i < savedBooks.size(); i++){ //prints arraylist into file
                myWriter.write(savedBooks.get(i)+"\n");
            }
            myReader.close();
            myWriter.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
    }
}