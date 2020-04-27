import java.io.*;
import java.math.*;
import java.lang.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the encryption function below.
	static String encryption(String s) {
		s = s.replaceAll("\\s", "");
		int len = s.length();
		double root = Math.sqrt(len);
		int f = (int) Math.floor(root);
		int c = (int) Math.ceil(root);
		if (len > f * c) {
			f = c;
		}
		char[][] matrix = new char[f][c];
		char[][] result = new char[c][f];
		int p = 0;
		for (int i = 0; i<f; i++) {
			for (int j = 0; j<c; j++) {
				if (p<s.length()) {
					matrix[i][j] = s.charAt(p);
					++p;
				}
				continue;
			}
		}

		for (int i = 0; i<f; i++) {
			for (int j = 0; j<c; j++) {
				result[j][i] = matrix[i][j];

			}
		}
		String ss = "";
		for (int i = 0; i<c; i++) {
			String samp = String.valueOf(result[i]).trim();
			ss = ss + samp + " ";

		}

		return ss.trim();

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String s = scanner.nextLine();

		String result = encryption(s);

		bufferedWriter.write(result);
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}