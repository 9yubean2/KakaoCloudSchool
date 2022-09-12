package org.test.spring.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.test.spring.Calculator;

public class CalculatorTest {

	@Test
	public void testSum() {
		Calculator calc = new Calculator();
		assertEquals(30,calc.sum(10, 20));
	}

}
