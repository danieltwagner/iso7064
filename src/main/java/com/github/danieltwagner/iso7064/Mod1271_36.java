package com.github.danieltwagner.iso7064;

public class Mod1271_36 extends PureSystemCalculator {

	@Override
	protected int getModulus() {
		return 1271;
	}

	@Override
	protected int getRadix() {
		return 36;
	}

	@Override
	protected String getCharacterSet() {
		return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	@Override
	protected boolean isDoubleCheckDigit() {
		return true;
	}

}
