package com.pluralsight;

import java.util.Objects;
import java.util.Scanner;

public class NeighborhoodLibrary {

    public static Scanner input = new Scanner(System.in);

    public static int currentBookCount = 0;

    public static void main(String[] args) {

        Book[] library = new Book[30];

        new Book(10001, "978-3-16-148410-0", "The Great Gatsby", false, "");
        new Book(10002, "978-0-7432-7356-5", "1984", false, "");
        new Book(10003, "978-0-452-28423-4", "To Kill a Mockingbird", false, "");
        new Book(10004, "978-0-14-018739-6", "Moby Dick", false, "");
        new Book(10005, "978-0-618-25376-9", "The Catcher in the Rye", true, "Alwin");
        new Book(10006, "978-0-7432-7356-6", "The Odyssey", false, "");
        new Book(10007, "978-0-14-243723-0", "Pride and Prejudice", false, "");
        new Book(10008, "978-1-4028-9462-6", "Crime and Punishment", false, "");
        new Book(10009, "978-1-4028-9470-1", "War and Peace", false, "");
        new Book(10010, "978-0-14-312774-1", "The Brothers Karamazov", true, "Jazzy");
        new Book(10011, "978-1-5011-0399-4", "The Alchemist", false, "");
        new Book(10012, "978-0-451-52993-5", "Brave New World", true, "Ashley");
        new Book(10013, "978-0-06-112241-5", "The Road", false, "");
        new Book(10014, "978-0-385-53316-7", "The Shining", true, "Ahsan");
        new Book(10015, "978-0-618-08769-7", "Frankenstein", false, "");
        new Book(10016, "978-0-618-08770-3", "Dracula", false, "");
        new Book(10017, "978-0-14-118776-1", "Heart of Darkness", true, "Harman");

        for (int i = 0; i < library.length; i++) {
            if (Objects.equals(library[i].getTitle(), "")) {
                currentBookCount += 1;
            }
        }

        boolean isRunning = true;

        while (isRunning) {

            // prints out all user options
            System.out.println("""
                    THE LIBRARY IS OPEN.
                    What would you like to do?
                    (1) Show all available books
                    (2) Show all checked out books
                    (3) Check in a book
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
                    listAvailableBooks(library);
                    break;
                case 2:
                    searchByIsCheckedOut(library);
                    break;
                case 3:
                    checkInBook(library);
                    break;
                case 4:
                    searchByTitle(library);
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

    public static void printBookInfo(Book book) {

        System.out.printf("%s (ID: %d, ISBN: %s, Checked out status: %b\n",
                book.getTitle(), book.getId(), book.getIsbn(), book.isCheckedOut());

    }

    public static void printBookInfoWithBorrower(Book book) {

        System.out.printf("%s (ID: %d, ISBN: %s, Checked out by: %s",
                book.getTitle(), book.getId(), book.getIsbn(), book.getCheckedOutTo());

    }

    public static void listAvailableBooks(Book[] library) {

        System.out.println("Here are all the books in the library: ");
        for (int i = 0; i < currentBookCount; i++) {
            System.out.printf("Book #%d. ", i + 1);
            printBookInfo(library[i]);
        }

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("""
                What would you like to do?
                (1) Check out a book
                (2) Exit to main menu
                """);

            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                System.out.println("What is the ID of the book you want to check out?");
                int checkOutId = input.nextInt();
                input.nextLine();
                if (library[checkOutId-10001].isCheckedOut()) {
                    System.out.println("That book is not available.");
                }
                else if (library[checkOutId-10001].getTitle() == null || 10001> checkOutId || checkOutId > 10030) {
                    System.out.println("This book does not exist in our system.");
                }
                else {
                    System.out.println("What is your name?");
                    String checkOutName = input.nextLine();
                    library[checkOutId-10001].checkOut(checkOutName);
                    System.out.println("You have checked out " + library[checkOutId-10001].getTitle());
                }
            }

            else {
                System.out.println("EXITING TO MAIN MENU...");
                isRunning = false;
            }
        }

    }

    public static void searchByIsCheckedOut(Book[] library) {

        System.out.println("Here are all the books in the library that are checked out: ");
        for (int i = 0; i < currentBookCount; i++) {
            if (library[i].isCheckedOut()) {
                printBookInfoWithBorrower(library[i]);
            }
        }

        checkInBook(library);

    }

    public static void checkInBook(Book[] library) {

        boolean isRunning = true;

        while (isRunning) {

            System.out.println("""
                What would you like to do?
                (1) Check in a book
                (2) Exit to main menu
                """);

            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                System.out.println("What is the ID of the book you want to check in?");
                int checkInId = input.nextInt();
                input.nextLine();
                if (!library[checkInId -10001].isCheckedOut()) {
                    System.out.println("That book is not checked out.");
                }
                else if (library[checkInId -10001].getTitle() == null || 10001 > checkInId || checkInId > 10030) {
                    System.out.println("This book does not exist in our system.");
                }
                else {
                    library[checkInId -10001].checkIn();
                    System.out.println("You have checked in " + library[checkInId -10001].getTitle());
                }
            }

            else {
                System.out.println("EXITING TO MAIN MENU...");
                isRunning = false;
            }
        }

    }

    public static void searchByTitle(Book[] library) {

        // prompts user
        System.out.println("What is the title of the book you're looking for?");
        String searchTitle = input.nextLine();

        // uses for loop to check
        System.out.println("Here are books matching that title:");
        for (int i = 0; i < currentBookCount; i++) {
            Book book = library[i];
            // checks
            if (book.getTitle().toLowerCase().contains(searchTitle.toLowerCase())) {
                printBookInfo(book);
            }
        }

    }



}
