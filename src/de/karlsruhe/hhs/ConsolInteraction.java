package de.karlsruhe.hhs;

import java.text.MessageFormat;
import java.util.Scanner;


public class ConsolInteraction {
	
	private Calculator calculator = new Calculator(16);
	private final String startingMeassage = "Please choose if you like to enter a binary(1) or a decimal(2) digit: ";
	private final String errorMessage = "Your format was incorreced and the interaction has ended. Feel free to try again.";
	private final String resultMessage = "You entered {0}, to the base {1} and in the two’s complement this is {2}.";
	private final short SHORT_MIN = Short.MIN_VALUE;
	private final short SHORT_MAX = Short.MAX_VALUE;
	private final String enterBinaryMeassage = "Please enter a binary with up to 16 byte: ";
	private final String enterDecimalMessage = MessageFormat.format("Please enter a decimal digit (by limit yourself to the range of {0} to {1}): ",SHORT_MIN, SHORT_MAX);
	private Base base;
	
	public static void main (String[] args) {
		ConsolInteraction ci = new ConsolInteraction();
		ci.startInteraction();
		
	}
	
	private void startInteraction() {
		System.out.print(startingMeassage);
		boolean isFormatCorrect;
		String choice = readLine();
		
		if (choice.equals("1")) {
			base = Base.TEN;
			System.out.print(requestToEnterDigit(base));
			String digit = readLine();
			isFormatCorrect = binaryToDecimalFormatCheck(digit);
			if (isFormatCorrect) {
				System.out.println(binaryToDecimalFormatter(digit));
			} else {
				System.out.println(errorMessage);
			}
		} else if (choice.equals("2")) {
			base = Base.TWO;
			System.out.print(requestToEnterDigit(base));
			String digit = readLine();
			isFormatCorrect = decimalToBinaryFormatCheck(digit);
			if (isFormatCorrect) {
				System.out.println(decimalToBinaryFormatter(digit));
			} else {
				System.out.println(errorMessage);
			}
		} else {
			System.out.println(errorMessage);
		}
		
	}
	
	private boolean binaryToDecimalFormatCheck(String digit) {
		if (!digit.matches("[0-1]{1,16}")) {
			return false;
		}
		return true;
		
	}

	private boolean decimalToBinaryFormatCheck(String digit) {
		if (!digit.matches("-?[0-9]{1,5}") || digit.matches("-[0]{1,5}")) {
			return false;
		}
		int number = Integer.valueOf(digit);
		if (number < SHORT_MIN || number > SHORT_MAX) {
			return false;
		}
		return true;

	}
	
	private String binaryToDecimalFormatter(String digit) {
		Digit answer = calculator.binaryDecoder(digit);
		return MessageFormat.format(resultMessage, answer.getBinary(), base.toString().toLowerCase(), answer.getDecimal());
	}
	
	private String decimalToBinaryFormatter(String digit) {
		Digit answer = calculator.binaryEncoder(digit);
		String binary = answer.getBinary();
		binary = MessageFormat.format("{0} {1}", binary.substring(0,8), binary.substring(8,16));
		return MessageFormat.format(resultMessage, answer.getDecimal(), base.toString().toLowerCase(), binary);
	}
	
	private String requestToEnterDigit(Base base) {
		if (!(base == Base.TWO)) {
			return enterBinaryMeassage;
		} else {
			return enterDecimalMessage;
		}
	}
	
	private String readLine() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
		
	}

}
