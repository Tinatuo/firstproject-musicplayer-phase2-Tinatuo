package com.example.spotify4.Controller;

import com.example.spotify4.Controller.Exception.InvalidFormatException;
import com.example.spotify4.Controller.Exception.UserNotFoundException;
import com.example.spotify4.Controller.Exception.WrongPasswordException;

public  class UserController {
    public static UserController userController;
    public static UserController getUserController() {
        if (userController == null)
            userController = new UserController();
        return userController;
    }
    public  String signUp(String userName, String password, String firstAndLastname,String email, String phoneNumber, int year, int mounth, int day,String biography) throws WrongPasswordException, InvalidFormatException { String string=null;
        return string;};
    public String logIn(String userName, String password) throws UserNotFoundException {
        String string=null;
        return string;
    };
    public  String showUserInfo(){  String string=null;
        return string;}
}
