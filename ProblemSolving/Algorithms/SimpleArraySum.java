import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int []a= new int[n];
		for(int i=0;i<n;i++){
			a[i]=input.nextInt();
		}
        int sum=0;
        for(int x:a){
            sum +=x;
        }
        System.out.println(sum);
    }
}