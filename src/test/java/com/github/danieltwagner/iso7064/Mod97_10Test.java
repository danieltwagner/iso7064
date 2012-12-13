package com.github.danieltwagner.iso7064;

import org.junit.Test;


public class Mod97_10Test extends GenericTest {

	@Override
	protected PureSystemCalculator getTestedClass() {
		return new Mod97_10();
	}
	
	@Override
	protected String getInputCharacters() {
		return "0123456789";
	}
	
	@Test
	public void testBasic() {
		PureSystemCalculator calc = getTestedClass();

		assertEquals("79444", calc.compute("794"));
		assertEquals("10757107", calc.compute("107571"));
		
		assertTrue(calc.verify("79444"));
		assertTrue(calc.verify("10757107"));
		assertFalse(calc.verify("79445"));
		assertFalse(calc.verify("10757108"));
	}
}
