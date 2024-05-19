package com.example.spotify4.Model.User;

public class Admin extends User {
    private static Admin admin;

    private Admin(String userName, String password, String firstAndLastname, String phoneNumber,int year,int mounth,int day,String email,String imageView) {
        super(userName, password, firstAndLastname, phoneNumber, year,mounth,day,email,imageView);
    }

    public static Admin getAdmin(String userName, String password, String firstAndLastname, String phoneNumber,int year,int mounth,int day,String email,String imageView){
        if (admin==null){
            admin=new Admin(userName,password,firstAndLastname,phoneNumber,year,mounth,day,email,imageView);
            return admin;
        } else{
            return admin;
        }
    }
    public static Admin getAdmin(){
        return admin;
    }
    public static Admin admin(){
        return admin;
    }
}
