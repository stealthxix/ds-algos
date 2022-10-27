package edu.self.algo.easy;

import java.util.Arrays;

public class NonconstructibleChange {

    /*
        Given an array of positive integers representing the values of coins in your possession, write a function
        that returns the minimum amount of change (the minimum sum of money) that you cannot create. The given coins
        can have any positive integer value and aren't necessarily unique (ie you can multiple coins of the same value).

        For example, if you're given coins = [ 1, 2, 5 ] the minimum amount of change that you can't create is 4. If
        you're given no coins, the minimum amount of change you can't create is 1.

     */


    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int runningSum = 0;
        for (int i=0; i < coins.length; i++) {
            if (coins[i] > (runningSum + 1))
                return runningSum + 1;
            else
                runningSum = runningSum + coins[i];
        }

        return runningSum+1;
    }



    public static void main(String[] args) {
        int[] coins = { 1, 5, 1, 1, 1, 10, 15, 20, 100};
        // Key insight keep a running sum which represents the highest amount of change possible
        // if the next coin is greater than 1 + the current running sum then we've identified the hole
        System.out.println("Nonconstructible: " + nonConstructibleChange(coins));
    }


}
