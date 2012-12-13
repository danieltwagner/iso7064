package com.github.danieltwagner.iso7064;

public class Mod37_2 extends PureSystemCalculator {

	@Override
	protected int getModulus() {
		return 37;
	}

	@Override
	protected int getRadix() {
		return 2;
	}

	@Override
	protected String getCharacterSet() {
		return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ*";
	}

	@Override
	protected boolean isDoubleCheckDigit() {
		return false;
	}

}
