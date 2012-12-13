package com.github.danieltwagner.iso7064;

public class Mod97_10 extends PureSystemCalculator {

	@Override
	protected int getModulus() {
		return 97;
	}

	@Override
	protected int getRadix() {
		return 10;
	}
	
	@Override
	protected String getCharacterSet() {
		return "0123456789";
	}

	@Override
	protected boolean isDoubleCheckDigit() {
		return true;
	}
}
