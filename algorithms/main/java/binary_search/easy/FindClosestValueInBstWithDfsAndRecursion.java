package binary_search.easy;

/**
 * Closest Value in a Binary Search Tree (BST)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Binary Search Tree, Recursion
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given a Binary Search Tree (BST) and a target integer value, find the value in the BST
 * that is closest to the target.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Start at the root of the BST and initialize the closest value to the root's value.
 * 2. At each node:
 *    - Compare the absolute difference between the target and the current closest value
 *      with the difference between the target and the current node's value.
 *    - If the current node's value is closer to the target, update the closest value.
 * 3. Recursively traverse:
 *    - Go to the left subtree if the current node's value is greater than the target.
 *    - Go to the right subtree if the current node's value is less than the target.
 *    - Stop recursion when reaching a null node (base case).
 * 4. Return the closest value.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(log(n)) on average for balanced trees, where `n` is the number of nodes.
 * O(n) in the worst case for unbalanced trees.
 * - Each recursive call narrows down the search space by half (in balanced trees).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(h), where `h` is the height of the tree.
 * - Recursive calls use stack space proportional to the height of the tree.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Input: Tree = [10, 5, 15, 2, 5, null, 22], Target = 12
 *    Output: 10
 * 2. Input: Tree = [10, 5, 15, 2, 5, null, 22], Target = 4
 *    Output: 5
 * 3. Input: Tree = [10], Target = 10
 *    Output: 10
 * 4. Input: Tree = [10, 5, null], Target = 1
 *    Output: 5
 * <p>
 * ----------------------------------------------------
 */

class FindClosestValueInBstWithDfsAndRecursion {
    /**
     * Finds the value in the BST that is closest to the target.
     *
     * @param tree   The root of the BST.
     * @param target The target value.
     * @return The value in the BST closest to the target.
     */
    public static int findClosestValueInBst(BST tree, int target) {
        return findClosestValueInBst(tree, target, tree.value);
    }

    /**
     * Helper function to find the closest value using recursion.
     *
     * @param tree    The current BST node.
     * @param target  The target value.
     * @param closest The current closest value.
     * @return The closest value in the BST.
     */
    public static int findClosestValueInBst(BST tree, int target, int closest) {
        if (tree == null) {
            return closest; // Base case: return the closest value found so far.
        }

        int currentValue = tree.value;

        // Update closest if the current node's value is closer to the target.
        if (Math.abs(target - closest) > Math.abs(target - currentValue)) {
            closest = currentValue;
        }

        // Traverse the left subtree if the target is less than the current value.
        if (currentValue > target) {
            return findClosestValueInBst(tree.left, target, closest);
        }
        // Traverse the right subtree if the target is greater than the current value.
        else if (currentValue < target) {
            return findClosestValueInBst(tree.right, target, closest);
        }
        // If the target equals the current value, return the current value as the closest.
        else {
            return closest;
        }
    }

    /**
     * Binary Search Tree (BST) node class.
     */
    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        // Create a sample BST
        BST root = new BST(10);
        root.left = new BST(5);
        root.right = new BST(15);
        root.left.left = new BST(2);
        root.left.right = new BST(5);
        root.right.right = new BST(22);

        // Test cases
        System.out.println("Closest to 12: " + findClosestValueInBst(root, 12)); // Output: 10
        System.out.println("Closest to 4: " + findClosestValueInBst(root, 4));  // Output: 5
        System.out.println("Closest to 24: " + findClosestValueInBst(root, 24)); // Output: 22
        System.out.println("Closest to 10: " + findClosestValueInBst(root, 10)); // Output: 10
    }
}
