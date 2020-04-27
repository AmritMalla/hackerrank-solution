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

public class Solution {

	// Complete the alternate function below.
	static int alternate(String s) {

		if (s.length() == 2) {
			if (s.charAt(0) != s.charAt(1))
				return 2;
		}

		String diffChar = "";
		for (int i = 0; i<s.length(); ++i) {
			if (!diffChar.matches(".*" + s.charAt(i) + ".*")) {
				diffChar += s.charAt(i);
			}
		}
		int result = 0;

		for (int i = 0; i<diffChar.length() - 1; ++i) {
			for (int j = i + 1; j<diffChar.length(); ++j) {
				String it = "" + diffChar.charAt(i) + diffChar.charAt(j);
				String removeString = diffChar.replaceAll("[" + it + "]", "");
				int x = checkValid(removeString, s);
				if (x != 0 && x > result) {
					result = x;
				}
			}
		}
		return result;
	}

	public static int checkValid(String remove, String s) {

		String changed = s.replaceAll("[" + remove + "]", "");
		if (changed.matches("^([a-z])(?!\\1)([a-z])(?:\\1\\2)*\\1?$")) {
			return changed.length();
		}
		return 0;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int l = Integer.parseInt(bufferedReader.readLine().trim());

		String s = bufferedReader.readLine();

		int result = alternate(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}