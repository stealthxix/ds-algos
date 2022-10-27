package edu.self.algo.easy;

public class FindClosestValueInBST {

    /*
        Write a function that takes in a BST(Binary Search Tree) and a target integer value and returns the closest
        value to the target contained in the BST.

        You can assume there will only be one closest value.

        Each BST node has an integer value, and a left child node, and a right child node. A node is said to be a
        valid BST if and only if it satisfies the BST property: its value is strictly greater than every node to its
        left; its value is less than or equal to every value to its right; and its children nodes are either valid
        BST nodes themselves or None/null.

        Sample:
                10
              5    15
            2  5  13  22
           1        14

        Target 12
        Expected Result: 13
     */

    public static int findClosestValueInBST(BST tree, int target) {
        int currentClosest = 0;

        BST node = tree;
        while(tree != null) {
            System.out.println(tree.value);
            if (Math.abs(tree.value - target) < Math.abs(currentClosest - target))
                currentClosest = tree.value;

            if (currentClosest == target) {
                break;
            } else if (tree.value < target) {
                tree = tree.right;
            } else {
                tree = tree.left;
            }
        }

        return currentClosest;
    }

    public static void main(String[] args) {

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

}
