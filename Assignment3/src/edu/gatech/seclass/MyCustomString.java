package edu.gatech.seclass;

public class MyCustomString implements MyCustomStringInterface{
	
	private String inputString;

	@Override
	public void setString(String string) {
		this.inputString = string;
		
	}

	@Override
	public String getString() {
		
		return this.inputString;
	}

	@Override
	public String getEveryNthCharacter(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countDigits() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void convertDigitsToNamesInSubstring(int startPosition, int endPosition)
			throws MyIndexOutOfBoundsException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
	}

}
