package com.github.danieltwagner.iso7064;

import org.junit.Test;


public class Mod1271_36Test extends GenericTest {

	@Override
	protected PureSystemCalculator getTestedClass() {
		return new Mod1271_36();
	}
	
	@Override
	protected String getInputCharacters() {
		return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	@Test
	public void testBasic() {
		PureSystemCalculator calc = getTestedClass();
		
		assertEquals("ISO793W", calc.compute("ISO79"));
		
		assertTrue(calc.verify("ISO793W"));
		assertFalse(calc.verify("ISO793X"));
	}
}
