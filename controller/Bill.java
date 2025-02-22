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
        System.out.println("bill no: "+Math.random()%10);
        System.out.println("DATE : "+new Date());
        System.out.println("Thank you for choosing us.");
        System.out.println("you have choosed "+plans.speed);
        System.out.println("OPTED PLAN NAME : "+plans.planDetails);
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
        System.out.println("USER NAME : "+user.NAME);
        System.out.println("EMAIL : "+user.EMAIL);
        System.out.println("PLAN ID : "+pl.planId);
        System.out.println("PLAN DETAILS : "+pl.planDetails);
        System.out.println("PLAN COST : "+pl.cost);
        System.out.println("INTERNET SPEED : "+pl.speed);
    }

    public void viewbill(String id)
    {
        plans pl=CurrentSubscription.get(id);
        System.out.println("--------------------BILL--------------------");
        System.out.println("bill no: "+Math.random()/10*100+56);
        System.out.println(new Date());
        System.out.println("Thank you for choosing us.");
        System.out.println("you have choosed "+pl.speed);
        System.out.println("OPTED PLAN NAME : "+pl.planDetails);
        System.out.println("Total cost: "+pl.cost);
    }
}
