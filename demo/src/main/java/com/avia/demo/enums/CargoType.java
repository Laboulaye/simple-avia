package com.avia.demo.enums;

public enum CargoType {
    BAGGAGE(0),
    CARGO(1);

    private final int numCode;

    CargoType(int numCode) {
        this.numCode = numCode;
    }

    public int getNumCode() {
        return numCode;
    }
}
