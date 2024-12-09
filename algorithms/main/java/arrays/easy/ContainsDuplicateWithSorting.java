package arrays.easy;

import java.util.Arrays;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 217. Contains Duplicate (Using Sorting)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Array, Sorting
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/contains-duplicate/">link</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an integer array `nums`, return true if any value appears at least twice
 * in the array, and return false if every element is distinct.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Sort the input array.
 * 2. Iterate through the array and compare each element with its previous element.
 * 3. If any two adjacent elements are equal, return true (duplicate found).
 * 4. If no duplicates are found after iterating through the array, return false.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n log n), where n is the length of the input array.
 * - Sorting the array takes O(n log n).
 * - Iterating through the array takes O(n).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), assuming the sorting is done in-place.
 * - No additional data structures are used.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Standard case with duplicates: [1, 2, 3, 4, 2] -> true
 * 2. No duplicates: [1, 2, 3, 4, 5] -> false
 * 3. Single element: [1] -> false
 * 4. Empty array: [] -> false
 * 5. All elements the same: [7, 7, 7, 7] -> true
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Empty array (should return false).
 * - Single element array (should return false).
 * - Very large input array with no duplicates (performance test).
 * <p>
 * ----------------------------------------------------
 */

public class ContainsDuplicateWithSorting {

    /**
     * Checks if the array contains any duplicate values using sorting.
     *
     * @param nums The input array of integers.
     * @return true if there are duplicates, false otherwise.
     */
    public boolean hasDuplicate(int[] nums) {
        // Sort the array
        Arrays.sort(nums);

        // Iterate through the sorted array and check for duplicates
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index - 1]) {
                return true; // Duplicate found
            }
        }

        return false; // No duplicates found
    }

    public static void main(String[] args) {
        ContainsDuplicateWithSorting solution = new ContainsDuplicateWithSorting();

        // Test cases
        int[] nums1 = {1, 2, 3, 4, 2};
        System.out.println("Test Case 1: " + solution.hasDuplicate(nums1)); // true

        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + solution.hasDuplicate(nums2)); // false

        int[] nums3 = {1};
        System.out.println("Test Case 3: " + solution.hasDuplicate(nums3)); // false

        int[] nums4 = {};
        System.out.println("Test Case 4: " + solution.hasDuplicate(nums4)); // false

        int[] nums5 = {7, 7, 7, 7};
        System.out.println("Test Case 5: " + solution.hasDuplicate(nums5)); // true
    }
}
