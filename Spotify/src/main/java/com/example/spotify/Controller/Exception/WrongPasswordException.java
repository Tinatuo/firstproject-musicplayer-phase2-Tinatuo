package com.example.spotify4.Controller.Exception;

public class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException(){
        super("Wrong password");
    }
}
