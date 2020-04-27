import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'getTotalX' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER_ARRAY a
	 *  2. INTEGER_ARRAY b
	 */

	static long findLCM(List<Integer> arr, int n) {
		// Find the maximum value in arr[]  
		int max_num = 0;
		for (int i = 0; i<n; i++) {
			if (max_num<arr.get(i)) {
				max_num = arr.get(i);
			}
		}

		// Initialize result  
		long res = 1;

		// Find all factors that are present in  
		// two or more array elements.  
		int x = 2; // Current factor.  
		while (x<= max_num) {
			// To store indexes of all array  
			// elements that are divisible by x.  
			Vector<Integer> indexes = new Vector<>();
			for (int j = 0; j<n; j++) {
				if (arr.get(j) % x == 0) {
					indexes.add(indexes.size(), j);
				}
			}

			// If there are 2 or more array elements  
			// that are divisible by x.  
			if (indexes.size() >= 2) {
				// Reduce all array elements divisible  
				// by x.  
				for (int j = 0; j<indexes.size(); j++) {
					arr.set(indexes.get(j), arr.get(indexes.get(j)) / x);
				}

				res = res * x;
			} else {
				x++;
			}
		}

		// Then multiply all reduced array elements  
		for (int i = 0; i<n; i++) {
			res = res * arr.get(i);
		}

		return res;
	}

	static int gcd(int a, int b) {
		if (a == 0)
			return b;
		return gcd(b % a, a);
	}

	// Function to find gcd of array of 
	// numbers 
	static int findGCD(List<Integer> arr, int n) {
		int result = arr.get(0);
		for (int i = 1; i<n; i++)
			result = gcd(arr.get(i), result);

		return result;
	}

	public static int getTotalX(List<Integer> a, List<Integer> b) {
		// Write your code here
		int gcd1 = (int) findLCM(a, a.size());
		int gcd2 = findGCD(b, b.size());
		int temp = gcd1, n = 1;
		int result = 0;
		while (temp<= gcd2) {
			temp = gcd1 * n;
			if (gcd2 % temp == 0)
				result++;
			n++;
		}
		return result;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int m = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int total = Result.getTotalX(arr, brr);

		bufferedWriter.write(String.valueOf(total));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}