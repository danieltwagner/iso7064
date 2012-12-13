package com.github.danieltwagner.iso7064;

public abstract class PureSystemCalculator {
	
    protected abstract int getModulus();
    protected abstract int getRadix();
    protected abstract String getCharacterSet();
    protected abstract boolean isDoubleCheckDigit();
    
    public boolean verify(String input) {
    	int numDigits = isDoubleCheckDigit() ? 2 : 1;
    	String dataOnly = input.substring(0, input.length() - numDigits);
    	return input.equals(compute(dataOnly));
    }
    
    /**
     * Perform 
     * @param input The input string that should be appended with a check digit.
     * @return The input string with the check digit appended.
     * @throws IllegalStateException Raised if an illegal character is encountered.
     */
    public String compute(String input) throws IllegalStateException {
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
