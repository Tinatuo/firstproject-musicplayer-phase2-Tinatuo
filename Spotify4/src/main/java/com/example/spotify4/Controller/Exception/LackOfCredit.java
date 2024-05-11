package com.example.spotify4.Controller.Exception;

public class LackOfCredit extends Exception{
    public LackOfCredit(){
        super("your credit is not enough");
    }
}
