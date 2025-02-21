package view;

import model.User;

public class introview {
    public introview()
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                     Broad Band Service Provider Application                       ");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(" ---------------------------- ");
        System.out.println("|    SERVCIES       |    NO.  |");
        System.out.println("|-----------------------------|");
        System.out.println("|    REGISTER       |    1    |");
        System.out.println("|-----------------------------|");
        System.out.println("|    LOGIN          |    2    |");
        System.out.println("|-----------------------------|");
        System.out.println("|    ABOUT US       |    3    |");
        System.out.println("|-----------------------------|");
    }

    public void serviceViews(User user)
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                     Broad Band Service Provider Application     Logged in as "+user.NAME);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(" ---------------------------- ");
        System.out.println("|    VIEW PLANS     |    1    |");
        System.out.println("|-----------------------------|");
        System.out.println("|    SETTINGS       |    2    |");
        System.out.println("|-----------------------------|");
        System.out.println("|    LOGOUT         |    3    |");
        System.out.println("|-----------------------------|");
    }

    public static void aboutus()
    {
        System.out.println("-----------------------------------------------------------------------------------");
        System.out.println("                     Broad Band Service Provider Application                       ");
        System.out.println();
        System.out.println("------------------------------------ABOUT US---------------------------------------");
        System.out.println();
        System.out.println("| Broad Band Service Provider Application is a leading broadband service provider in India   |");
    }

    public static void plansViwe()
    {
        System.out.println(" --------------------------------- ");
        System.out.println("|    PLANS   | PRICE    |    NO.  |");
        System.out.println("|---------------------------------|");
        System.out.println("|    10MB/S  | 250      |    1    |");
        System.out.println("|---------------------------------|");
        System.out.println("|    20MB/S  | 450      |    2    |");
        System.out.println("|---------------------------------|");
        System.out.println("|    100MB/S | 1000     |    3    |");
        System.out.println("|---------------------------------|");
    }

}
