import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the absolutePermutation function below.
	static int[] absolutePermutation(int n, int k) {
		int[] result = new int[n];
		HashSet<Integer> set = new HashSet();
		for (int i = 1; i<= n; i++) {
			int a = i + k;
			int b = (i - k);
			int x = (a > b) ? a : b;
			int y = (a<b) ? a : b;
			if (y > 0 && y<= n && !set.contains(y)) {
				set.add(y);
				result[i - 1] = y;
			} else if (!set.contains(x) && x > 0 && x<= n) {
				set.add(x);
				result[i - 1] = x;
			} else {
				return new int[] {
					-1
				};
			}
		}
		return result;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int tItr = 0; tItr<t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);

			int[] result = absolutePermutation(n, k);

			for (int i = 0; i<result.length; i++) {
				bufferedWriter.write(String.valueOf(result[i]));

				if (i != result.length - 1) {
					bufferedWriter.write(" ");
				}
			}

			bufferedWriter.newLine();
		}

		bufferedWriter.close();

		scanner.close();
	}
}