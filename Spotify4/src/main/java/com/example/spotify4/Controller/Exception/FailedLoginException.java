package com.example.spotify4.Controller.Exception;

public class FailedLoginException extends Exception {
    public FailedLoginException(String message){
        super(message);
    }
}
