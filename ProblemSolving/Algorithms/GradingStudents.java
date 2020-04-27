import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	static int[] solve(int[] grades) {
		int[] finalGrades = new int[grades.length];
		for (int i = 0; i<grades.length; i++) {
			int a = grades[i];
			int sum = 0;
			while (sum<= a) {
				sum += 5;
			}
			if (a >= 38) {
				if (sum - a<3) {
					a = sum;
				}
			}
			finalGrades[i] = a;
		}
		return finalGrades;
		// Complete this function
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in .nextInt();
		int[] grades = new int[n];
		for (int grades_i = 0; grades_i<n; grades_i++) {
			grades[grades_i] = in .nextInt();
		}
		int[] result = solve(grades);
		for (int i = 0; i<result.length; i++) {
			System.out.print(result[i] + (i != result.length - 1 ? "\n" : ""));
		}
		System.out.println("");

	}
}