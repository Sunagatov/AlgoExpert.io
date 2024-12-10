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
 * Topics: Binary Search Tree, Iteration
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
 * 2. Use an iterative approach:
 *    - Compare the current node's value to the target.
 *    - If the current value is closer to the target than the current closest value, update the closest.
 *    - Traverse left or right based on whether the target is less than or greater than the current value.
 *    - Stop when reaching a null node.
 * 3. Return the closest value after the traversal.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(log(n)) on average for balanced trees, where `n` is the number of nodes.
 * O(n) in the worst case for unbalanced trees.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), as the iterative approach uses no additional space beyond a few variables.
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

class FindClosestValueInBstWithDfsAndIterative {
    /**
     * Finds the value in the BST closest to the target using an iterative approach.
     *
     * @param tree   The root of the BST.
     * @param target The target value.
     * @return The value in the BST closest to the target.
     */
    public static int findClosestValueInBst(BST tree, int target) {
        int closest = tree.value; // Initialize closest to the root's value
        BST currentNode = tree; // Start traversal from the root

        // Traverse the tree iteratively
        while (currentNode != null) {
            int currentValue = currentNode.value;

            // Update closest if the current value is closer to the target
            if (Math.abs(target - closest) > Math.abs(target - currentValue)) {
                closest = currentValue;
            }

            // Traverse left or right based on the target's relation to the current value
            if (currentValue > target) {
                currentNode = currentNode.left;
            } else if (currentValue < target) {
                currentNode = currentNode.right;
            } else {
                break; // Exact match found
            }
        }

        return closest;
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
        root.right.left = new BST(13);
        root.right.right = new BST(22);
        root.left.left.left = new BST(1);

        // Test case
        int target = 12;
        int closestValue = findClosestValueInBst(root, target);
        System.out.println("Closest value to " + target + " is " + closestValue); // Output: 10
    }
}
