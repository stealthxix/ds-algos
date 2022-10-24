package edu.self.algo.easy;

public class ValidateSubsequence {
    /*
        Given two non-empty array of Integers, write a function that determines whether the second array is a subsequence* of the first one.

        * Subsequence - set of numbers that aren't necessarily adjacent in the array but that are in the same order as they appear in the array
          For example, [1,3,4] form a Subsequence of the array [1,2,3,4] and so do [2,4].
          Note a single in an array and the array itself are both valid subsequences.

     */


    public static boolean isValidSubsequence(int[] arrayOne, int[] arrayTwo) {
        int ptrOne = 0;
        int ptrTwo = 0;

        while (ptrOne < arrayOne.length && ptrTwo < arrayTwo.length) {
            if (arrayOne[ptrOne] == arrayTwo[ptrTwo]) {
                ptrOne++;
                ptrTwo++;
                if (ptrTwo == arrayTwo.length) return true;
            } else {
                ptrOne++;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arrayOne = { 1, 2, 3, 4 };
        int[] arrayTwo = { 2,4 };

        System.out.println("Subsequence result: " + isValidSubsequence(arrayOne, arrayTwo));
    }


}
