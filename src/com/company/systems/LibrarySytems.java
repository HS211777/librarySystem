package com.company.systems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.company.objects.books;
import com.company.systems.inputSystems;

public class LibrarySytems {
    private static File booksFile = new File("books.txt");

    public static void addBook(){
        try{
            FileWriter myWriter = new FileWriter(booksFile.getName(),true);
            System.out.println("Title: (if there are spaces use _ instead)");
            String title = inputSystems.inputString();
            System.out.println("ISBN:");
            int ISBN = inputSystems.inputInt();
            System.out.println("Author:");
            String Author = inputSystems.inputString();
            System.out.println("Genre: (if there are spaces use _ instead)");
            String Genre = inputSystems.inputString();

            books mybook = new books(title, ISBN, Author, Genre);

            String toFile = mybook.toString()+"\n";
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
    public static int findBookByTitle(String name){
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
            splitLine[0] = inputSystems.inputString();
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
            splitLine[1] = inputSystems.inputString();
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
            splitLine[2] = inputSystems.inputString();
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
            splitLine[3] = inputSystems.inputString();
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
    public static void createbooksFile(){
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
    public static void findSpecificBook(int bookIndex){
        try{
            String savedLine = "";
            Scanner myReader = new Scanner(booksFile);
            int count = 0;
            while(myReader.hasNextLine()) { //saves all but 1 line to an arraylist
                String currentLine = myReader.nextLine();
                if (count == bookIndex){
                    savedLine = currentLine;
                }
                count++;
            }
            System.out.println(savedLine);
            myReader.close();
        }
        catch (IOException e){
            System.out.println("an Error occurred");
            e.printStackTrace();
        }
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
}
