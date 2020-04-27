import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the minimumNumber function below.
	static int minimumNumber(int n, String password) {
		// Return the minimum number of characters to make the password strong

		String special_characters = "";

		int mn = 0;

		if (!password.matches(".*[a-z]+.*")) {
			++mn;
		}
		if (!password.matches(".*[A-Z]+.*")) {
			++mn;
		}
		if (!password.matches(".*[!@#$%^&*()+-]+.*")) {

			mn++;
		}
		if (!password.matches(".*[0-9]+.*")) {
			mn++;
		}

		int add = 0;
		switch (mn) {
			case 3:
				add = 3;
				break;
			case 2:
				add = 2;
				break;
			case 1:
				add = 1;
				break;
		}

		int a = 0;
		if (n<6) {
			a = 6 - n - add;
		}

		if (a<0)
			a = 0;
		return a + add;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		String password = scanner.nextLine();

		int answer = minimumNumber(n, password);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}