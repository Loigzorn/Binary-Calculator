package de.karlsruhe.hhs;

import java.util.LinkedList;

public class Calculator {

    private int bits;
    private LinkedList<Integer> fifoOfDigit = new LinkedList<Integer>();

    public Calculator() {
        this.bits = 16;
    }

    public Calculator(int bitsToRepresent) {
        this.bits = bitsToRepresent;
    }

    public Digit binaryDecoder(String binary) {
        int decimal = 0;
        String sign = binary.substring(0,1);
        if (sign.equals("1")) {
            sign = "-";
            decimal = (int) Math.pow(2,(binary.length() -1));
            int tooMuch = analyseBinary(binary.substring(1,binary.length()));
            decimal -= tooMuch;
        } else {
            sign = "";
            decimal = analyseBinary(binary);

        }
        Digit result = new Digit(binary, sign + Integer.toString(decimal));
        return result;
    }

    public Digit binaryEncoder(String decimal) {
        String binary = "";
        String sign = decimal.substring(0,1);
        if (sign.equals("-")) {
            int decimalAsInt = Integer.valueOf(decimal.substring(1,decimal.length()));
            binary = analyseDecimal(decimalAsInt, 1);
        } else {
            int decimalAsInt = Integer.valueOf(decimal);
            binary = analyseDecimal(decimalAsInt, 0);
        }
        Digit result = new Digit(binary, decimal);
        return result;
    }

    private int analyseBinary(String binary) {
        int decimal = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.substring(i, i + 1).equals("1")) {
                int power = (int) Math.pow(2,(binary.length() -1) -i);
                decimal += power;
            }
        }
        return decimal;
    }

    private String analyseDecimal(int decimal, int sign) {
        int remaining;
        while (decimal > 0) {
            remaining = decimal % 2;
            fifoOfDigit.add(remaining);
            decimal >>= 1;
        }
        if (sign == 1) {
            bitFlippingForNegativDecimals();
        }

        int missingLength = bits - fifoOfDigit.size();
        String binary = addMissingLengthToBinary(missingLength, sign);

        while (!fifoOfDigit.isEmpty()) {
            binary += fifoOfDigit.removeLast();
        }
        return binary;
    }

    private void bitFlippingForNegativDecimals() {
        for (int i = 0; i < fifoOfDigit.size(); i++) {
            if (fifoOfDigit.get(i) == 1) {
                fifoOfDigit.set(i, 0);
            } else {
                fifoOfDigit.set(i, 1);
            }
        }

        int index = 0;
        while(index < fifoOfDigit.size()) {
            int bit = fifoOfDigit.get(index);
            if (bit == 1) {
                fifoOfDigit.set(index, 0);
                index++;
            } else {
                fifoOfDigit.set(index, 1);
                break;
            }
        }
    }

    private String addMissingLengthToBinary(int missingLength, int sign) {
        String binary = "";
        for (int i = missingLength; i > 0; i--) {
            binary += sign;
        }
        return binary;
    }

}
