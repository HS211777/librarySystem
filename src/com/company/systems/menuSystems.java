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
}
