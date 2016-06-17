package com.camt.java.lessons;

public class lesson01 {
	static String randomString = "String to print";
	static final double PINUM = 3.1415929;

	public static void main(String[] args) {
		System.out.println("Hello World");
		
		int integerOne = 22;
		int integerTwo = integerOne + 1; // This is an expression statement
		integerTwo = integerOne + 3;
		System.out.println(integerTwo);
		byte bigByte = 127; // Minimum value -128 Maximum value 127
		short bigShort = 32767; // Minimum value -32768 Maximum value 32767
		int bigInt = 2147483647; // Minimum value -2147483648 Maximum value
									// 2147483647
		long bigLong = 9223372036854775807L; // Minimum value
												// -9223372036854775808L
		float bigFloat = 3.14F; // You must end a float with an F
		double bigDouble = 3.1234567890D; // The D is not required with doubles
		System.out.println(Float.MAX_VALUE); // Float is precise to 6 decimal
												// places
		System.out.println(Double.MAX_VALUE); // Double is precise to 15 decimal
												// places
		boolean trueOrFalse = true; // Booleans are True or False, not 1 or 0
		char randomChar = 65; // Character Code for A is 65 Minimum value 0
								// Maximum value 65535
		char anotherChar = 'A';
		System.out.println(randomChar);
		char backSpace = '\b';
		char formFeed = '\f';
		char lineFeed = '\n';
		char carriageReturn = '\r';
		char horizontalTab = '\t';
		char doubleQuote = '\"';
		char singleQuote = '\'';
		char backSlash = '\\';
		String randomString = "I'm just a random";
		String anotherString = "string";
		String combinedString = randomString + ' ' + anotherString;
		System.out.println(combinedString);
		String byteString = Byte.toString(bigByte);
		String shortString = Short.toString(bigShort);
		String intString = Integer.toString(bigInt);
		String longString = Long.toString(bigLong);
		String floatString = Float.toString(bigFloat);
		String doubleString = Double.toString(bigDouble);
		String booleanString = Boolean.toString(trueOrFalse);
		String charString = Character.toString(randomChar); // You don't need to
															// do this
		System.out.println(charString);
		System.out.println(charString.getClass());
		double aDoubleValue = 3.1456789;
		int doubleToInt = (int) aDoubleValue;
		System.out.println(doubleToInt);
		int stringToInt = Integer.parseInt(intString);
	}

}
