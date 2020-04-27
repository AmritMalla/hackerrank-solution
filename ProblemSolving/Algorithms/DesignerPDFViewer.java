import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] h = new int[26];
		for (int h_i = 0; h_i<26; h_i++) {
			h[h_i] = in .nextInt();
		}
		String word = in .next();
		int width = word.length();
		char[] arrayOfWord = word.toCharArray();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		char[] alphabetArray = alphabet.toCharArray();
		int height = 0;
		for (int j = 0; j<arrayOfWord.length; j++) {
			for (int i = 0; i<alphabetArray.length; i++) {
				if (alphabetArray[i] == arrayOfWord[j]) {
					if (height<h[i])
						height = h[i];

				}
			}
		}
		int area = height * width;
		System.out.println(area);

	}
}