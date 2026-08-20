package com.example.spotify4.Controller.Exception;

public class FreeAccountLimitException extends Exception {
    public FreeAccountLimitException() {
        super("Free account limit exception");
    }
}
