package com.flipkart.constants;

public enum GradeConstants {
    A(10),
    B(9),
    C(8),
    D(7),
    E(6),
    F(5);

    final private int value;

    /**
     * Constructor to initilase the grade value
     * @param value
     */
    private GradeConstants(int value) {
        this.value = value;
    }

    /**
     * Method to get Grade Value
     * @return Grade Value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Method to convert Grade enum to String
     * @return Grade in String
     */
    @Override
    public String toString() {             
        return name();
    }

}