import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the howManyGames function below.
	static int howManyGames(int p, int d, int m, int s) {
		// Return the number of games you can buy
		int count = 0;
		int n = (p - m) / d;

		int sum = n * (2 * p - n * d) / 2;
		if (sum > s) {
			int price = p;
			sum = s;

			while (sum >= m) {
				if (sum<price) {

					break;
				}
				sum = sum - price;
				price = price - d;
				count++;
			}
		} else {
			sum = s;
			int price = p;
			while (price >= m) {
				sum = sum - price;
				price = price - d;
				++count;
			}
			count += sum / m;
		}
		return count;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] pdms = scanner.nextLine().split(" ");

		int p = Integer.parseInt(pdms[0]);

		int d = Integer.parseInt(pdms[1]);

		int m = Integer.parseInt(pdms[2]);

		int s = Integer.parseInt(pdms[3]);

		int answer = howManyGames(p, d, m, s);

		bufferedWriter.write(String.valueOf(answer));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}