import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList();
		Scanner in = new Scanner(System.in);
		int n = in .nextInt();
		int c[] = new int[n];
		for (int c_i = 0; c_i<n; c_i++) {
			c[c_i] = in .nextInt();
			ar.add(c[c_i]);
		}
		ArrayList<Integer> index = new ArrayList();
		for (int i = 0; i<ar.size(); i++) {
			for (int j = i + 1; j<ar.size(); j++) {
				if (ar.get(i) == ar.get(j)) {
					if (!index.contains(i)) {
						index.add(i);
						if (!index.contains(j))
							index.add(j);
					}
				}
			}
		}
		int result = index.size() / 2;
		System.out.println(result);

	}

}