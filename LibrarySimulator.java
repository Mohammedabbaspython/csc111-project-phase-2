import java.util.Scanner;

public class LibrarySimulator {
    // initializing input Scanner
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // menus options count constants
        final int MAIN_MENU_OPTIONS = 3;
        final int USER_MENU_OPTIONS = 5;
        final int ADMIN_MENU_OPTIONS = 3;
        final int USER_ACCOUNTS_OPTIONS = 3;

        // option selecting variable
        int choice;

        // 3 predefined accounts with id number, user name, currently borrowed books
        Member user1 = new Member(1, "User 1", 0);
        Member user2 = new Member(2, "User 2", 0);
        Member user3 = new Member(3, "User 3", 0);

        // Active user account
        Member activeUser;

        // welcome message
        System.out.println("Welcome To The Public Library.");

        // main menu loop
        do {
            // main menu
            displayMainMenu();
            // choice
            choice = takeChoiceInput(MAIN_MENU_OPTIONS);

            // user menu
            if (choice == 1) {
                
                // users accounts
                displayUsersAccounts(user1, user2, user3);

                // choice
                choice = takeChoiceInput(USER_ACCOUNTS_OPTIONS);

                // set active user
                if (choice == 1) {
                    activeUser = user1;
                }
                else if (choice == 2) {
                    activeUser = user2;
                } 
                else {
                    activeUser = user3;
                }

                // Welcome feedback
                System.out.println("\t Welcome " + activeUser.getName());

                // user menu loop
                do {
                    // user menu
                    displayUserMenu();

                    // choice
                    choice = takeChoiceInput(USER_MENU_OPTIONS);

                    // perform action
                    switch (choice) {
                        case 1: // view borrowed books
                            activeUser.ViewBorrowedCount();
                            break;
                        case 2: // borrow a book
                            activeUser.borrowOne();
                            break;
                        case 3: // return a book
                            activeUser.returnOne();
                            break;
                        case 4: // session summary
                            activeUser.DisplayStatistics();
                            break;
                    }

                } while (choice != 5);

                // resetting session statistics
                activeUser.reset();

                // logout message
                System.out.println("\t You have logged out of your account.");

            }
            // admin menu
            else if (choice == 2) {
                // admin menu loop
                do {
                    // admin menu
                    displayAdminMenu();

                    // choice
                    choice = takeChoiceInput(ADMIN_MENU_OPTIONS);

                    switch (choice) {
                        case 1: // view total revenue
                            adminViewRevenue();
                            break;
                        case 2: // Most frequent operation
                            adminMostFrequent();
                            break;
                    }
                } while (choice != 3);
            // resetting choice so it won't get out of the main menu
            choice = 0;

            }

        } while (choice != 3);

        System.out.println("Goodbye:)");

        input.close();
    }

    public static void displayMainMenu() {
        // displaying main menu options
        System.out.println("Select from the main menu options:");
        System.out.println("\t 1 Log in as a user");
        System.out.println("\t 2 Log in as a administrator");
        System.out.println("\t 3 Exit");
    }

    public static void displayUserMenu() {
        // display user menu options
        System.out.println("User Operations Menu:");
        System.out.println("\t 1 View Borrowed Books Count");
        System.out.println("\t 2 Borrow Book");
        System.out.println("\t 3 Return Book");
        System.out.println("\t 4 View Session Summary");
        System.out.println("\t 5 Exit to Main Menu");
    }

    public static void displayAdminMenu() {
        // displaying admin menu options
        System.out.println("Administrator Menu:");
        System.out.println("\t 1 View Total Revenue");
        System.out.println("\t 2 Most Frequent Operations");
        System.out.println("\t 3 Exit to Main Menu");
    }

    public static void displayUsersAccounts(Member user1, Member user2, Member user3) {
        // print usernames and ids
        System.out.println("Log in to your user:");
        System.out.println("\t 1 id: " + user1.getId() + " name: " + user1.getName());
        System.out.println("\t 2 id: " + user2.getId() + " name: " + user2.getName());
        System.out.println("\t 3 id: " + user3.getId() + " name: " + user3.getName());
    }

    // handles input for 1 to 9 choices
    public static int takeChoiceInput(int numOfOptions) {
        char choice;
        String raw;

        while (true) {
            System.out.print("Choose an option: ");
            raw = input.next();

            choice = raw.charAt(0);



            for (int i = 1; i <= numOfOptions && raw.length() == 1; i++) {
                if (("" + i).indexOf(choice) == 0) {
                    return i;
                }
            }

            // invalid input message
            System.out.println("\t Invalid input. Please enter an integer between 1 and " + numOfOptions);
        } 
    }
    // admin View revenue
    public static void adminViewRevenue() {
        System.out.printf("\t The total revenue made is: %.2f %n", Member.TotalRevenue);
    }
    // Most frequent operation
    public static void adminMostFrequent () {
        // getting the maximum value 
        int max = Member.TotalBorrows;

        if (Member.TotalReturns > max) {
            max = Member.TotalReturns;
        }

        if (Member.TotalViewBorrowed > max) {
            max = Member.TotalViewBorrowed;
        }

        System.out.println("The most used operations with " + max + " usages each are: ");
        if (Member.TotalBorrows == max) {
            System.out.println("Borrowing");
        }
        if (Member.TotalReturns == max) {
            System.out.println("Returning");
        }
        if (Member.TotalViewBorrowed == max) {
            System.out.println("Viewing Borrowed books");
        }
    }
}