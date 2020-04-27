import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static void almostSorted(int[] arr) {

		int start = 0;
		int end = 0;
		for (int i = 0; i<arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				start = i;
				break;
			}
		}
		for (int i = arr.length - 1; i > 0; i--) {
			if (arr[i]<arr[i - 1]) {
				end = i;
				break;
			}
		}
		if (swap(arr, start, end)) {
			System.out.println("yes");
			System.out.printf("swap %d %d", start + 1, end + 1);
			return;
		}
		if (reverse(arr, start, end)) {
			System.out.println("yes");
			System.out.printf("reverse %d %d", start + 1, end + 1);
			return;
		}
		System.out.println("no");
	}

	private static boolean swap(int[] arr, int i, int j) {
		int k = arr[i];
		int l = arr[j];

		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		if (isSorted(arr)) {
			return true;
		} else {
			arr[i] = k;
			arr[j] = l;
			return false;
		}

	}

	private static boolean reverse(int arr[], int begin, int end) {
		while (begin<end) {
			int temp = arr[begin];
			arr[begin] = arr[end];
			arr[end] = temp;
			begin++;
			end--;
		}
		return isSorted(arr);
	}

	private static boolean isSorted(int arr[]) {
		for (int i = 0; i<arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] arr = new int[n];

		String[] arrItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i<n; i++) {
			int arrItem = Integer.parseInt(arrItems[i]);
			arr[i] = arrItem;
		}

		almostSorted(arr);

		scanner.close();
	}
}