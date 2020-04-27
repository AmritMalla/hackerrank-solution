import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String str = in .next();
		String ns = removeEvenPalindromes(str);
		if (ns.isEmpty())
			System.out.println("Empty String");
		else
			System.out.println(ns);
	}
	
	public static String removeEvenPalindromes(final String input) {
		StringBuilder builder = new StringBuilder();
		int inputLength = input.length();

		for (int i = 0; i<inputLength; i++) {
			char inputChar = input.charAt(i);
			int prevIndex = builder.length() - 1;

			if (prevIndex >= 0 && inputChar == builder.charAt(prevIndex)) {
				// pop a character from the stack
				builder.deleteCharAt(prevIndex);
			} else {
				// push a character onto the stack
				builder.append(inputChar);
			}
		}

		return builder.toString();
	}
}