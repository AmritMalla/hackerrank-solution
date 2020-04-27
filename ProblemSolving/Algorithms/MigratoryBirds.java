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

	// Complete the migratoryBirds function below.
	static int migratoryBirds(List<Integer> arr) {
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer> ();
		Iterator it = arr.iterator();
		int maxValue = 0;
		int maxValueKey = 1;
		while (it.hasNext()) {
			Integer i = (Integer) it.next();
			if (!hashMap.containsKey(i)) {
				hashMap.put(i, 1);
			} else {
				hashMap.put(i, hashMap.get(i) + 1);
				if (maxValue<hashMap.get(i)) {
					maxValue = hashMap.get(i);
					maxValueKey = i;
				}
			}
		}
		Iterator hmi = hashMap.entrySet().iterator();
		while (hmi.hasNext()) {
			Map.Entry me = (Map.Entry) hmi.next();
			if ((Integer) me.getValue() == maxValue && maxValueKey > (Integer) me.getKey()) {

				maxValueKey = (Integer) me.getKey();
			}
		}

		return maxValueKey;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

		List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
			.map(Integer::parseInt)
			.collect(toList());

		int result = migratoryBirds(arr);

		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedReader.close();
		bufferedWriter.close();
	}
}