package com.github.danieltwagner.iso7064;

public class Mod661_26 extends PureSystemCalculator {

	@Override
	protected int getModulus() {
		return 661;
	}

	@Override
	protected int getRadix() {
		return 26;
	}

	@Override
	protected String getCharacterSet() {
		return "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	@Override
	protected boolean isDoubleCheckDigit() {
		return true;
	}

}
