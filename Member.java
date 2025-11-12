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


    
}
