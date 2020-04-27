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
	static List<Integer[] > storePosition = new ArrayList<>();

	public static ArrayList<Integer> rotateOneDArray(List<Integer> arr, int K) {
		int[] A = arr.stream().mapToInt(i -> i).toArray();
		// write your code in Java SE 8

		int r = K % (A.length);
		int[] ans = new int[A.length];
		int y;
		for (int i = 0; i<A.length; i++) {
			y = i - r;
			if (y<0) {
				y += A.length;
			}
			ans[y] = A[i];
		}

		return (ArrayList<Integer> ) Arrays.stream(ans).boxed().collect(Collectors.toList());

	}

	static ArrayList<ArrayList<Integer>> getLinearMatrix(List<List<Integer>> matrix) {
		ArrayList<ArrayList<Integer>> linear = new ArrayList<ArrayList<Integer>> ();
		int M = matrix.get(0).size();
		int N = matrix.size();
		int m = M, n = N, i, j, counter = 0;
		Integer[] pos = new Integer[2];
		while (m >= 2 && n >= 2) {
			i = counter;
			j = counter;

			ArrayList<Integer> list = new ArrayList<>((m + n - 2) * 2);

			while (j<M - counter) {
				list.add(matrix.get(i).get(j));
				pos = new Integer[2];
				pos[0] = i;
				pos[1] = j;
				storePosition.add(pos);
				++j;
			}
			--j;
			++i;

			while (i<N - counter) {
				list.add(matrix.get(i).get(j));
				pos = new Integer[2];
				pos[0] = i;
				pos[1] = j;
				storePosition.add(pos);
				++i;
			}
			--i;
			--j;
			while (j >= counter) {
				list.add(matrix.get(i).get(j));
				pos = new Integer[2];
				pos[0] = i;
				pos[1] = j;
				storePosition.add(pos);
				--j;
			}
			++j;
			--i;
			while (i > counter) {
				list.add(matrix.get(i).get(j));
				pos = new Integer[2];
				pos[0] = i;
				pos[1] = j;
				storePosition.add(pos);
				--i;
			}
			linear.add(list);

			++counter;
			m -= 2;
			n -= 2;
		}
		return linear;

	}

	// Complete the matrixRotation function below.
	static void matrixRotation(List<List<Integer>> matrix, int r) {

		int m = matrix.get(0).size();
		int n = matrix.size();

		ArrayList<ArrayList<Integer>> linearMat = getLinearMatrix(matrix);
		ArrayList<ArrayList<Integer>> rotatedLinearMat = new ArrayList<ArrayList<Integer>> ();

		for (int f = 0; f<linearMat.size(); f++) {

			rotatedLinearMat.add(f, rotateOneDArray(linearMat.get(f), r));
		}

		int p = 0;

		Integer[][] result = new Integer[n][m];
		for (int i = 0; i<rotatedLinearMat.size(); ++i) {
			for (int j = 0; j<rotatedLinearMat.get(i).size(); ++j) {
				result[storePosition.get(p)[0]][storePosition.get(p)[1]] = rotatedLinearMat.get(i).get(j);
				++p;
			}
		}

		for (int i = 0; i<n; i++) {
			for (int j = 0; j<m; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int m = Integer.parseInt(mnr[0]);

		int n = Integer.parseInt(mnr[1]);

		int r = Integer.parseInt(mnr[2]);

		List<List<Integer>> matrix = new ArrayList<>();

		IntStream.range(0, m).forEach(i -> {
			try {
				matrix.add(
					Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
					.map(Integer::parseInt)
					.collect(toList())
				);
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		matrixRotation(matrix, r);

		bufferedReader.close();
	}
}