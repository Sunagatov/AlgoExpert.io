package recursion.easy;

/**
 * ----------------------------------------------------
 * 104. Maximum Depth of Binary Tree
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * ----------------------------------------------------
 * <p>
 * Topics: Binary Tree, Recursion
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
 * - Each node is visited once.
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(h), where h is the height of the tree.
 * - Recursive calls use stack space proportional to the height of the tree.
 * - In the worst case (a skewed tree), the height is O(n).
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
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. If the current node is null, return 0 (base case for recursion).
 * 2. Recursively calculate the depth of the left and right subtrees.
 * 3. Find the maximum of the left and right subtree depths.
 * 4. Add 1 to account for the current node and return the result.
 * ----------------------------------------------------
 * <p>
 * LeetCode Link:
 * <a href="https://leetcode.com/problems/maximum-depth-of-binary-tree/">104. Maximum Depth of Binary Tree</a>
 * ----------------------------------------------------
 */
class MaximumDepthBinaryTreeWithDfsAndRecursion {

    /**
     * Computes the maximum depth of a binary tree.
     *
     * @param node The root node of the binary tree.
     * @return The maximum depth of the tree.
     */
    public int maxDepth(TreeNode node) {
        // Base case: If the node is null, the depth is 0.
        if (node == null) {
            return 0;
        }

        // Recursively find the depth of the left subtree.
        int leftNodeDepth = maxDepth(node.left);

        // Recursively find the depth of the right subtree.
        int rightNodeDepth = maxDepth(node.right);

        // Find the maximum depth of the left and right subtrees.
        int maxChildNodeDepth = Math.max(leftNodeDepth, rightNodeDepth);

        // Add 1 to account for the current node and return.
        return maxChildNodeDepth + 1;
    }

    /**
     * Main method for testing the maxDepth function.
     */
    public static void main(String[] args) {
        // Construct the binary tree for testing
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthBinaryTreeWithDfsAndRecursion solution = new MaximumDepthBinaryTreeWithDfsAndRecursion();

        // Test Case 1
        int maxDepth1 = solution.maxDepth(root);
        System.out.println("Test Case 1: Maximum depth is " + maxDepth1); // Output: 3

        // Test Case 2
        TreeNode singleNodeTree = new TreeNode(1);
        int maxDepth2 = solution.maxDepth(singleNodeTree);
        System.out.println("Test Case 2: Maximum depth is " + maxDepth2); // Output: 1

        // Test Case 3
        int maxDepth3 = solution.maxDepth(null);
        System.out.println("Test Case 3: Maximum depth is " + maxDepth3); // Output: 0
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
