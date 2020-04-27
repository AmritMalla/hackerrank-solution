import java.io. * ;
import java.util. * ;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System. in );

		int N = input.nextInt(); // N denotes the size of square matrix
		int[][] matrix = new int[N][N];
		int forwardDiagonalSum = 0;
		int backwardDiagonalSum = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = input.nextInt();
			}
		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == j) forwardDiagonalSum += matrix[i][j];
				if (i == N - j - 1) backwardDiagonalSum += matrix[i][j];
			}
		}
		int diff = java.lang.Math.abs(forwardDiagonalSum - backwardDiagonalSum);
		System.out.println(diff);
	}
}