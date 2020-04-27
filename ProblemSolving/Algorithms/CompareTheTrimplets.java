import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] a = new int[3]; // alice number
        int[] b = new int[3]; //bob number
        for (int i = 0; i < a.length && i < b.length; i++) // input of allice number
        {
            a[i] = in .nextInt();
        }
        for (int i = 0; i < a.length && i < b.length; i++) //input of bob number
        {
            b[i] = in .nextInt();
        }
        int aliceScore = 0, bobScore = 0;
        for (int i = 0; i < a.length && i < b.length; i++) {
            if (a[i] > b[i])
                aliceScore++;
            if (a[i] < b[i])
                bobScore++;
        }
        System.out.println(aliceScore + " " + bobScore);
    }
}