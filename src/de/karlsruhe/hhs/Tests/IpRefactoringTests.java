package de.karlsruhe.hhs.Tests;

import de.karlsruhe.hhs.IpRefactoring.IpDecoder;
import de.karlsruhe.hhs.IpRefactoring.IpEncoder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IpRefactoringTests {

    @Test
    void encodeOneTest() {
        var ipEncoder = new IpEncoder("1.1.1.1");
        var result = ipEncoder.encode();
        var expected = "0000000000000001.0000000000000001.0000000000000001.0000000000000001";
        assertEquals(expected, result);
    }

    @Test
    void encodeOneWith8BitsToRepresentTest() {
        var ipEncoder = new IpEncoder("1.1.1.1", 8);
        var result = ipEncoder.encode();
        var expected = "00000001.00000001.00000001.00000001";
        assertEquals(expected, result);
    }

    @Test
    void encodeOneWith12BitsToRepresentTest() {
        var ipEncoder = new IpEncoder("1.1.1.1", 12);
        var result = ipEncoder.encode();
        var expected = "000000000001.000000000001.000000000001.000000000001";
        assertEquals(expected, result);
    }

    @Test
    void encodeOneWith2BitsToRepresentTest() {
        var ipEncoder = new IpEncoder("1.1.1.1", 2);
        var result = ipEncoder.encode();
        var expected = "01.01.01.01";
        assertEquals(expected, result);
    }

    @Test
    void decodeOneWithBitLengthOfSixteenTest() {
        var ipDecoder = new IpDecoder("0000000000000001.0000000000000001.0000000000000001.0000000000000001");
        var result = ipDecoder.decode();
        var expected = "1.1.1.1";
        assertEquals(expected, result);
    }

    @Test
    void decodeOneWithBitLengthOfEightTest() {
        var ipDecoder = new IpDecoder("00000001.00000001.00000001.00000001");
        var result = ipDecoder.decode();
        var expected = "1.1.1.1";
        assertEquals(expected, result);
    }

    @Test
    void decodeOneWithBitLengthOfTwoTest() {
        var ipDecoder = new IpDecoder("01.01.01.01");
        var result = ipDecoder.decode();
        var expected = "1.1.1.1";
        assertEquals(expected, result);
    }

    @Test
    void decodeTwoWithBitLengthOfSixteenTest() {
        var ipDecoder = new IpDecoder("0000000000000010.0000000000000010.0000000000000010.0000000000000010");
        var result = ipDecoder.decode();
        var expected = "2.2.2.2";
        assertEquals(expected, result);
    }

    @Test
    void decodeTwoWithBitLengthOfEightTest() {
        var ipDecoder = new IpDecoder("00000010.00000010.00000010.00000010");
        var result = ipDecoder.decode();
        var expected = "2.2.2.2";
        assertEquals(expected, result);
    }

    @Test
    void decodeTwoWithBitLengthOfFourTest() {
        var ipDecoder = new IpDecoder("0010.0010.0010.0010");
        var result = ipDecoder.decode();
        var expected = "2.2.2.2";
        assertEquals(expected, result);
    }

    @Test
    void encodeTwoTest() {
        var ipDecoder = new IpEncoder("2.2.2.2");
        var result = ipDecoder.encode();
        var expected = "0000000000000010.0000000000000010.0000000000000010.0000000000000010";
        assertEquals(expected, result);
    }

    // full ipv4 test

    @Test
    void encodeDefaultIPTest() {
        var ipEncoder = new IpEncoder("192.168.2.1");
        var result = ipEncoder.encode();
        var expected = "0000000011000000.0000000010101000.0000000000000010.0000000000000001";
        assertEquals(expected, result);
    }
}
