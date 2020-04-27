import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    public static int find(int i, int n, int[] arr){
        int j;
        for(j = i;j<arr.length;j++){
            if(arr[j] ==  n){
                break;
            }
        }
        return j;
    }

    public static void swap(int i, int j, int[] arr){
        int x = arr[i];
        arr[i] = arr[j];
        arr[j] = x;
    }

    // Complete the largestPermutation function below.
    static int[] largestPermutation(int k, int[] arr) {
        int n = arr.length+1;
        for(int i = 0;i<arr.length;i++){
            if(k== 0){
                break;
            }
            n--;
            
            if(arr[i] == n){
                continue;
            }
            int x = find(i,n,arr);
            swap(i,x,arr);
            k--;
        }
        return arr;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = largestPermutation(k, arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
