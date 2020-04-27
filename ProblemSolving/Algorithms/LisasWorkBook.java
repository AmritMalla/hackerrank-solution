import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the workbook function below.

	static int workbook(int n, int k, int[] arr) {
		int page = 1;
		int special = 0;

		for (int a: arr) {
			int problem = 1;
			int fullLoop = a / k;
			int remLoop = a % k;

			for (int aa = 0; aa<fullLoop; aa++) {
				for (int i = 1; i<= k; i++) {
					if (problem == page)
						++special;
					problem++;
				}
				++page;
			}

			if (remLoop != 0) {
				for (int i = 1; i<= remLoop; i++) {
					if (problem == page)
						++special;
					problem++;
				}
				++page;
			}

		}
		return special;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0]);

		int k = Integer.parseInt(nk[1]);

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i<n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = workbook(n, k, arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}