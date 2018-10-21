package de.karlsruhe.hhs.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import de.karlsruhe.hhs.Calculator;
import de.karlsruhe.hhs.Digit;

public class BinaryCalculatorTesting {

	@Test
	public void binaryEncoderTester() {
		Calculator cal = new Calculator();
		Digit digit = new Digit("00000000 00000001", "1");
		//assertEquals("expected 1", digit, cal.binaryEncoder("1"));
	}

}
