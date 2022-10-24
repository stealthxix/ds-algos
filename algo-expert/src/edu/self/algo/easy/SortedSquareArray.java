package edu.self.algo.easy;

import java.util.Arrays;

public class SortedSquareArray {
    /*

        Write a function that takes in a non-empty array of integers that are sorted in ascending order and returns
        a new array of the same length with the squares of the original integers also sorted in ascending order.

     */

    public static int[] createSortedSquareArrayWithNestedLoops(int[] arry) {
        int[] ssArray = new int[arry.length];
        for (int i=0; i < arry.length; i++) {
            int sVal = arry[i] * arry[i];
            ssArray[i] = sVal;
            for (int j = i-1; j >= 0; j--) {
                if (ssArray[j] > ssArray[j+1]) {
                    int tmp = ssArray[j+1];
                    ssArray[j+1] = ssArray[j];
                    ssArray[j] = tmp;
                }
            }
        }

        return ssArray;

    }

    public static int[] createSortedSquareArrayWithTwoPointers(int[] arry) {
        int[] ssArray = new int[arry.length];
        int lIdx = 0;
        int rIdx = arry.length - 1;
        for (int i = rIdx; i >= 0; i--) {
            if (Math.abs(arry[lIdx]) > Math.abs(arry[rIdx])) {
                ssArray[i] = arry[lIdx] * arry[lIdx];
                lIdx++;
            } else {
                ssArray[i] = arry[rIdx] * arry[rIdx];
                rIdx--;
            }
        }

        return ssArray;

    }

    public static void main(String[] args) {
        int[] arry = {-5, -3, 0, 1, 4, 10};
        System.out.println("Sorted with loops array: " + Arrays.toString(createSortedSquareArrayWithNestedLoops(arry)));
        System.out.println("Sorted with two pointers array: " + Arrays.toString(createSortedSquareArrayWithTwoPointers(arry)));
    }
}
