package com.example.spotify4.Controller.Exception;

public class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException(){
        super("User not found");
    }
}
