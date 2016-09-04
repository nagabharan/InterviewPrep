package hackerRankArrays;

import java.util.Scanner;

/**
 * Created by nagabharan on 03-Sep-16.
 */
public class LeftRot {

    static void leftRotate(int arr[], int d) {
        int n = arr.length;
        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    static void reverseArray(int arr[], int start, int end) {
        int temp;
        while (start < end) {
            temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        if (d >= 1 && d <= n && n >= 1 && n <= 100000) {
            leftRotate(arr, d); // Rotate array by 2
            printArray(arr);

        }

    }
}
