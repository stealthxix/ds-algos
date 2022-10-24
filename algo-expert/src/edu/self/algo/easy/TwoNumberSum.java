package edu.self.algo.easy;

import java.util.Arrays;
import java.util.HashSet;

public class TwoNumberSum {
    /*

        Write a function that takes in a non-empty array of distinct integers and an integer representing a target sum.
        If any two numbers in the input array sum up to the target sum, the function should return them in an array, in
        any order. If no two numbers sum up to the target sum, the function should return an empty array.

        Note that the target sum has to be obtained by summing two different integers in the array; you can't add a single
        integer to itself in order to obtain the target sum.

        You can assume that there will be at most one pair of numbers summing up to the target sum.

     */

    public static int[] findTwoNumberSumWithSort(int[] arry, int targetSum) {
        int[] result = new int[2];
        Arrays.sort(result);
        int lPtr = 0;
        int rPtr = arry.length - 1;

        while (lPtr < rPtr) {
            int sum = arry[lPtr] + arry[rPtr];
            if (sum == targetSum) {
                result[0] = arry[lPtr];
                result[1] = arry[rPtr];
                break;
            } else if (sum > targetSum) {
                rPtr--;
            } else {
                lPtr++;
            }
        }


        return result;
    }

    public static int[] findTwoNumberSumWithHashTable(int[] arry, int targetSum) {
        int[] result = new int[2];
        HashSet<Integer> numSet = new HashSet<Integer>();
        for (int i=0; i < arry.length; i++) {
            if (numSet.contains(targetSum-arry[i])) {
                result[0] = targetSum-arry[i];
                result[1] = arry[i];
                break;
            } else {
                numSet.add(arry[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arry = {0, 3, 4, 5, 11, 22};
        int[] result = findTwoNumberSumWithSort(arry, 55);
        System.out.println("Result array with sort: "  + result[0] + " " + result[1]);
        int[] result2 = findTwoNumberSumWithHashTable(arry, 55);
        System.out.println("Result array with hashtable: "  + result2[0] + " " + result2[1]);
    }
}
