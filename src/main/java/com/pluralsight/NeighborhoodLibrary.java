package com.pluralsight;

import java.util.Scanner;

public class NeighborhoodLibrary {

    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Book[] library = new Book[30];

        new Book(10001, "978-3-16-148410-0", "The Great Gatsby", false, "");
        new Book(10002, "978-0-7432-7356-5", "1984", false, "");
        new Book(10003, "978-0-452-28423-4", "To Kill a Mockingbird", false, "");
        new Book(10004, "978-0-14-018739-6", "Moby Dick", false, "");
        new Book(10005, "978-0-618-25376-9", "The Catcher in the Rye", true, "Alice");
        new Book(10006, "978-0-7432-7356-6", "The Odyssey", false, "");
        new Book(10007, "978-0-14-243723-0", "Pride and Prejudice", false, "");
        new Book(10008, "978-1-4028-9462-6", "Crime and Punishment", false, "");
        new Book(10009, "978-1-4028-9470-1", "War and Peace", false, "");
        new Book(10010, "978-0-14-312774-1", "The Brothers Karamazov", true, "Bob");
        new Book(10011, "978-1-5011-0399-4", "The Alchemist", false, "");
        new Book(10012, "978-0-451-52993-5", "Brave New World", true, "Charlie");
        new Book(10013, "978-0-06-112241-5", "The Road", false, "");
        new Book(10014, "978-0-385-53316-7", "The Shining", true, "David");
        new Book(10015, "978-0-618-08769-7", "Frankenstein", false, "");
        new Book(10016, "978-0-618-08770-3", "Dracula", false, "");
        new Book(10017, "978-0-14-118776-1", "Heart of Darkness", true, "Eva");

        boolean isRunning = true;

        while (isRunning) {

            // prints out all user options
            System.out.println("""
                    THE LIBRARY IS OPEN.
                    What would you like to do?
                    (1) Show all available books
                    (2) Show all checked out books
                    (3) Search by ID
                    (4) Search by title
                    (5) Donate a book
                    (6) Quit
                    """);

            // takes user input as int option, with an additional line to eat the buffer
            int option = input.nextInt();
            input.nextLine();

            // switch statement to choose through all the options, which lead to different methods
            // all cases will lead to other methods
            switch (option) {
                case 1:
                    listAllBooks(library);
                    break;
                case 2:
                    searchByIsCheckedOut(library);
                    break;
                case 3:
                    searchByID(library);
                    break;
                case 4:
                    searchBytitle(library);
                    break;
                case 5:
                    donateBook(library);
                    break;
                // case 6 will make isRunning false, ending the program by exiting the while loop
                case 6:
                    isRunning = false;
                    System.out.println("THE LIBRARY IS CLOSED, OFFICIALLY.");
                    break;
            }

        }






    }




}
