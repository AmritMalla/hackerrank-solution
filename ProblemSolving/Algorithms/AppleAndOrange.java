import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in .nextInt(); //starting point of house
		int t = in .nextInt(); // end poing of house
		int a = in .nextInt(); //position of apple tree
		int b = in .nextInt(); //position of orange tree
		int m = in .nextInt(); //no of apples 
		int n = in .nextInt(); //no of oranges
		int[] apple = new int[m]; //respective distances of apples 
		for (int apple_i = 0; apple_i<m; apple_i++) {
			apple[apple_i] = in .nextInt();
		}
		int[] orange = new int[n]; //respective distances of oranges
		for (int orange_i = 0; orange_i<n; orange_i++) {
			orange[orange_i] = in .nextInt();
		}
		int applecount = 0;
		for (int apple_i = 0; apple_i<m; apple_i++) {
			if (s<= (a + apple[apple_i]) && t >= (a + apple[apple_i]))
				applecount++;
		}
		int orangecount = 0;
		for (int orange_i = 0; orange_i<n; orange_i++) {
			if (s<= (b + orange[orange_i]) && t >= (b + orange[orange_i]))
				orangecount++;
		}
		System.out.println(applecount);
		System.out.println(orangecount);
	}
}