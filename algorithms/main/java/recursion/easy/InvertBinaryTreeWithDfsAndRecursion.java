package recursion.easy;

/**
 * ----------------------------------------------------
 * 226. Invert Binary Tree
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * ----------------------------------------------------
 * <p>
 * Topics: Binary Tree, Recursion, DFS
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given the root of a binary tree, invert the tree, and return its root.
 * Inverting a binary tree means swapping the left and right child of all nodes.
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the number of nodes in the tree.
 * - Each node is visited exactly once to perform the inversion.
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(h), where h is the height of the tree.
 * - The space complexity is determined by the recursion stack depth.
 * - In the worst case (skewed tree), the recursion stack can go up to n.
 * - In the best case (balanced tree), the recursion stack depth is log(n).
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: root = [4, 2, 7, 1, 3, 6, 9]
 * Output: [4, 7, 2, 9, 6, 3, 1]
 * Explanation:
 * Original tree:
 *        4
 *      /   \
 *     2     7
 *    / \   / \
 *   1   3 6   9
 * Inverted tree:
 *        4
 *      /   \
 *     7     2
 *    / \   / \
 *   9   6 3   1
 * <p>
 * Example 2:
 * Input: root = [2, 1, 3]
 * Output: [2, 3, 1]
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * This algorithm uses recursion:
 * 1. If the current node is null, return null.
 * 2. Create a new tree node with the same value as the current node.
 * 3. Recursively call `invertTree` on the left subtree and assign it to the right of the new node.
 * 4. Recursively call `invertTree` on the right subtree and assign it to the left of the new node.
 * 5. Return the newly created node.
 * ----------------------------------------------------
 * <p>
 * LeetCode Link:
 * <a href="https://leetcode.com/problems/invert-binary-tree/">226. Invert Binary Tree</a>
 * ----------------------------------------------------
 */

public class InvertBinaryTreeWithDfsAndRecursion {

    /**
     * Inverts a binary tree and returns the new root.
     *
     * @param root The root node of the binary tree.
     * @return The root node of the inverted binary tree.
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // Base case: if node is null, return null.

        // Create a new node with the same value as the current root.
        TreeNode node = new TreeNode(root.val);

        // Recursively invert the left and right subtrees.
        node.right = invertTree(root.left); // The left subtree becomes the right subtree.
        node.left = invertTree(root.right); // The right subtree becomes the left subtree.

        return node; // Return the newly created inverted node.
    }

    public static void main(String[] args) {
        // Test case: Create a binary tree and invert it.
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );

        InvertBinaryTreeWithDfsAndRecursion solution = new InvertBinaryTreeWithDfsAndRecursion();
        TreeNode invertedRoot = solution.invertTree(root);

        // Print the inverted tree (Pre-order traversal).
        System.out.println("Inverted Tree (Pre-order): ");
        printTreePreOrder(invertedRoot);
    }

    /**
     * Helper method to print the tree in Pre-order traversal.
     *
     * @param node The root node of the tree to be printed.
     */
    public static void printTreePreOrder(TreeNode node) {
        if (node == null) return;

        System.out.print(node.val + " ");
        printTreePreOrder(node.left);
        printTreePreOrder(node.right);
    }

    /**
     * Definition for a binary tree node.
     */
    private static class TreeNode {
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
}


