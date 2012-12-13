package com.github.danieltwagner.iso7064;

import org.junit.Test;


public class Mod37_2Test extends GenericTest {

	@Override
	protected PureSystemCalculator getTestedClass() {
		return new Mod37_2();
	}
	
	@Override
	protected String getInputCharacters() {
		return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	@Test
	public void testBasic() {
		PureSystemCalculator calc = getTestedClass();
		
		assertEquals("G123489654321Y", calc.compute("G123489654321"));
		
		assertTrue(calc.verify("G123489654321Y"));
		assertFalse(calc.verify("G123489654322Y"));
	}
}
