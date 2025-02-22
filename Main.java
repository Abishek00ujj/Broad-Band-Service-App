import controller.Bill;
import controller.User_methods;
import model.User;
import model.plans;
import view.*;

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
                int x = Integer.parseInt(sc.nextLine());
                if (x == 0)
                {
                    break;
                }
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
                    int x1 = Integer.parseInt(sc.nextLine());
                    if (x1 == 1)
                    {
                        introview.plansViwe();
                        ArrayList<plans> plan = new ArrayList<>();
                        plan.add(new plans("p1", "silver", "250", "10mb/s"));
                        plan.add(new plans("p2", "gold", "450", "20mb/s"));
                        plan.add(new plans("p3", "diamond", "1000", "100mb/s"));

//                        for(plans p:plan) {
//                            System.out.println(p.planDetails);
//                        }

                        System.out.println("ENTER YOUR OPTION:");

                        int op = Integer.parseInt(sc.nextLine());
                        if(op<1 || op>plan.size())
                        {
                            System.out.println("INVALID OPTION!");
                            break;
                        }
                        else {
                            Bill bill = new Bill();
                            if (bill.isSubAlive(userData.P_NO)) {
                                System.out.println("");
                                plans pl = bill.subcribeDetails(userData.P_NO);
                                System.out.println("Hey " + userData.NAME + " Currently you have been already an active subscription");
                                System.out.println("PLAN DETAILS : " + pl.planDetails);
                                System.out.println("PLAN SPEED : " + pl.speed);
                                break;
                            }
                            bill.generate_bill(plan.get(op-1), userData.P_NO);
                            System.out.println("Please type CONFIRM to pay");
                            String payment = sc.nextLine();
                            if (payment.equals("CONFIRM") || payment.equals("confirm")) {
                                bill.pay(plan.get(op-1), userData.P_NO);
                                System.out.println("PAID SUCCUESSFULLY!");
                                break;
                            } else {
                                System.out.println("PLEASE TRY AGAIN LATER!");
                                break;
                            }
                        }
                    }
                    else if (x1 == 2)
                    {
                        System.out.println("Settings");

                        introview.settings_view();
                        int q=sc.nextInt();
                        sc.nextLine();
                        if(q==1)
                        {

                            Bill bill = new Bill();
                            if(bill.isSubAlive(userData.P_NO)) {
                                bill.view_subscription(userData.P_NO);
                            }
                            else {
                                System.out.println("you don't have any subscriptions yet!");
                                System.out.println("Go back to home and subscribe!");
                                break;
                            }
                        }
                        else if(q==2)
                        {
                            Bill bill=new Bill();
                            if(bill.isSubAlive(userData.P_NO)) {
                                bill.viewbill(userData.P_NO);
                            }
                            else {
                                System.out.println("you don't have any subscriptions yet!");
                                System.out.println("Go back to home and subscribe!");
                                break;
                            }
                        }
                        else {
                            break;
                        }
                    }
                    else if (x1 == 3)
                    {
                        flagLogin = 0;
                        System.out.println(userData.NAME + " is Logged out!");
                        userData = null;
                        break;
                    }
                    else if(x1==4)
                    {
                        System.out.println("FEEDBACK----------------");
                        System.out.println("ENTER YOUR FEEDBACKS: ");
                        String feedback=sc.nextLine();
                        if(!feedback.isEmpty())
                        {
                            System.out.println("THANKS FOR YOUR FEEDBACK!");
                        }
                        else
                        {
                            System.out.println("SOME TECHNICAL ERROR! PLEASE TRY AGAIN LATER!");
                            break;
                        }
                    }
                }
            }
        }
    }
}
