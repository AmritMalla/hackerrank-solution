import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in .nextInt();
		int v1 = in .nextInt();
		int x2 = in .nextInt();
		int v2 = in .nextInt();
		int x12, x22;
		boolean flag = true;
		for (int i = 0; i<20000; i++) {
			x12 = x1 + v1 * i;
			x22 = x2 + v2 * i;
			if (x1 > x2) {
				if (x12 == x22) {
					System.out.println("YES");
					flag = false;
					break;
				}

			} else if (x1<x2) {
				if (x12 == x22) {
					System.out.println("YES");
					flag = false;
					break;
				}
			}
			if (x1 == x2 & i == 0) {
				flag = false;
				System.out.println("YES");
				break;
			}

		}
		if (flag) {
			System.out.println("NO");
		}

	}
}