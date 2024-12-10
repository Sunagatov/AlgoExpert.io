package dfs.easy;

import binary_trees.easy.SameTreeBfsWithQueue;

import java.util.*;

/**
 * Symmetric Tree Problem
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Tree, Recursion, Breadth-First Search (BFS)
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/symmetric-tree/">https://leetcode.com/problems/symmetric-tree/</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. If the root is null, the tree is symmetric (base case).
 * 2. Use a helper function `isMirror` to compare two subtrees (left and right):
 *    - Base Case:
 *      - If both subtrees are null, they are symmetric.
 *      - If one is null but the other isn't, they are not symmetric.
 *    - Recursive Case:
 *      - Check if the current nodes have the same value.
 *      - Recursively check if:
 *        a) The left subtree of the first tree is a mirror of the right subtree of the second tree.
 *        b) The right subtree of the first tree is a mirror of the left subtree of the second tree.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the total number of nodes in the tree.
 * - Each node is visited once during the recursion.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(h), where `h` is the height of the tree.
 * - The maximum depth of the recursion stack corresponds to the height of the tree.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Symmetric tree:
 *    Input: [1,2,2,3,4,4,3]
 *    Output: true
 * 2. Non-symmetric tree:
 *    Input: [1,2,2,null,3,null,3]
 *    Output: false
 * 3. Single node:
 *    Input: [1]
 *    Output: true
 * 4. Empty tree:
 *    Input: null
 *    Output: true
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Root is null (empty tree).
 * - Tree has only one node.
 * - Tree has multiple nodes with null children.
 * <p>
 * ----------------------------------------------------
 */

public class SymmetricTreeDfsWithRecursion {

    /**
     * Checks if a binary tree is symmetric.
     *
     * @param root The root of the binary tree.
     * @return true if the tree is symmetric, false otherwise.
     */
    public static boolean isSymmetric(TreeNode<Integer> root) {
        // A tree is symmetric if its left and right subtrees are mirrors of each other.
        return root != null && isMirror(root.left, root.right);
    }

    /**
     * Helper function to check if two subtrees are mirrors of each other.
     *
     * @param t1 The root of the first subtree.
     * @param t2 The root of the second subtree.
     * @return true if the subtrees are mirrors, false otherwise.
     */
    private static boolean isMirror(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        return (t1 == null && t2 == null) ||
                t1 != null && t2 != null &&
                t1.data.equals(t2.data) &&
                isMirror(t1.left, t2.right) &&
                isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        // Test Case 1: Symmetric tree
        TreeNode<Integer> tree1 = new TreeNode<>(1);
        tree1.left = new TreeNode<>(2);
        tree1.right = new TreeNode<>(2);
        tree1.left.left = new TreeNode<>(3);
        tree1.left.right = new TreeNode<>(4);
        tree1.right.left = new TreeNode<>(4);
        tree1.right.right = new TreeNode<>(3);

        System.out.println("Test Case 1: " + isSymmetric(tree1)); // true

        // Test Case 2: Non-symmetric tree
        TreeNode<Integer> tree2 = new TreeNode<>(1);
        tree2.left = new TreeNode<>(2);
        tree2.right = new TreeNode<>(2);
        tree2.left.right = new TreeNode<>(3);
        tree2.right.right = new TreeNode<>(3);

        System.out.println("Test Case 2: " + isSymmetric(tree2)); // false

        // Test Case 3: Single node
        TreeNode<Integer> tree3 = new TreeNode<>(1);

        System.out.println("Test Case 3: " + isSymmetric(tree3)); // true

        // Test Case 4: Empty tree
        TreeNode<Integer> tree4 = null;

        System.out.println("Test Case 4: " + isSymmetric(tree4)); // true
    }

    private static class TreeNode<T> {
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
