package recursion.easy;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * Fibonacci Sequence (Using Recursion)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Recursion, Dynamic Programming
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * The Fibonacci sequence is defined as follows:
 * - F(1) = 0
 * - F(2) = 1
 * - F(n) = F(n-1) + F(n-2), for n > 2
 * <p>
 * This program calculates the N-th Fibonacci number using recursion.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * - Base Cases:
 *   - If n == 1, return 0 (F(1) = 0).
 *   - If n == 2, return 1 (F(2) = 1).
 * - Recursive Case:
 *   - Return getNthFib(n - 1) + getNthFib(n - 2).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(2^n), where n is the input number.
 * - Each function call spawns two new calls, leading to an exponential growth in calls.
 * <p>
 * Space Complexity:
 * O(n), where n is the depth of the recursive call stack.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. F(1) -> 0
 * 2. F(2) -> 1
 * 3. F(3) -> 1
 * 4. F(4) -> 2
 * 5. F(5) -> 3
 * 6. F(6) -> 5
 * 7. Large input: F(10) -> 34
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - n = 1 (smallest input).
 * - n = 2 (base case).
 * - Large values of n, where recursion becomes inefficient.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Notes:
 * This recursive approach is not efficient for large inputs due to exponential time complexity.
 * For better performance, consider using memoization or an iterative solution.
 * <p>
 * ----------------------------------------------------
 */

public class FibonacciWithRecursion {

    /**
     * Calculates the N-th Fibonacci number using recursion.
     *
     * @param n The position in the Fibonacci sequence.
     * @return The N-th Fibonacci number.
     */
    public static int getNthFib(int n) {
        // Base cases
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        // Recursive case
        return getNthFib(n - 1) + getNthFib(n - 2);
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println("F(1): " + getNthFib(1)); // 0
        System.out.println("F(2): " + getNthFib(2)); // 1
        System.out.println("F(3): " + getNthFib(3)); // 1
        System.out.println("F(4): " + getNthFib(4)); // 2
        System.out.println("F(5): " + getNthFib(5)); // 3
        System.out.println("F(6): " + getNthFib(6)); // 5
        System.out.println("F(10): " + getNthFib(10)); // 34
    }
}
