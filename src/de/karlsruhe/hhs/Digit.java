package de.karlsruhe.hhs;

public class Digit {
    String binaryPresentation;
    String decimalPresentation;

    public Digit(String binary, String decimal) {
        this.binaryPresentation = binary;
        this.decimalPresentation = decimal;
    }

    public String getBinary() {
        return this.binaryPresentation;
    }

    public String getDecimal() {
        return this.decimalPresentation;
    }

}
