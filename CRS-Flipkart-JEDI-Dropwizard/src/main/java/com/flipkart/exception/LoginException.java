package com.flipkart.exception;

public class LoginException extends Exception{
    private int userId;

    public LoginException(int userId) {
        this.userId = userId;
    }

    @Override
    public String getMessage() {
        return "UserId/password Incorrect for " + this.userId ;
    }
}
