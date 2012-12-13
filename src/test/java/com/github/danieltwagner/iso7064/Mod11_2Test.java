package com.github.danieltwagner.iso7064;

import org.junit.Test;


public class Mod11_2Test extends GenericTest {

	@Override
	protected PureSystemCalculator getTestedClass() {
		return new Mod11_2();
	}
	
	@Override
	protected String getInputCharacters() {
		return "0123456789";
	}
	
	@Test
	public void testBasic() {
		PureSystemCalculator calc = getTestedClass();
		
		assertEquals("07940", calc.compute("0794"));
		assertEquals("079X", calc.compute("079"));
		
		assertTrue(calc.verify("07940"));
		assertTrue(calc.verify("079X"));
		assertFalse(calc.verify("08940"));
		assertFalse(calc.verify("089X"));
	}
}
