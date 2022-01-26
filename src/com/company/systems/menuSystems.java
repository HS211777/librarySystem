package com.company.systems;

public class menuSystems {
    public static int mainMenu() {
        System.out.println("--Main Menu--");
        System.out.println("1 - add a book to the system *Admin only");
        System.out.println("2 - see the book list");
        System.out.println("3 - remove a book from the system * Admin only");
        System.out.println("4 - amend a book *Admin only");
        System.out.println("5 - find a specific book");
        System.out.println("6 - exit");
        return inputSystems.inputInt();
    }
    public static int amendBookMenu(){
        System.out.println("Which part would you like to amend?");
        System.out.println("1 - Title");
        System.out.println("2 - ISBN");
        System.out.println("3 - Author");
        System.out.println("4 - Genre");
        return inputSystems.inputInt();
    }
    public static int findBookMenu(){
        System.out.println("Enter the name of the book: (if there are spaces use _ instead)");
        System.out.println("What would you like to search by?");
        System.out.println("1 - Title");
        System.out.println("2 - ISBN");
        System.out.println("3 - Author");
        return inputSystems.inputInt();
    }
}
