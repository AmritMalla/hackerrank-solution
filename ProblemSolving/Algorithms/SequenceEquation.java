import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the permutationEquation function below.
	static int[] permutationEquation(int[] p) {
		int[] res = new int[p.length];
		for (int i = 0; i<p.length; i++) {
			res[i] = inverseFun(p, inverseFun(p, i + 1) + 1) + 1;
		}

		return res;

	}
	static int inverseFun(int[] p, int f) {

		for (int i = 0; i<p.length; i++) {
			if (f == p[i])
				return i;
		}
		System.out.println("ERROR");
		return 0;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] p = new int[n];

		String[] pItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i<n; i++) {
			int pItem = Integer.parseInt(pItems[i]);
			p[i] = pItem;
		}

		int[] result = permutationEquation(p);

		for (int i = 0; i<result.length; i++) {
			bufferedWriter.write(String.valueOf(result[i]));

			if (i != result.length - 1) {
				bufferedWriter.write("\n");
			}
		}

		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}