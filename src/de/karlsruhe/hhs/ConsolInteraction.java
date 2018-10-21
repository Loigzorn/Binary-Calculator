package de.karlsruhe.hhs;

import java.text.MessageFormat;
import java.util.Scanner;


public class ConsolInteraction {
	
	private Calculator calculator = new Calculator();
	private String mes = "Please choose if you like to enter a binary(1) or a decimal(2) digit ('quit' to exit program): ";
	private String output = "You entered {0}, to the base {1} and in the Two’s Complement this is {2}.";
	private Base base;
	
	public static void main (String[] args) {
		ConsolInteraction ci = new ConsolInteraction();
		ci.startInteraction();
		
	}
	
	private void startInteraction() {
		System.out.print(mes);
		String choice = readLine();
		boolean isFormatCorrect;
		
		if (choice.equals("1")) {
			do {
				base = Base.TEN;
				isFormatCorrect = binaryToDecimal();
			} while (!isFormatCorrect);
		} else if (choice.equals("2")) {
			do {
				base = Base.TWO;
				isFormatCorrect = decimalToBinary();
			} while (!isFormatCorrect);
		} else if (choice.equals("quit")) {
			return;
		} else {
			System.out.print("Try again. ");	
			startInteraction();
		}
		
	}
	
	private boolean binaryToDecimal() {
		System.out.print("Please enter a 8 byte binary digit: ");
		String digit = readLine();
		if (!digit.matches("[0-1]{1,16}")) {
			System.out.print("Try again. ");
			return false;
		}
		Digit answer = calculator.binaryDecoder(digit);
		System.out.println(MessageFormat.format(output, answer.getBinary(), base.toString().toLowerCase(), answer.getDecimal()));
		return true;
		
	}
	
	private boolean decimalToBinary() {
		System.out.print("Please enter a decimal digit (by limit yourself to the range of -32768 to 32767): ");
		String digit = readLine();
		if (!digit.matches("-?[0-9]{1,5}") || digit.matches("-[0]{1,5}")) {
			System.out.print("Try again. ");
			return false;
		}
		int number = Integer.valueOf(digit);
		if (number < -32768 || number > 32767) {
			System.out.print("Try again. ");
			return false;
		}
		Digit answer = calculator.binaryEncoder(digit);
		System.out.println(MessageFormat.format(output, answer.getDecimal(), base.toString().toLowerCase(), answer.getBinary()));
		return true;

	}
	
	private String readLine() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//sc.close();
		System.gc();
		return input;
		
	}

}
