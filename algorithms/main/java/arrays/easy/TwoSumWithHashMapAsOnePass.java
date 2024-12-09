package arrays.easy;

import java.util.HashMap;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 1. Two Sum (Using Hash Map - One Pass)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Array, Hash Map
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
 * use the same element twice. The returned indices can be in any order.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * This approach uses a Hash Map to store the numbers we've seen so far and their indices.
 * <p>
 * 1. Iterate through the array.
 * 2. For each number, calculate the difference (`target - currentNumber`).
 * 3. Check if the difference exists in the Hash Map:
 *    - If it does, return the indices of the difference and the current number.
 *    - If not, store the current number and its index in the Hash Map.
 * <p>
 * 4. Return an empty array (though the problem guarantees a solution exists).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the input array.
 * - Each number is processed once, and Hash Map operations (get/put) are O(1) on average.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), for the Hash Map that stores up to n elements.
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
 * - Array with two elements only (guaranteed solution).
 * - Large array with no duplicates (performance test).
 * <p>
 * ----------------------------------------------------
 */

public class TwoSumWithHashMapAsOnePass {

    /**
     * Finds indices of two numbers that add up to the target using a Hash Map in one pass.
     *
     * @param nums   The input array of integers.
     * @param target The target sum.
     * @return Indices of the two numbers in any order.
     */
    public int[] twoSum(int[] nums, int target) {
        // Hash Map to store previously seen numbers and their indices
        HashMap<Integer, Integer> numberToIndexMap = new HashMap<>();

        // Iterate through the array
        for (int currentIndex = 0; currentIndex < nums.length; currentIndex++) {
            int currentNumber = nums[currentIndex];
            int complement = target - currentNumber; // The number needed to reach the target

            // Check if the complement exists in the map
            if (numberToIndexMap.containsKey(complement)) {
                return new int[]{numberToIndexMap.get(complement), currentIndex};
            }

            // Store the current number and its index in the map
            numberToIndexMap.put(currentNumber, currentIndex);
        }

        // Return an empty array (this will not be reached due to problem constraints)
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSumWithHashMapAsOnePass solution = new TwoSumWithHashMapAsOnePass();

        // Test cases
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("Test Case 1: " + java.util.Arrays.toString(solution.twoSum(nums1, target1))); // [0, 1]

        int[] nums2 = {3, 3};
        int target2 = 6;
        System.out.println("Test Case 2: " + java.util.Arrays.toString(solution.twoSum(nums2, target2))); // [0, 1]

        int[] nums3 = {-3, 4, 3, 90};
        int target3 = 0;
        System.out.println("Test Case 3: " + java.util.Arrays.toString(solution.twoSum(nums3, target3))); // [0, 2]

        int[] nums4 = {1, 2, 3, 4, 5, 6};
        int target4 = 7;
        System.out.println("Test Case 4: " + java.util.Arrays.toString(solution.twoSum(nums4, target4))); // [0, 5]
    }
}
