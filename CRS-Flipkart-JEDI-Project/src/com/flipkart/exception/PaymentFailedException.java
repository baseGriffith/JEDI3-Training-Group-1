package com.flipkart.exception;

public class PaymentFailedException extends Exception{
    private int studentId;

    public PaymentFailedException(int studentId) {
        this.studentId = studentId;
    }

    @Override
    public String getMessage() {
        return "Payment for student " + this.studentId + " failed!";
    }
}
