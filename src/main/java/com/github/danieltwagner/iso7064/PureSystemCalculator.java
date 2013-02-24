package com.github.danieltwagner.iso7064;

public abstract class PureSystemCalculator {
	
    protected abstract int getModulus();
    protected abstract int getRadix();
    protected abstract String getCharacterSet();
    protected abstract boolean isDoubleCheckDigit();
    
    /**
     * Verify if the given input is a protected code with valid check characters.
     * @param input The input string that should be checked.
     * @return Whether or not the input was successfully verified. False if the code was parsed but did not verify. 
     * @throws IllegalStateException Raised if an illegal character is encountered.
     * @throws IllegalArgumentException Raised if the input string is too short.
     */
    public boolean verify(String input) throws IllegalStateException, IllegalArgumentException {
    	input = input.toUpperCase();
    	int numDigits = isDoubleCheckDigit() ? 2 : 1;
    	if(input.length() <= numDigits) throw new IllegalArgumentException("Input string too short!");
    	
    	String dataOnly = input.substring(0, input.length() - numDigits);
    	return input.equals(compute(dataOnly));
    }
    
    /**
     * Compute check characters for the given input
     * @param input The input string that should be appended with a check digit.
     * @return The input string with the check digit appended.
     * @throws IllegalStateException Raised if an illegal character is encountered.
     */
    public String compute(String input) throws IllegalStateException {
    	input = input.toUpperCase();
    	int m = getModulus();
    	int r = getRadix();
    	String chars = getCharacterSet();
    	boolean doubleDigit = isDoubleCheckDigit();
    	
    	// process the string 
    	int p = 0;
    	for(int i = 0; i < input.length(); i++) {
    		int val = chars.indexOf(input.charAt(i));
    		if(val < 0) throw new IllegalStateException("Found illegal character " + input.charAt(i));
    		
    		p = ((p + val) * r)%m;
    	}
    	
    	// if we want a double digit output we perform one additional pass with val = 0
    	if(doubleDigit) p = (p*r)%m;
    	
    	// now compute what checksum will be = 1 mod M
    	int checksum = (m - p + 1)%m;
    	
    	if(doubleDigit) {
    		int second = checksum % r;
    		int first = (checksum - second) / r;
    		return input+chars.charAt(first)+chars.charAt(second);
    	} else {
    		return input+chars.charAt(checksum);
    	}
    }
    
}
