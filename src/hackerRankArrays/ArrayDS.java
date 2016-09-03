package hackerRankArrays;

import java.util.Scanner;


/**
 * Created by nagabharan on 03-Sep-16.
 */
public class ArrayDS {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        for (int arr_i = 0; arr_i < n; arr_i++) {
            arr[arr_i] = in.nextInt();
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            System.out.print(arr[j]);
            if (j != 0) {
                System.out.print(" ");
            }
        }
    }

}

