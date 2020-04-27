import java.io.*;
import java.math.*;
import java.lang.Math;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the kaprekarNumbers function below.
	static void kaprekarNumbers(int p, int q) {
		boolean kaprekar = false;
		for (int i = p; i<= q; i++) {
			if (i == 0 || i == 1) {
				System.out.print(i + " ");
				kaprekar = true;
				continue;
			}
			long x = (long) Math.pow(i, 2);
			String sq = Long.toString(x);
			int n = sq.length();
			String fp, sp;
			fp = sq.substring(0, n / 2);
			sp = sq.substring(n / 2);

			// System.out.println(fp + " "+ sp);

			int a = 0, b = 0;
			if (!fp.isEmpty()) {
				a = Integer.parseInt(fp);
			}

			b = Integer.parseInt(sp);

			if (a + b == i) {
				kaprekar = true;
				System.out.print(i + " ");
			}

		}

		if (!kaprekar) {
			System.out.print("INVALID RANGE");
		}

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		kaprekarNumbers(p, q);

		scanner.close();
	}
}