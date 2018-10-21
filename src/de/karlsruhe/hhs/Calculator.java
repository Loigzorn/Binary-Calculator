package de.karlsruhe.hhs;

import java.util.LinkedList;

public class Calculator {
	private LinkedList<Integer> fifo = new LinkedList<Integer>();
	
	Digit binaryDecoder(String binary) {
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

	Digit binaryEncoder(String decimal) {
		String binary = "";
		if (decimal.substring(0,1).equals("-")) {
			int decimalInt = 1 + Integer.valueOf(decimal.substring(1,decimal.length()));
			binary = analyseDecimal(decimalInt,1);
		} else {
			int decimalInt = Integer.valueOf(decimal);
			binary = analyseDecimal(decimalInt,0);
		}
		Digit result = new Digit(binary, decimal);
		return result;
	}
	
	private int analyseBinary(String binary) {
		int decimal = 0;
		for (int i = 0; i < binary.length(); i++) {
			if (binary.substring(i, i+1).equals("1")) {
				int validity = Integer.valueOf(binary.substring(i, (i + 1)));
				int power = (int) Math.pow(2,(binary.length() -1) -i);
				decimal += validity * power;
			}
		}
		return decimal;
		
	}
	
	private String analyseDecimal(int decimal, int sign) {
		int remaining;
		String binary = "";
		while (decimal > 1) {
			remaining = decimal % 2;
			fifo.add(remaining);
			decimal >>= 1;
		}
		fifo.add(decimal);
		int missingLength = 16  - fifo.size();
		for (int i = missingLength; i > 0; i--) {
			fifo.add(sign);
		}
		while (! fifo.isEmpty()) {
			binary += fifo.removeLast();
		}
		binary = binary.substring(0,8) + " " + binary.substring(8,16);
		return binary;
	}

}
