package controller;
import model.User;

import java.util.LinkedHashMap;

public class User_methods
{
    static LinkedHashMap<String,User> storage=new LinkedHashMap<>();
    public static boolean addUser(User user)
    {
        storage.put(user.P_NO,user);
        return true;
    }

    public User getUser(String id)
    {
        return storage.get(id);
    }

    public boolean isUser(String id)
    {
        return storage.containsKey(id);
    }

    public boolean login(String phoneno,String password)
    {
        User user=getUser(phoneno);

        if(password.equals(user.PASSWORD))
        {
            return true;
        }
        return false;
    }


    public boolean edit_name(User user,String newName)
    {
        user.NAME=newName;
        storage.put(user.P_NO,user);
        return true;
    }

    public boolean edit_password(User user,String newPassword)
    {
        user.PASSWORD=newPassword;
        storage.put(user.P_NO,user);
        return true;
    }


    public boolean edit_email(User user,String newEmail)
    {
        user.EMAIL=newEmail;
        storage.put(user.P_NO, user);
        return true;
    }
}
