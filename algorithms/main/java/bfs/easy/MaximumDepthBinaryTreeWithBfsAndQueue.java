package bfs.easy;

/**
 * ----------------------------------------------------
 * 104. Maximum Depth of Binary Tree
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * ----------------------------------------------------
 * <p>
 * Topics: Binary Tree, Breadth-First Search (BFS), Queue
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given the root of a binary tree, return its maximum depth.
 * <p>
 * A binary tree's maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the number of nodes in the tree.
 * - Each node is visited once during the traversal.
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(h), where h is the height of the tree.
 * - In the worst case, the queue will store all nodes on a single level, which is proportional to the height of the tree.
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: root = [3, 9, 20, null, null, 15, 7]
 * Output: 3
 * Explanation: The maximum depth is 3 (path: 3 -> 20 -> 15 or 3 -> 20 -> 7).
 * <p>
 * Example 2:
 * Input: root = [1, null, 2]
 * Output: 2
 * Explanation: The maximum depth is 2 (path: 1 -> 2).
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * This algorithm uses **Breadth-First Search (BFS)**:
 * 1. Use a queue to traverse the tree level by level.
 * 2. Start by adding the root node to the queue.
 * 3. For each level:
 *    - Determine the number of nodes at that level (queue size).
 *    - Iterate over all nodes at that level and enqueue their children.
 * 4. Increment the depth counter after processing each level.
 * 5. Return the depth counter as the maximum depth once the traversal is complete.
 * ----------------------------------------------------
 * <p>
 * LeetCode Link:
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>
 * ----------------------------------------------------
 */

import java.util.*;

class MaximumDepthBinaryTreeWithBfsAndQueue {

    /**
     * Computes the maximum depth of a binary tree using BFS.
     *
     * @param node The root node of the binary tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode node) {
        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();
        if (node != null) {
            queue.add(node);
        }

        int maxDepth = 0; // Depth counter

        // Perform BFS
        while (!queue.isEmpty()) {
            int nodesCountOnLevel = queue.size(); // Nodes at the current level

            // Process all nodes at this level
            for (int i = 0; i < nodesCountOnLevel; i++) {
                TreeNode currentNode = queue.poll(); // Dequeue the current node

                // Enqueue left and right children if they exist
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }

            maxDepth++; // Increment depth after processing the level
        }

        return maxDepth; // Return the final depth count
    }

    public static void main(String[] args) {
        // Test cases
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthBinaryTreeWithBfsAndQueue solution = new MaximumDepthBinaryTreeWithBfsAndQueue();
        System.out.println("Maximum depth of the tree: " + solution.maxDepth(root)); // Output: 3

        TreeNode singleNodeTree = new TreeNode(1);
        System.out.println("Maximum depth of a single-node tree: " + solution.maxDepth(singleNodeTree)); // Output: 1

        System.out.println("Maximum depth of an empty tree: " + solution.maxDepth(null)); // Output: 0
    }
}

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
