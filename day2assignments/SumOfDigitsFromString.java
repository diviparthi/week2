package week2.day2assignments;

import java.util.Iterator;

public class SumOfDigitsFromString {

	public static void main(String[] args) {
		String text = "Tes12Le79af65";
		int sum = 0;
		char [] charArray = text.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			System.out.println("The Character array is " +charArray[i]);
			if (Character.isDigit(charArray[i])) 
			{
				sum = Character.getNumericValue(charArray[i])+sum;
			}
		}
		System.out.println("The sum of digits present in the string is " +sum);

	}

}
