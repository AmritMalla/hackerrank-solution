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

class Result {

	/*
	 * Complete the 'nonDivisibleSubmap' function below.
	 *
	 * The function is expected to return an INTEGER.
	 * The function accepts following parameters:
	 *  1. INTEGER k
	 *  2. INTEGER_ARRAY s
	 */

	public static int nonDivisibleSubmap(int k, List<Integer> s) {
		// Write your code here
		List<Integer> t = new ArrayList();
		int count = 0;
		for (Integer i: s) {
			Integer x = i % k;
			t.add(x);
		}
		Integer mid = k / 2;
		Integer eod = k % 2;

		HashMap<Integer, Integer> map = new HashMap<>();
		for (Integer i: t) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		if (map.containsKey(0)) {
			++count;
		}

		if (eod == 1) {
			for (int i = 1; i<= mid; ++i) {
				int a = 0;
				if (map.containsKey(i))
					a = map.get(i);
				int b = 0;
				if (map.containsKey(k - i))
					b = map.get(k - i);
				count = a >= b ? count + a : count + b;
			}
		} else {
			for (int i = 1; i<mid; ++i) {
				int a = 0;
				if (map.containsKey(i))
					a = map.get(i);
				int b = 0;
				if (map.containsKey(k - i))
					b = map.get(k - i);
				count = a >= b ? count + a : count + b;
			}
			if (map.containsKey(mid)) {
				++count;
			}

		}

		System.out.println(map);

		// make hashmap
		// take best among digit and it's complement for eg from 1 & 3 wih k = 4 
		// upto n/2 for odd and (n/2-1) for even;
		//count 1 on even if with reminder n/2

		//count 1 if contains with reminder 0

		return count;

	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

		int n = Integer.parseInt(firstMultipleInput[0]);

		int k = Integer.parseInt(firstMultipleInput[1]);

		List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int result = Result.nonDivisibleSubmap(k, s);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}