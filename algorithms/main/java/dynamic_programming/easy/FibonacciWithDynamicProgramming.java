package dynamic_programming.easy;

/**
 * Fibonacci Sequence (Iterative Approach)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Dynamic Programming, Iterative
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * The Fibonacci sequence is defined as follows:
 * - F(0) = 0
 * - F(1) = 1
 * - F(n) = F(n-1) + F(n-2), for n >= 2
 * <p>
 * This program calculates the N-th Fibonacci number using an iterative approach.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Handle base cases:
 *    - If n == 0, return 0.
 *    - If n == 1, return 1.
 * 2. Use an array `lastTwo` to store the last two Fibonacci numbers.
 * 3. Iterate from the 2nd Fibonacci number up to the N-th Fibonacci number.
 * 4. Update the `lastTwo` array during each iteration:
 *    - Calculate the next Fibonacci number as the sum of the last two.
 *    - Shift the numbers in the array: move the second number to the first, and update the second with the calculated value.
 * 5. Return the second value in the `lastTwo` array, which represents the N-th Fibonacci number.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the input number.
 * - The loop iterates n times to compute the N-th Fibonacci number.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), constant space.
 * - Only two variables are used to store the last two Fibonacci numbers.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. F(0) -> 0
 * 2. F(1) -> 1
 * 3. F(2) -> 1
 * 4. F(3) -> 2
 * 5. F(5) -> 5
 * 6. F(10) -> 55
 * 7. Large input: F(50) -> 12586269025
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - n = 0 (minimum input).
 * - n = 1 (base case).
 * - Large values of n, to ensure the algorithm handles them efficiently.
 * <p>
 * ----------------------------------------------------
 */

public class FibonacciWithDynamicProgramming {

    /**
     * Calculates the N-th Fibonacci number using an iterative approach.
     *
     * @param n The position in the Fibonacci sequence.
     * @return The N-th Fibonacci number.
     */
    public int fib(int n) {
        if (n == 0) return 0; // Base case: F(0) = 0
        if (n == 1) return 1; // Base case: F(1) = 1

        // Store the last two Fibonacci numbers
        int[] lastTwo = {0, 1};
        int counter = 2;

        // Iterate from the 2nd Fibonacci number to the N-th
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1]; // Calculate the next Fibonacci number
            lastTwo[0] = lastTwo[1]; // Update the first number
            lastTwo[1] = nextFib; // Update the second number
            counter++;
        }

        return lastTwo[1]; // Return the N-th Fibonacci number
    }

    public static void main(String[] args) {
        FibonacciWithDynamicProgramming solution = new FibonacciWithDynamicProgramming();

        // Test cases
        System.out.println("F(0): " + solution.fib(0)); // 0
        System.out.println("F(1): " + solution.fib(1)); // 1
        System.out.println("F(2): " + solution.fib(2)); // 1
        System.out.println("F(3): " + solution.fib(3)); // 2
        System.out.println("F(5): " + solution.fib(5)); // 5
        System.out.println("F(10): " + solution.fib(10)); // 55
        System.out.println("F(50): " + solution.fib(50)); // 12586269025
    }
}
