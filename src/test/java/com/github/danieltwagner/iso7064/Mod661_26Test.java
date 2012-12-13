package com.github.danieltwagner.iso7064;

import org.junit.Test;


public class Mod661_26Test extends GenericTest {

	@Override
	protected PureSystemCalculator getTestedClass() {
		return new Mod661_26();
	}
	
	@Override
	protected String getInputCharacters() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}
	
	@Test
	public void testBasic() {
		PureSystemCalculator calc = getTestedClass();
		
		assertEquals("BAISDLAFKBM", calc.compute("BAISDLAFK"));
		
		assertTrue(calc.verify("BAISDLAFKBM"));
		assertFalse(calc.verify("BAISDLAFKBA"));
	}
}
