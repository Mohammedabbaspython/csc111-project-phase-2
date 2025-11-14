public class Member {
    // declaring the private attributes
    // user info + borrowed (should never reset)
    private int id;
    private String name;
    private int borrowedCount;
    // session statistics (should reset)
    private int numViewBorrowed;
    private int numBorrows;
    private int numReturns;
    private double sessionFees;
    // declaring the Static attributes for admin statistics
    public static double TotalRevenue;
    public static int TotalViewBorrowed;
    public static int TotalBorrows;
    public static int TotalReturns;

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    // Getters
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getBorrowedCount() {
        return this.borrowedCount;
    }

    //lets the user check how many books they currently have borrowed
    public void ViewBorrowedCount()
    {
        System.out.println("You are currently borrowing " + borrowedCount + " books.");
        ++numViewBorrowed;
        ++TotalViewBorrowed;
    }

    //lets the user check their session statistics
    public void DisplayStatistics()
    {
        System.out.println("Session Summary:");
        System.out.println("\tBorrowed Books: " + this.numBorrows);
        System.out.println("\tReturned Books: " + this.numReturns);
        System.out.println("\tTotal fees incurred: " + this.sessionFees);
        System.out.println("\tYou've checked your borrows " + numViewBorrowed + " times.");
    }

    //resets the users session statistics
    public void reset()
    {
        this.numBorrows = 0;
        this.numReturns = 0;
        this.sessionFees = 0;
        this.numReturns = 0;
    }
}
