package de.karlsruhe.hhs.IpRefactoring;

import de.karlsruhe.hhs.Calculator;

public class IpDecoder {

    private String ip;
    private Calculator calculator;

    public IpDecoder(String ip) {
        this.ip = ip;
        calculator = new Calculator(16);
    }

    public IpDecoder(String ip, int bitsToRepresent) {
        this.ip = ip;
        calculator = new Calculator(bitsToRepresent);
    }

    public String decode() {
        var ipParts = ip.split("\\.",4);
        var ipAsDigit = "";
        for (var part : ipParts) {
            var octetDigitObject = calculator.binaryDecoder(part);
            var octet =  octetDigitObject.getDecimal();
            ipAsDigit += octet + ".";
        }
        ipAsDigit = ipAsDigit.substring(0, ipAsDigit.length() - 1);
        return ipAsDigit;
    }
}
