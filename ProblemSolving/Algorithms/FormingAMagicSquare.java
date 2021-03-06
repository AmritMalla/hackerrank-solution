import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the formingMagicSquare function below.
	static int formingMagicSquare(int[][] s) {
		int[][] magSq = {
			{
				8, 3, 4
			}, {
				1, 5, 9
			}, {
				6, 7, 2
			}
		};
		int result = Integer.MAX_VALUE;
		int minDiff = 0;
		for (int k = 0; k<8; k++) {
			minDiff = 0;
			for (int i = 0; i<3; i++) {
				for (int j = 0; j<3; j++) {
					minDiff += Math.abs(magSq[i][j] - s[i][j]);
				}
			}
			if (result > minDiff)
				result = minDiff;
			if (k % 4 == 0) {
				magSq = transposeMatrix(magSq);
			}
			magSq = rotateMatrix(magSq);
		}

		return result;

	}

	static int[][] rotateMatrix(int[][] s) {
		int[][] matrix = new int[3][3];
		int[][] matrix1 = new int[3][3];

		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				matrix[j][i] = s[i][j];
			}
		}
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {

				matrix1[2 - i][j] = matrix[i][j];
			}
		}
		return matrix1;
	}

	static int[][] transposeMatrix(int[][] s) {
		int[][] matrix = new int[3][3];
		for (int i = 0; i<3; i++) {
			for (int j = 0; j<3; j++) {
				matrix[j][i] = s[i][j];
			}
		}
		return matrix;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int[][] s = new int[3][3];

		for (int i = 0; i<3; i++) {
			String[] sRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j<3; j++) {
				int sItem = Integer.parseInt(sRowItems[j]);
				s[i][j] = sItem;
			}
		}

		int result = formingMagicSquare(s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}