import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the equalizeArray function below.
	static int equalizeArray(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int hv = 0;
		for (int a: arr) {
			if (map.containsKey(a)) {
				int v = map.get(a) + 1;
				map.put(a, v);
				if (hv<v) {
					hv = v;
				}
			} else {
				if (hv<1) {
					hv = 1;
				}
				map.put(a, 1);
			}
		}
		System.out.println(map);
		return arr.length - hv;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i<n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		int result = equalizeArray(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}