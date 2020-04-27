import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static int bitAnd(String a, String b) {
		int count = 0;
		for (int i = 0; i<a.length(); i++) {
			if (a.charAt(i) == '1' || b.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}

	// Complete the acmTeam function below.
	static int[] acmTeam(String[] topic) {
		int[] res = new int[2];
		for (int i = 0; i<topic.length; i++) {
			for (int j = i + 1; j<topic.length; j++) {
				int x = bitAnd(topic[i], topic[j]);

				if (x > res[0]) {
					res[0] = x;
					res[1] = 1;
				} else if (x == res[0]) {
					++res[1];
				}
			}
		}

		return res;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] nm = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nm[0]);

		int m = Integer.parseInt(nm[1]);

		String[] topic = new String[n];

		for (int i = 0; i<n; i++) {
			String topicItem = scanner.nextLine();
			topic[i] = topicItem;
		}

		int[] result = acmTeam(topic);

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