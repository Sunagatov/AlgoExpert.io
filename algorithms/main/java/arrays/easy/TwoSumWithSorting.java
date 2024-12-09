package arrays.easy;

import java.util.Arrays;
import java.util.Comparator;

    /**
     * <p>
     * ----------------------------------------------------
     * <p>
     * 1. Two Sum (Using Sorting)
     * <p>
     * ----------------------------------------------------
     * <p>
     * Difficulty: Easy
     * <p>
     * ----------------------------------------------------
     * <p>
     * Topics: Array, Sorting, Two Pointers
     * <p>
     * ----------------------------------------------------
     * <p>
     * LeetCode: <a href="https://leetcode.com/problems/two-sum/">link</a>
     * <p>
     * ----------------------------------------------------
     * <p>
     * Description:
     * Given an array of integers `nums` and an integer `target`, return indices of the two
     * numbers such that they add up to `target`.
     * <p>
     * You may assume that each input would have exactly one solution, and you may not
     * use the same element twice. The returned indices must be sorted in ascending order.
     * <p>
     * ----------------------------------------------------
     * <p>
     * Algorithm:
     * This approach uses sorting and two pointers to efficiently find the solution.
     * <p>
     * 1. Create a 2D array where each element stores the original number and its index.
     * 2. Sort the 2D array by the original number values.
     * 3. Use two pointers (`left` and `right`):
     *    - If the sum of the numbers at the pointers equals the target, return their indices.
     *    - If the sum is less than the target, move the `left` pointer forward to increase the sum.
     *    - If the sum is greater than the target, move the `right` pointer backward to decrease the sum.
     * <p>
     * 4. Return an empty array if no solution exists (though it's guaranteed in the problem description).
     * <p>
     * ----------------------------------------------------
     * <p>
     * Time Complexity:
     * O(n log n), where n is the length of the input array.
     * - Sorting the array takes O(n log n).
     * - The two-pointer search takes O(n).
     * <p>
     * ----------------------------------------------------
     * <p>
     * Space Complexity:
     * O(n), for the additional 2D array that stores the original numbers and their indices.
     * <p>
     * ----------------------------------------------------
     * <p>
     * Test Cases:
     * 1. Standard case: [2, 7, 11, 15], target = 9 -> [0, 1]
     * 2. Duplicates: [3, 3], target = 6 -> [0, 1]
     * 3. Negative numbers: [-3, 4, 3, 90], target = 0 -> [0, 2]
     * 4. Large numbers: [1000000000, 3, 3, 90], target = 1000000090 -> [0, 3]
     * <p>
     * ----------------------------------------------------
     * <p>
     * Edge Cases:
     * - Single element array (invalid input, not allowed as per constraints).
     * - Array with no valid pairs (not possible as per constraints).
     * <p>
     * ----------------------------------------------------
     */
    public class TwoSumWithSorting {

        /**
         * Finds indices of two numbers that add up to the target.
         *
         * @param nums   The input array of integers.
         * @param target The target sum.
         * @return Indices of the two numbers in ascending order.
         */
        public int[] twoSum(int[] nums, int target) {
            // Create a 2D array to store the original numbers and their indices
            int[][] valueWithIndex = new int[nums.length][2];
            for (int index = 0; index < nums.length; index++) {
                valueWithIndex[index][0] = nums[index]; // Store the value
                valueWithIndex[index][1] = index;       // Store the original index
            }

            // Sort the 2D array by the values (first column)
            Arrays.sort(valueWithIndex, Comparator.comparingInt(a -> a[0]));

            // Initialize two pointers
            int left = 0;
            int right = nums.length - 1;

            // Use two pointers to find the target sum
            while (left < right) {
                int leftValue = valueWithIndex[left][0];
                int rightValue = valueWithIndex[right][0];
                int currentSum = leftValue + rightValue;

                if (currentSum == target) {
                    // Return the indices in ascending order
                    return new int[]{
                            Math.min(valueWithIndex[left][1], valueWithIndex[right][1]),
                            Math.max(valueWithIndex[left][1], valueWithIndex[right][1])
                    };
                } else if (currentSum < target) {
                    left++; // Move the left pointer forward to increase the sum
                } else {
                    right--; // Move the right pointer backward to decrease the sum
                }
            }

            // Return an empty array (this will not be reached due to problem constraints)
            return new int[0];
        }

        public static void main(String[] args) {
            TwoSumWithSorting solution = new TwoSumWithSorting();

            // Test cases
            int[] nums1 = {2, 7, 11, 15};
            int target1 = 9;
            System.out.println("Test Case 1: " + Arrays.toString(solution.twoSum(nums1, target1))); // [0, 1]

            int[] nums2 = {3, 3};
            int target2 = 6;
            System.out.println("Test Case 2: " + Arrays.toString(solution.twoSum(nums2, target2))); // [0, 1]

            int[] nums3 = {-3, 4, 3, 90};
            int target3 = 0;
            System.out.println("Test Case 3: " + Arrays.toString(solution.twoSum(nums3, target3))); // [0, 2]

            int[] nums4 = {1, 2, 3, 4, 5, 6};
            int target4 = 7;
            System.out.println("Test Case 4: " + Arrays.toString(solution.twoSum(nums4, target4))); // [0, 5]
        }
    }
