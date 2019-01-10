package de.karlsruhe.hhs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTests {
	
	Calculator calculatorTest = new Calculator(16);

	@Test
	void encodeOneTest() {
		Digit result = calculatorTest.binaryEncoder("1");
		assertEquals("1", result.decimalPresentation);
		assertEquals("0000000000000001", result.binaryPresentation);
	}
	
	@Test
	void decodeOneWithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("0000000000000001");
		assertEquals("1", result.decimalPresentation);
		assertEquals("0000000000000001", result.binaryPresentation);
	}
	
	@Test
	void decodeOneWithBitLengthOfEightTest() {
		Digit result = calculatorTest.binaryDecoder("00000001");
		assertEquals("1", result.decimalPresentation);
		assertEquals("00000001", result.binaryPresentation);
	}
	
	@Test
	void decodeOneWithBitLengthOfTwoTest() {
		Digit result = calculatorTest.binaryDecoder("01");
		assertEquals("1", result.decimalPresentation);
		assertEquals("01", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeOneWithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("1111111111111111");
		assertEquals("-1", result.decimalPresentation);
		assertEquals("1111111111111111", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeOneWithBitLengthOfEightTest() {
		Digit result = calculatorTest.binaryDecoder("11111111");
		assertEquals("-1", result.decimalPresentation);
		assertEquals("11111111", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeOneWithBitLengthOfOneTest() {
		Digit result = calculatorTest.binaryDecoder("1");
		assertEquals("-1", result.decimalPresentation);
		assertEquals("1", result.binaryPresentation);
	}
	
	@Test
	void encodeNegativeOneTest() {
		Digit result = calculatorTest.binaryEncoder("-1");
		assertEquals("-1", result.decimalPresentation);
		assertEquals("1111111111111111", result.binaryPresentation);
	}
	
	@Test
	void decodeTwoWithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("0000000000000010");
		assertEquals("2", result.decimalPresentation);
		assertEquals("0000000000000010", result.binaryPresentation);
	}
	
	@Test
	void decodeTwoWithBitLengthOfEightTest() {
		Digit result = calculatorTest.binaryDecoder("00000010");
		assertEquals("2", result.decimalPresentation);
		assertEquals("00000010", result.binaryPresentation);
	}
	
	@Test
	void decodeTwoWithBitLengthOfFourTest() {
		Digit result = calculatorTest.binaryDecoder("0010");
		assertEquals("2", result.decimalPresentation);
		assertEquals("0010", result.binaryPresentation); //
	}
	
	@Test
	void encodeTwoTest() {
		Digit result = calculatorTest.binaryEncoder("2");
		assertEquals("2", result.decimalPresentation);
		assertEquals("0000000000000010", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeTwoWithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("1111111111111110");
		assertEquals("-2", result.decimalPresentation);
		assertEquals("1111111111111110", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeTwoWithBitLengthOfEightTest() {
		Digit result = calculatorTest.binaryDecoder("11111110");
		assertEquals("-2", result.decimalPresentation);
		assertEquals("11111110", result.binaryPresentation);
	}
	
	@Test
	void decodeNegativeTwoWithBitLengthOfFourTest() {
		Digit result = calculatorTest.binaryDecoder("1110");
		assertEquals("-2", result.decimalPresentation);
		assertEquals("1110", result.binaryPresentation);
	}
	
	@Test
	void encodeNegativeTwoTest() {
		Digit result = calculatorTest.binaryEncoder("-2");
		assertEquals("-2", result.decimalPresentation);
		assertEquals("1111111111111110", result.binaryPresentation);
	}
	
	@Test
	void encodeNegativeThreeTest() {
		Digit result = calculatorTest.binaryEncoder("-3");
		assertEquals("-3", result.decimalPresentation);
		assertEquals("1111111111111101", result.binaryPresentation);
	}
	
	@Test
	void encodeNegativeFourTest() {
		Digit result = calculatorTest.binaryEncoder("-4");
		assertEquals("-4", result.decimalPresentation);
		assertEquals("1111111111111100", result.binaryPresentation);
	}
	
	@Test
	void decodeNegative32768WithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("1000000000000000");
		assertEquals("-32768", result.decimalPresentation);
		assertEquals("1000000000000000", result.binaryPresentation);
	}
	
	@Test
	void encodeNegative32768Test() {
		Digit result = calculatorTest.binaryEncoder("-32768");
		assertEquals("-32768", result.decimalPresentation);
		assertEquals("1000000000000000", result.binaryPresentation); // is 1000000000000001
	}
	
	@Test
	void encodeNegative32767Test() {
		Digit result = calculatorTest.binaryEncoder("-32767");
		assertEquals("-32767", result.decimalPresentation);
		assertEquals("1000000000000001", result.binaryPresentation);
	}
	
	@Test
	void encodeNegative32766Test() {
		Digit result = calculatorTest.binaryEncoder("-32766");
		assertEquals("-32766", result.decimalPresentation);
		assertEquals("1000000000000010", result.binaryPresentation);
	}
	
	@Test
	void encodeNegative32765Test() {
		Digit result = calculatorTest.binaryEncoder("-32765");
		assertEquals("-32765", result.decimalPresentation);
		assertEquals("1000000000000011", result.binaryPresentation);
	}
	
	@Test
	void encodeNegative32764Test() {
		Digit result = calculatorTest.binaryEncoder("-32764");
		assertEquals("-32764", result.decimalPresentation);
		assertEquals("1000000000000100", result.binaryPresentation);
	}
	
	@Test
	void encode32768Test() {
		Digit result = calculatorTest.binaryEncoder("32767");
		assertEquals(result.decimalPresentation, "32767");
		assertEquals(result.binaryPresentation, "0111111111111111");
	}
	
	@Test
	void encodeZeroTest() {
		Digit result = calculatorTest.binaryEncoder("0");
		assertEquals(result.decimalPresentation, "0");
		assertEquals(result.binaryPresentation, "0000000000000000");
	}
	
	@Test
	void encodeZeroWithLenghtOfFiveTest() {
		Digit result = calculatorTest.binaryEncoder("00000");
		assertEquals(result.decimalPresentation, "00000");
		assertEquals(result.binaryPresentation, "0000000000000000");
	}
	
	@Test
	void decodeZeroWithBitLengthOfSixteenTest() {
		Digit result = calculatorTest.binaryDecoder("0000000000000000");
		assertEquals(result.decimalPresentation, "0");
		assertEquals(result.binaryPresentation, "0000000000000000"); //
	}
	
	@Test
	void decodeNegativeSevenWithBitLengthOfFourTest() {
		Digit result = calculatorTest.binaryDecoder("1001");
		assertEquals(result.decimalPresentation, "-7");
		assertEquals(result.binaryPresentation, "1001"); //
	}
	
	@Test
	void encodeNegativeSevenTest() {
		Digit result = calculatorTest.binaryEncoder("-7");
		assertEquals("-7", result.decimalPresentation);
		assertEquals("1111111111111001", result.binaryPresentation); //
	}
	
	@Test
	void decode477WithBitLengthOfElevenTest() {
		Digit result = calculatorTest.binaryDecoder("00111011101");
		assertEquals(result.decimalPresentation, "477");
		assertEquals(result.binaryPresentation, "00111011101");
	}
	
	@Test
	void decode477WithBitLengthOfTenTest() {
		Digit result = calculatorTest.binaryDecoder("0111011101");
		assertEquals(result.decimalPresentation, "477");
		assertEquals(result.binaryPresentation, "0111011101");
	}
	
	@Test
	void decodeNegative547WithBitLengthOfElevenTest() {
		Digit result = calculatorTest.binaryDecoder("10111011101");
		assertEquals(result.decimalPresentation, "-547");
		assertEquals(result.binaryPresentation, "10111011101");
	}
	
	@Test
	void decode4181WithBitLengthOfElevenTest() {
		Digit result = calculatorTest.binaryDecoder("0001000001010101");
		assertEquals(result.decimalPresentation, "4181");
		assertEquals(result.binaryPresentation, "0001000001010101");
	}
	
	@Test
	void encodeNegative547() {
		Digit result = calculatorTest.binaryEncoder("-547");
		assertEquals(result.decimalPresentation, "-547");
		assertEquals(result.binaryPresentation, "1111110111011101");
	}
}
