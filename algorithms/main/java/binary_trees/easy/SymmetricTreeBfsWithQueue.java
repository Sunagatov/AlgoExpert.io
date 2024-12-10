package binary_trees.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Symmetric Tree Problem - Iterative Approach
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Tree, Breadth-First Search (BFS), Queue
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
 * 1. Use a queue to compare the corresponding nodes of the left and right subtrees.
 * 2. Initialize the queue with the root's left and right children.
 * 3. While the queue is not empty:
 *    - Dequeue two nodes.
 *    - If both nodes are null, continue (they are symmetric so far).
 *    - If one is null but the other isn't, return false (not symmetric).
 *    - If their values differ, return false (not symmetric).
 *    - Enqueue the left and right children of both nodes in the opposite order:
 *      a) Left subtree's left child with the right subtree's right child.
 *      b) Left subtree's right child with the right subtree's left child.
 * 4. If all nodes are processed without finding differences, the tree is symmetric.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the total number of nodes in the tree.
 * - Each node is visited once.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where `n` is the maximum number of nodes stored in the queue at any point.
 * - In the worst case, the queue stores all the nodes at the current level.
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

public class SymmetricTreeBfsWithQueue {

    /**
     * Checks if a binary tree is symmetric using an iterative approach.
     *
     * @param root The root of the binary tree.
     * @return true if the tree is symmetric, false otherwise.
     */
    public static boolean isSymmetric(TreeNode<Integer> root) {
        if (root == null) {
            return true; // An empty tree is symmetric.
        }

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);

        while (!queue.isEmpty()) {
            TreeNode<Integer> left = queue.poll();
            TreeNode<Integer> right = queue.poll();

            // If both nodes are null, this pair is symmetric.
            if (left == null && right == null) {
                continue;
            }

            // If one is null or their values differ, the tree is not symmetric.
            if (left == null || right == null || !left.data.equals(right.data)) {
                return false;
            }

            // Enqueue their children in opposite order.
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }

        // All nodes have been checked, and the tree is symmetric.
        return true;
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
