package binary_trees.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Same Tree Problem - Iterative Approach
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Tree, Breadth-First Search (BFS), Iterative
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/same-tree/">https://leetcode.com/problems/same-tree/</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given the roots of two binary trees `p` and `q`, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same values.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use a queue to store pairs of corresponding nodes from the two trees for comparison.
 * 2. Enqueue the roots of the two trees.
 * 3. While the queue is not empty:
 *    - Dequeue two nodes (one from each tree).
 *    - If both nodes are null, continue.
 *    - If only one node is null or the values differ, return false.
 *    - Enqueue the left and right children of the two nodes for further comparison.
 * 4. If all nodes have been processed without finding differences, return true.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the total number of nodes in the larger tree.
 * - Each node is visited once during the traversal.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), where `n` is the maximum number of nodes stored in the queue at any point.
 * - In the worst case (a full binary tree), the queue may store up to half the total number of nodes.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Two identical trees:
 *    Input: [1,2,3] and [1,2,3]
 *    Output: true
 * 2. Two different trees:
 *    Input: [1,2] and [1,null,2]
 *    Output: false
 * 3. One tree is null:
 *    Input: null and [1]
 *    Output: false
 * 4. Both trees are null:
 *    Input: null and null
 *    Output: true
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - One or both trees are null.
 * - Trees with different structures.
 * <p>
 * ----------------------------------------------------
 */

public class SameTreeBfsWithQueue {

    /**
     * Checks if two binary trees are the same using an iterative approach.
     *
     * @param p The root of the first binary tree.
     * @param q The root of the second binary tree.
     * @return true if the two binary trees are the same, false otherwise.
     */
    public static boolean sameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        // Use a queue to store pairs of nodes for comparison.
        // We'll enqueue corresponding nodes from each tree side by side.
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(p);
        queue.add(q);

        while (!queue.isEmpty()) {
            // Dequeue two nodes at a time: one from the first tree and one from the second tree.
            TreeNode<Integer> node1 = queue.poll();
            TreeNode<Integer> node2 = queue.poll();

            // If both nodes are null, this pair of subtrees is identical so far; just continue.
            if (node1 == null && node2 == null) {
                continue;
            }

            // If only one node is null or their values differ, the trees are not the same.
            if (node1 == null || node2 == null || !node1.data.equals(node2.data)) {
                return false;
            }

            // If we're here, both nodes are non-null and have the same data.
            // Enqueue their corresponding children for further comparison.
            queue.add(node1.left);
            queue.add(node2.left);
            queue.add(node1.right);
            queue.add(node2.right);
        }

        // If we've processed all pairs without finding differences, the trees are the same.
        return true;
    }

    public static void main(String[] args) {
        // Test Case 1: Two identical trees
        TreeNode<Integer> tree1 = new TreeNode<>(1);
        tree1.left = new TreeNode<>(2);
        tree1.right = new TreeNode<>(3);

        TreeNode<Integer> tree2 = new TreeNode<>(1);
        tree2.left = new TreeNode<>(2);
        tree2.right = new TreeNode<>(3);

        System.out.println("Test Case 1: " + sameTree(tree1, tree2)); // true

        // Test Case 2: Two different trees
        TreeNode<Integer> tree3 = new TreeNode<>(1);
        tree3.left = new TreeNode<>(2);

        TreeNode<Integer> tree4 = new TreeNode<>(1);
        tree4.right = new TreeNode<>(2);

        System.out.println("Test Case 2: " + sameTree(tree3, tree4)); // false

        // Test Case 3: One tree is null
        TreeNode<Integer> tree5 = null;

        TreeNode<Integer> tree6 = new TreeNode<>(1);

        System.out.println("Test Case 3: " + sameTree(tree5, tree6)); // false

        // Test Case 4: Both trees are null
        TreeNode<Integer> tree7 = null;
        TreeNode<Integer> tree8 = null;

        System.out.println("Test Case 4: " + sameTree(tree7, tree8)); // true
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
