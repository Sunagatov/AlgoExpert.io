package binary_trees.easy;

/**
 * Same Tree Problem
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Tree, Recursion
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
 * 1. Base Case:
 * - If both nodes are null, the trees are identical up to this point, so return true.
 * - If one node is null but the other isn't, the trees are different, so return false.
 * 2. Recursive Case:
 * - Check if the values in the current nodes are the same.
 * - Recursively check the left and right subtrees for equivalence.
 * 3. Combine the results of the left and right subtree checks and return.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the total number of nodes in the larger tree.
 * - Each node is visited once during the recursive traversal.
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
 * 1. Two identical trees:
 * Input: [1,2,3] and [1,2,3]
 * Output: true
 * 2. Two different trees:
 * Input: [1,2] and [1,null,2]
 * Output: false
 * 3. One tree is null:
 * Input: null and [1]
 * Output: false
 * 4. Both trees are null:
 * Input: null and null
 * Output: true
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - One or both trees are null.
 * - Trees with different structures.
 * <p>
 * ----------------------------------------------------
 */

public class SameTreeDfsWithRecursion {

    /**
     * Checks if two binary trees are the same.
     *
     * @param p The root of the first binary tree.
     * @param q The root of the second binary tree.
     * @return true if the two binary trees are the same, false otherwise.
     */
    public static boolean sameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
        return (p == null && q == null) || (p != null && q != null && 
            p.data.equals(q.data) && sameTree(p.left, q.left) && sameTree(p.right, q.right));
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
