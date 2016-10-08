package leetcode.general;

import java.util.Scanner;

/**
 * Created by nagabharan on 19-Sep-16.
 */
public class _12IntToRoman {
    static String solution(int x) {

        if (x < 1 || x >= 4000)
            throw new IllegalArgumentException("Input out of range");
        String s = new String();

        String[] Letter = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] decimal = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < decimal.length; i++) {
            while (x >= decimal[i]) {
                s += Letter[i];
                x -= decimal[i];
            }
        }

        return s;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(solution(in.nextInt()));
    }

}
