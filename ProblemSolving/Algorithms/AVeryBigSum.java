import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class Solution {

 public static void main(String[] args) {
	  Scanner input = new Scanner(System.in);
	  int n = input.nextInt();
	  int[] arry = new int[n];
	  BigDecimal[] bigNumber = new BigDecimal[n];
	  BigDecimal sum = new BigDecimal(0);
	  for (int i = 0; i < bigNumber.length; i++) {
	   bigNumber[i] = input.nextBigDecimal();
	   sum = sum.add(bigNumber[i]);
	  }
	  System.out.println(sum);
	 }
}