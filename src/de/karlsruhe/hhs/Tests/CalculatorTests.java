package de.karlsruhe.hhs.Tests;

import static org.junit.jupiter.api.Assertions.*;

import de.karlsruhe.hhs.Calculator;
import de.karlsruhe.hhs.Digit;
import org.junit.jupiter.api.Test;

class CalculatorTests {

    private Calculator calculatorTest = new Calculator(16);

    @Test
    void encodeOneTest() {
        Digit result = calculatorTest.binaryEncoder("1");
        assertEquals("1", result.getDecimal());
        assertEquals("0000000000000001", result.getBinary());
    }

    @Test
    void decodeOneWithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("0000000000000001");
        assertEquals("1", result.getDecimal());
        assertEquals("0000000000000001", result.getBinary());
    }

    @Test
    void decodeOneWithBitLengthOfEightTest() {
        Digit result = calculatorTest.binaryDecoder("00000001");
        assertEquals("1", result.getDecimal());
        assertEquals("00000001", result.getBinary());
    }

    @Test
    void decodeOneWithBitLengthOfTwoTest() {
        Digit result = calculatorTest.binaryDecoder("01");
        assertEquals("1", result.getDecimal());
        assertEquals("01", result.getBinary());
    }

    @Test
    void decodeNegativeOneWithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("1111111111111111");
        assertEquals("-1", result.getDecimal());
        assertEquals("1111111111111111", result.getBinary());
    }

    @Test
    void decodeNegativeOneWithBitLengthOfEightTest() {
        Digit result = calculatorTest.binaryDecoder("11111111");
        assertEquals("-1", result.getDecimal());
        assertEquals("11111111", result.getBinary());
    }

    @Test
    void decodeNegativeOneWithBitLengthOfOneTest() {
        Digit result = calculatorTest.binaryDecoder("1");
        assertEquals("-1", result.getDecimal());
        assertEquals("1", result.getBinary());
    }

    @Test
    void encodeNegativeOneTest() {
        Digit result = calculatorTest.binaryEncoder("-1");
        assertEquals("-1", result.getDecimal());
        assertEquals("1111111111111111", result.getBinary());
    }

    @Test
    void decodeTwoWithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("0000000000000010");
        assertEquals("2", result.getDecimal());
        assertEquals("0000000000000010", result.getBinary());
    }

    @Test
    void decodeTwoWithBitLengthOfEightTest() {
        Digit result = calculatorTest.binaryDecoder("00000010");
        assertEquals("2", result.getDecimal());
        assertEquals("00000010", result.getBinary());
    }

    @Test
    void decodeTwoWithBitLengthOfFourTest() {
        Digit result = calculatorTest.binaryDecoder("0010");
        assertEquals("2", result.getDecimal());
        assertEquals("0010", result.getBinary()); //
    }

    @Test
    void encodeTwoTest() {
        Digit result = calculatorTest.binaryEncoder("2");
        assertEquals("2", result.getDecimal());
        assertEquals("0000000000000010", result.getBinary());
    }

    @Test
    void decodeNegativeTwoWithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("1111111111111110");
        assertEquals("-2", result.getDecimal());
        assertEquals("1111111111111110", result.getBinary());
    }

    @Test
    void decodeNegativeTwoWithBitLengthOfEightTest() {
        Digit result = calculatorTest.binaryDecoder("11111110");
        assertEquals("-2", result.getDecimal());
        assertEquals("11111110", result.getBinary());
    }

    @Test
    void decodeNegativeTwoWithBitLengthOfFourTest() {
        Digit result = calculatorTest.binaryDecoder("1110");
        assertEquals("-2", result.getDecimal());
        assertEquals("1110", result.getBinary());
    }

    @Test
    void encodeNegativeTwoTest() {
        Digit result = calculatorTest.binaryEncoder("-2");
        assertEquals("-2", result.getDecimal());
        assertEquals("1111111111111110", result.getBinary());
    }

    @Test
    void encodeNegativeThreeTest() {
        Digit result = calculatorTest.binaryEncoder("-3");
        assertEquals("-3", result.getDecimal());
        assertEquals("1111111111111101", result.getBinary());
    }

    @Test
    void encodeNegativeFourTest() {
        Digit result = calculatorTest.binaryEncoder("-4");
        assertEquals("-4", result.getDecimal());
        assertEquals("1111111111111100", result.getBinary());
    }

    @Test
    void decodeNegative32768WithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("1000000000000000");
        assertEquals("-32768", result.getDecimal());
        assertEquals("1000000000000000", result.getBinary());
    }

    @Test
    void encodeNegative32768Test() {
        Digit result = calculatorTest.binaryEncoder("-32768");
        assertEquals("-32768", result.getDecimal());
        assertEquals("1000000000000000", result.getBinary()); // is 1000000000000001
    }

    @Test
    void encodeNegative32767Test() {
        Digit result = calculatorTest.binaryEncoder("-32767");
        assertEquals("-32767", result.getDecimal());
        assertEquals("1000000000000001", result.getBinary());
    }

    @Test
    void encodeNegative32766Test() {
        Digit result = calculatorTest.binaryEncoder("-32766");
        assertEquals("-32766", result.getDecimal());
        assertEquals("1000000000000010", result.getBinary());
    }

    @Test
    void encodeNegative32765Test() {
        Digit result = calculatorTest.binaryEncoder("-32765");
        assertEquals("-32765", result.getDecimal());
        assertEquals("1000000000000011", result.getBinary());
    }

    @Test
    void encodeNegative32764Test() {
        Digit result = calculatorTest.binaryEncoder("-32764");
        assertEquals("-32764", result.getDecimal());
        assertEquals("1000000000000100", result.getBinary());
    }

    @Test
    void encode32768Test() {
        Digit result = calculatorTest.binaryEncoder("32767");
        assertEquals(result.getDecimal(), "32767");
        assertEquals(result.getBinary(), "0111111111111111");
    }

    @Test
    void encodeZeroTest() {
        Digit result = calculatorTest.binaryEncoder("0");
        assertEquals(result.getDecimal(), "0");
        assertEquals(result.getBinary(), "0000000000000000");
    }

    @Test
    void encodeZeroWithLengthOfFiveTest() {
        Digit result = calculatorTest.binaryEncoder("00000");
        assertEquals(result.getDecimal(), "00000");
        assertEquals(result.getBinary(), "0000000000000000");
    }

    @Test
    void decodeZeroWithBitLengthOfSixteenTest() {
        Digit result = calculatorTest.binaryDecoder("0000000000000000");
        assertEquals(result.getDecimal(), "0");
        assertEquals(result.getBinary(), "0000000000000000"); //
    }

    @Test
    void decodeNegativeSevenWithBitLengthOfFourTest() {
        Digit result = calculatorTest.binaryDecoder("1001");
        assertEquals(result.getDecimal(), "-7");
        assertEquals(result.getBinary(), "1001"); //
    }

    @Test
    void encodeNegativeSevenTest() {
        Digit result = calculatorTest.binaryEncoder("-7");
        assertEquals("-7", result.getDecimal());
        assertEquals("1111111111111001", result.getBinary()); //
    }

    @Test
    void decode477WithBitLengthOfElevenTest() {
        Digit result = calculatorTest.binaryDecoder("00111011101");
        assertEquals(result.getDecimal(), "477");
        assertEquals(result.getBinary(), "00111011101");
    }

    @Test
    void decode477WithBitLengthOfTenTest() {
        Digit result = calculatorTest.binaryDecoder("0111011101");
        assertEquals(result.getDecimal(), "477");
        assertEquals(result.getBinary(), "0111011101");
    }

    @Test
    void decodeNegative547WithBitLengthOfElevenTest() {
        Digit result = calculatorTest.binaryDecoder("10111011101");
        assertEquals(result.getDecimal(), "-547");
        assertEquals(result.getBinary(), "10111011101");
    }

    @Test
    void decode4181WithBitLengthOfElevenTest() {
        Digit result = calculatorTest.binaryDecoder("0001000001010101");
        assertEquals(result.getDecimal(), "4181");
        assertEquals(result.getBinary(), "0001000001010101");
    }

    @Test
    void encodeNegative547() {
        Digit result = calculatorTest.binaryEncoder("-547");
        assertEquals(result.getDecimal(), "-547");
        assertEquals(result.getBinary(), "1111110111011101");
    }
}
