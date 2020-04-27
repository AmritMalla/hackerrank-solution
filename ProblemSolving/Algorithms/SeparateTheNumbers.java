import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the separateNumbers function below.
	static void separateNumbers(String s) {
		int start, end;
		long startNum;
		boolean applies = true;
		if (s.length()<2) {
			applies = false;
		} else {
			for (int i = 1; i<= s.length() / 2; i++) {
				start = 0;
				end = i;
				long x, y;
				startNum = Long.parseLong(s.substring(start, end));
				applies = true;
				while (end<s.length()) {

					x = Long.parseLong(s.substring(start, end));
					++x;
					String next = Long.toString(x);
					start = end;
					end = end + next.length();
					if (end > s.length()) {
						end = s.length();
					}
					y = Long.parseLong(s.substring(start, end));
					if (x != y) {
						applies = false;
						break;
					}

				}

				if (applies) {
					System.out.println("YES " + startNum);
					break;
				}

			}
		}

		if (!applies) {
			System.out.println("NO");
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr<q; qItr++) {
			String s = scanner.nextLine();

			separateNumbers(s);
		}

		scanner.close();
	}
}