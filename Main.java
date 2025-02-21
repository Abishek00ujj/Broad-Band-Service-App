import controller.Bill;
import controller.User_methods;
import model.User;
import model.plans;
import view.*;

import java.sql.SQLOutput;
import java.util.*;

import static controller.User_methods.addUser;

public class Main
{
    public static void main(String[] args)
    {
        User userData = null;
        int flagLogin=0;
        introview vi=new introview();
        Scanner sc=new Scanner(System.in);
        User_methods userMethods=new User_methods();
        while(true)
        {
            if (flagLogin == 0)
            {
                vi = new introview();
                System.out.println("ENTER THE OPTION:");
                int x = sc.nextInt();
                if (x == 0)
                {
                    break;
                }
                sc.nextLine();
                if (x == 1)
                {
                    System.out.println("-------------------REGISTER-------------------");

                    System.out.println("ENTER YOUR NAME:");
                    String name = sc.nextLine();
                    System.out.println("ENTER YOUR PHONE NUMBER:");
                    String phoneno = sc.nextLine();
                    if (userMethods.isUser(phoneno))
                    {
                        System.out.println("USER ALREADY EXISTS!");
                        System.out.println("KINDLY GO TO LOGIN!");
                    }
                    System.out.println("ENTER YOUR EMAIL:");
                    String email = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD:");
                    String password = sc.nextLine();
                    System.out.println("RE-ENTER YOUR PASSWORD:");
                    String password1 = sc.nextLine();
                    if (password1.equals(password))
                    {
                        User user = new User(name, phoneno, email, password);
                        addUser(user);
                        System.out.println("USER REGISTERED SUCCUESSFULLY!");
                    }
                    else
                    {
                        System.out.println("PASSWORDS NOT MATCHED");
                    }
                }
//                else if (x == 2)
//                {
//                    System.out.println("GET USER DETAILS!");
//                    System.out.println("ENTER THE PHONE NUMBER");
//                    String phonon = sc.nextLine();
//                    User user;
//                    if (userMethods.isUser(phonon))
//                    {
//                        user = userMethods.getUser(phonon);
//                        System.out.println(user.NAME);
//                        System.out.println(user.P_NO);
//                    }
//                    else
//                    {
//                        System.out.println("NOT FOUND!");
//                    }
//                }
                else if (x == 2)
                {
                    System.out.println("------------------------LOGIN-----------------------------");
                    System.out.println("ENTER YOUR PHONE NUMBER:");
                    String phoneno = sc.nextLine();
                    System.out.println("ENTER YOUR PASSWORD:");
                    String password = sc.nextLine();
                    if (!userMethods.isUser(phoneno))
                    {
                        System.out.println("User not found!");
                    }
                    else
                    {
                        if (userMethods.login(phoneno, password))
                        {
                            flagLogin = 1;
                            System.out.println("USER LOGGED IN SUCCUESSFULLY!");
                            userData = userMethods.getUser(phoneno);
                            System.out.println("LOGGED IN AS " + userData.NAME);
                        }
                    }
                }
                else if (x == 3)
                {
                    introview.aboutus();
                }
            }
            else
            {
                System.out.println("HOME");
                vi.serviceViews(userData);
                while (true)
                {
                    System.out.println("ENTER THE OPTION:");
                    int x1 = sc.nextInt();
                    sc.nextLine();
                    if (x1 == 1)
                    {
                        introview.plansViwe();
                        ArrayList<plans> plan = new ArrayList<>();
                        plan.add(new plans("p1", "silver", "250", "10mb/s"));
                        plan.add(new plans("p2", "gold", "450", "20mb/s"));
                        plan.add(new plans("p3", "diamond", "1000", "100mb/s"));

                        System.out.println("ENTER YOUR OPTION:");

                        int op = sc.nextInt();
                        sc.nextLine();

                        if (op == 1)
                        {
                            Bill bill = new Bill();
                            bill.generate_bill(plan.get(0), userData.P_NO);
                            System.out.println("Please type CONFIRM to pay");
                            String payment = sc.nextLine();
                            if (payment.equals("CONFIRM") || payment.equals("confirm")) {
                                bill.pay(plan.get(0), userData.P_NO);
                                System.out.println("PAID SUCCUESSFULLY!");
                                break;
                            }
                        }
                        else if (op == 2)
                        {
                            Bill bill = new Bill();
                            bill.generate_bill(plan.get(1), userData.P_NO);
                            System.out.println("Please type CONFIRM to pay");
                            String payment = sc.nextLine();
                            if (payment.equals("CONFIRM") || payment.equals("confirm"))
                            {
                                bill.pay(plan.get(1), userData.P_NO);
                                System.out.println("PAID SUCCUESSFULLY!");
                                break;
                            }
                        }
                        else if (op == 3)
                        {
                            Bill bill = new Bill();
                            if(bill.isSubAlive(userData.P_NO))
                            {
                                System.out.println("");
                                plans pl=bill.subcribeDetails(userData.P_NO);
                                System.out.println("Hey "+userData.NAME+" Currently you have been already an active subscription");
                                System.out.println("PLAN DETAILS : "+pl.planDetails);
                                System.out.println("PLAN SPEED : "+pl.speed);
                                break;
                            }
                            bill.generate_bill(plan.get(2), userData.P_NO);
                            System.out.println("Please type CONFIRM to pay");
                            String payment = sc.nextLine();
                            if (payment.equals("CONFIRM") || payment.equals("confirm"))
                            {
                                bill.pay(plan.get(2), userData.P_NO);
                                System.out.println("PAID SUCCUESSFULLY!");
                                break;
                            }
                        }
                        else
                        {
                            System.out.println("PLEASE CHOOSE THE CORRECT OPTION!");
                        }
                    }
                    else if (x1 == 2)
                    {
                        System.out.println("Settings");
                    }
                    else if (x1 == 3)
                    {
                        flagLogin = 0;
                        System.out.println(userData.NAME + " is Logged out!");
                        userData = null;
                        break;
                    }
                }
            }
        }
    }
}
