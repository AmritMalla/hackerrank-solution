import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	private static List<Integer> result = new ArrayList<Integer> ();
	private static Integer min;

	static List<Integer> cut(List<Integer> list) {
		result.add(list.size());
		//        count sticks number and add it to result list

		List<Integer> newList = new ArrayList<>();

		for (Integer m: list) {
			Integer x = m - min;
			if (x != 0) {
				newList.add(x);
			}
		}
		// cut sticks with min value
		// for all value if value == 0
		// remove it 

		return newList;
	}

	static void setMin(List<Integer> list) {
		min = list.get(0);
		for (Integer i: list) {
			if (min > i) {
				min = i;
			}
		}

	}

	// Complete the cutTheSticks function below.
	static int[] cutTheSticks(int[] arr) {
		List<Integer> list = new ArrayList();

		for (int i: arr) {
			list.add(i);
		}

		do {
			setMin(list);
			list = cut(list);
		} while (list.size() > 0);

		int[] array = result.stream().mapToInt(i -> i).toArray();
		return array;

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

		int[] result = cutTheSticks(arr);

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