package com.avia.demo.enums;

public enum WeightUnit {
    KILOGRAM(0, "kg"),
    POUND(1, "lb");

    private final int numCode;
    private final String stringCode;

    WeightUnit(int numCode, String stringCode) {
        this.numCode = numCode;
        this.stringCode = stringCode;
    }

    public int getNumCode() {
        return numCode;
    }

    public String getStringCode() {
        return stringCode;
    }
}
