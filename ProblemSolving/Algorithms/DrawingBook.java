import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

	/*
	 * Complete the pageCount function below.
	 */
	static int pageCount(int n, int p) {
		/*
		 * Write your code here.
		 */
		int q = n - p, r = 0, r1 = 0;

		if (p % 2 == 0) {
			r = p / 2;
		} else {
			p = p - 1;
			r = p / 2;
		}

		if ((n % 2 == 0) && (p % 2 != 0)) {
			r1 = (n - p + 1) / 2;
		} else {
			r1 = (n - p) / 2;
		}

		if (r<r1)
			return r;
		return r1;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int p = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

		int result = pageCount(n, p);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}