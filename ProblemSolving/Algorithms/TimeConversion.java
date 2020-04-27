import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String in = input.nextLine();
		String[] tokenSt = in .split("[:]");
		char[] ch = tokenSt[2].toCharArray();
		int hour = Integer.parseInt(tokenSt[0]);
		if (ch[2] == 'P') {
			if (!(hour == 12))
				hour += 12;
		}
		if (ch[2] == 'A') {
			if (hour >= 12)
				hour -= 12;
		}
		String[] sec = tokenSt[2].split("[PA]");
		int minute = Integer.parseInt(tokenSt[1]);
		int second = Integer.parseInt(sec[0]);
		System.out.printf("%02d:%02d:%02d", hour, minute, second);
		input.close();
	}

}