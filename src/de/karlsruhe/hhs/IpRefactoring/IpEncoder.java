package de.karlsruhe.hhs.IpRefactoring;

import de.karlsruhe.hhs.Calculator;

public class IpEncoder {

    private String ip;
    private Calculator calculator;

    public IpEncoder(String ip) {
        this.ip = ip;
        calculator = new Calculator(16);
    }

    public IpEncoder(String ip, int bitsToRepresent) {
        this.ip = ip;
        calculator = new Calculator(bitsToRepresent);
    }

    public String encode() {
        var ipParts = ip.split("\\.",4);
        var ipAsBinary = "";
        for (var part : ipParts) {
            var octetDigitObject = calculator.binaryEncoder(part);
            var octet =  octetDigitObject.getBinary();
            ipAsBinary += octet + ".";
        }
        ipAsBinary = ipAsBinary.substring(0, ipAsBinary.length() - 1);
        return ipAsBinary;
    }
}
