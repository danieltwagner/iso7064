package com.github.danieltwagner.iso7064;

import java.util.Random;

import org.junit.Test;

import junit.framework.TestCase;

public abstract class GenericTest extends TestCase {

	protected abstract PureSystemCalculator getTestedClass();
	protected abstract String getInputCharacters();
	
	private Random rand = new Random();
	
	private String generateInputString(int length) {
		String chars = getInputCharacters();
		int max = chars.length();
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < length; i++) {
			sb.append(chars.charAt(rand.nextInt(max)));
		}
		
		return sb.toString();
	}
	
	@Test
	public void testCoherence() {
		PureSystemCalculator calc = getTestedClass();
		
		String input = generateInputString(5);
		String output = calc.compute(input);
		assertTrue(input + " generated invalid output " + output, calc.verify(output));
	}
}
