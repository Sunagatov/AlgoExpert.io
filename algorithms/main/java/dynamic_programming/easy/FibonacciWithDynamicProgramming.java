package dynamic_programming.easy;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * Fibonacci Sequence (Iterative Approach)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Iteration, Dynamic Programming
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * The Fibonacci sequence is defined as follows:
 * - F(1) = 0
 * - F(2) = 1
 * - F(n) = F(n-1) + F(n-2), for n > 2
 * <p>
 * This program calculates the N-th Fibonacci number using an iterative approach.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use an array `lastTwo` of size 2 to store the last two Fibonacci numbers.
 * 2. Start from the 3rd Fibonacci number and calculate up to the N-th Fibonacci number:
 *    - Calculate the next Fibonacci number as the sum of the two previous numbers.
 *    - Update `lastTwo[0]` to the previous value of `lastTwo[1]`.
 *    - Update `lastTwo[1]` to the newly calculated Fibonacci number.
 * 3. Return `lastTwo[1]` if n > 1, otherwise return `lastTwo[0]`.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the input number.
 * - The loop iterates n - 2 times.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), constant space.
 * - Only an array of size 2 is used to store the last two Fibonacci numbers.
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
 * - Large values of n.
 * <p>
 * ----------------------------------------------------
 */

class FibonacciWithDynamicProgramming {

    /**
     * Calculates the N-th Fibonacci number using an iterative approach.
     *
     * @param n The position in the Fibonacci sequence.
     * @return The N-th Fibonacci number.
     */
    public static int getNthFib(int n) {
        // Store the last two Fibonacci numbers
        int[] lastTwo = {0, 1};
        int counter = 3;

        // Iterate from the 3rd Fibonacci number to the N-th
        while (counter <= n) {
            int nextFib = lastTwo[0] + lastTwo[1]; // Calculate the next Fibonacci number
            lastTwo[0] = lastTwo[1]; // Update the first number
            lastTwo[1] = nextFib; // Update the second number
            counter++;
        }

        // Return the appropriate Fibonacci number based on the input
        return n > 1 ? lastTwo[1] : lastTwo[0];
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
