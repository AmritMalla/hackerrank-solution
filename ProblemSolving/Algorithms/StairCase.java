import java.io. * ;
import java.util. * ;

public class Solution {

	public static void main(String[] args) {

		Scanner input = new Scanner(System. in );

		int N = input.nextInt(); // N denotes the size of square matrix
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i >= N - j - 1) System.out.print("#");
				else System.out.print(" ");
			}
			System.out.println();
		}
	}
}