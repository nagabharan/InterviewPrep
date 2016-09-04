package hackerRankArrays;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by nagabharan on 03-Sep-16.
 */
public class DynamicArray {

    static ArrayList<Integer> seqList[];

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int numSeq = in.nextInt();
        int numQ = in.nextInt();
        int lastAns = 0;

        seqList = new ArrayList[numSeq];

        for (int i = 0; i < seqList.length; i++) {
            seqList[i] = new ArrayList<Integer>();
        }

        if (numSeq >= 1 && numQ >= 1 && numSeq <= 100000 && numQ <= 100000) {
            while (numQ > 0) {
                numQ--;
                int n = in.nextInt();
                int x = in.nextInt();
                int y = in.nextInt();

                if (x >= 0 && y >= 0 && x <= Math.pow(10, 9) && y <= Math.pow(10, 9)) {
                    int z = (x ^ lastAns) % numSeq;
                    switch (n) {
                        case 1:
                            if (z < numSeq) {
                                seqList[z].add(y);
                            }
                            break;
                        case 2:
                            if (z < numSeq) {
                                int w = y % (seqList[z].size());
                                lastAns = seqList[z].get(w);
                                System.out.println(lastAns);
                            }
                            break;
                    }
                }

            }
        }

    }

}
