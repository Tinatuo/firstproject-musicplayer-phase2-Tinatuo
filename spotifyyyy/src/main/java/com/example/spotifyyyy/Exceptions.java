package com.example.spotifyyyy;

public class Exceptions {

}
 class FailedLoginException extends Exception {
    public FailedLoginException(String message){
        super(message);
    }
}
 class FreeAccountLimitException extends Exception {
    public FreeAccountLimitException() {
        super("Free account limit exception");
    }
}
class InvalidFormatException extends Exception {
    public InvalidFormatException(){
        super("Invalid format");
    }
}
class LackOfCredit extends Exception{
    public LackOfCredit(){
        super("your credit is not enough");
    }
}
class UserNotFoundException extends FailedLoginException{
    public UserNotFoundException(){
        super("User not found");
    }
}
class WrongPasswordException extends FailedLoginException{
    public WrongPasswordException(){
        super("Wrong password");
    }
}