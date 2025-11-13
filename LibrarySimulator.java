import java.util.Scanner;

public class LibrarySimulator {
    // initializing input Scanner
    public static Scanner input = new Scanner(System.in);

    public static void main (String[] args) {

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

    public static void displayNamesAndIds(Member user1, Member user2, Member user3) {
        // print usernames and ids
        System.out.println("Log in to your user:");
        System.out.println("\t 1 id: " + user1.getId() + " name: " + user1.getName());
        System.out.println("\t 2 id: " + user2.getId() + " name: " + user2.getName());
        System.out.println("\t 3 id: " + user3.getId()+ " name: " + user3.getName());
    }

    public static int takeChoiceInput(int numOfOptions) {
        int choice = 1;

        do {
            System.out.print("Choose an option: ");
            choice = input.nextInt();
            
            // invalid input message
            if (choice < 1 || choice > numOfOptions) {
                System.out.println("\t Invalid input. Please enter an integer between 1 and " + numOfOptions);
            }
            
        } while (choice < 1 || choice > numOfOptions);
   
        return choice;
    }
}