package controller;

import model.User;
import model.plans;
import controller.User_methods;
import static controller.User_methods.addUser;

import java.sql.SQLOutput;
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
    public void view_subscription(String phoneno)
    {
        plans pl=CurrentSubscription.get(phoneno);
        User_methods userMethods=new User_methods();
        User user=userMethods.getUser(phoneno);
        System.out.println("SUBSCRIPTION  DETAILS!");
        System.out.println(user.NAME);
        System.out.println(user.EMAIL);
        System.out.println(pl.planId);
        System.out.println(pl.planDetails);
        System.out.println(pl.cost);
        System.out.println(pl.speed);
    }

}
