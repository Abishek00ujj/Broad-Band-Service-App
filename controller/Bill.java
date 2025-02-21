package controller;

import model.User;
import model.plans;
import controller.User_methods;
import static controller.User_methods.addUser;

import java.util.Date;

import java.util.LinkedHashMap;
import java.util.Map;

public class Bill {
    static LinkedHashMap<plans,String> bill=new LinkedHashMap<>();

   static LinkedHashMap<String,plans> CurrentSubscription=new LinkedHashMap<>();


    public void generate_bill(plans plans,String phoneno)
    {
        System.out.println("--------------------BILL--------------------");
        System.out.println("bill no: "+Math.random()%10*10);
        System.out.println(new Date().getTime());
        System.out.println("Thank you for choosing us.");
        System.out.println("you have choosed "+plans.speed);
        System.out.println(plans.planDetails);
        System.out.println("Total cost: "+plans.cost);
    }
    public boolean pay(plans plans,String phoneno)
    {
        bill.put(plans,phoneno);
        CurrentSubscription.put(phoneno,plans);
        return true;
    }

    public boolean isSubAlive(String phoneno)
    {
        return CurrentSubscription.containsKey(phoneno);
    }

    public plans subcribeDetails(String phoneno)
    {
        return CurrentSubscription.get(phoneno);
    }
//    public void view_subscription(String id)
//    {
//        for(Map.Entry<plans,String> e: bill.entrySet())
//        {
//            if(e.getValue().equals(id)) {
//                plans p = e.getKey();
//                System.out.println();
//                System.out.println(p.planDetails);
//                System.out.println("GET USER DETAILS!");
//                System.out.println("ENTER THE PHONE NUMBER");
//                String phonon = id;
//                if (userMethods.isUser(phonon)) {
//                    user = userMethods.getUser(phonon);
//                    System.out.println(user.NAME);
//                    System.out.println(user.P_NO);
//                }
//            }
//
//    }
}
