package de.karlsruhe.hhs;

import java.text.MessageFormat;
import java.util.Scanner;

public class Calculator {
	private static Calculator cal = new Calculator();
	
	public static void main (String[] args) {
		String mes = "Please choose if you would like to enter a binary(1) or a decimal(2) digit (\'end\' to exit program): ";
		String choice = "";
		System.out.print(mes);
		
		choice = cal.readLine();
		if (choice.equals("1")) {
			System.out.println(MessageFormat.format("Your binary digit you entered is {0} to the base ten.", binary()));
		} else if (choice.equals("2")) {
			decimal();
		} else if (choice.equals("end") || choice.equals("End")) {
			;
		} else {
			System.out.print("Try again. ");	
			main(args);
		}
		
	}
	
	private static String binary() {
		System.out.print("Please enter a 8 byte binary digit: ");
		String digit = cal.readLine();
		String output = "";
		int intOfOutput = 0;
			
		if (digit.matches("[0-1]{8}")) {
			String plusMinus = digit.substring(0,1);
			if (plusMinus.equals("1")) {
				output = "-";
				intOfOutput += 1;
			}
			for (int i = 1; i < digit.length(); i++) {
				if (digit.substring(i, i+1).equals("1")) {
					intOfOutput += Integer.valueOf(digit.substring(i, (i + 1))) * (int)Math.pow(2,(digit.length() -1) -i);
				} else continue;
				
			}
			/*for (int i = 6; i >= 0; i--) {
				for (int j = 1; j < 8; j++) {
					if (digit.substring(j, j+1).equals("1")) {
						System.out.println(j);
						System.out.println(intOfOutput);
						intOfOutput = intOfOutput + (int)Math.pow(2, i);
						System.out.println("MathPower: " + Math.pow(2, i));
					} else continue;
				}
			}*/
			output = output + intOfOutput;
			
		} else {
			System.out.print("Try again. ");
			binary();
		}
		return output;
		
	}
	
	private static void decimal() {
		String decimal = cal.readLine();
		
		
	}
	
	public String readLine() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		//sc.close();
		return input;
	}

}
