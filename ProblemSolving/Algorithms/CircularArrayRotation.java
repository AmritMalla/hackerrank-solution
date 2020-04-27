import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in .nextInt();
		int k = in .nextInt(); //rotate times
		int q = in .nextInt();
		int[] a = new int[n];
		int[] qs = new int[q];

		//	        take array element
		for (int a_i = 0; a_i<n; a_i++) {
			a[a_i] = in .nextInt();
		}
		//	        take query
		for (int a0 = 0; a0<q; a0++) {
			qs[a0] = in .nextInt();
		}

		//rotate array right k times
		//	        for(int i=0;i<k;i++)
		//	        	a = rtArray(a);

		//rotate by index calculation 
		int[] newArray = new int[a.length];
		int index = k;
		for (int i = 0; i<n; i++) {
			while (index > a.length - 1) {
				index = index - n;
			}
			newArray[index] = a[i];
			index++;

		}

		for (int j = 0; j<qs.length; j++) {
			System.out.println(newArray[qs[j]]);
		}
	}
	//	    public static int[] rtArray(int a[])
	//	    {
	//	    	int newA[]= new int[a.length];
	//	    	
	//	    		
	//	    		newA[0] = a[a.length-1];
	//	    		for(int i=0;i<a.length-1;i++)
	//	    		{
	//	    			newA[i+1] =a[i];
	//	    		}
	//	    		
	//	    	return newA;
	//	    	
	//    }
}