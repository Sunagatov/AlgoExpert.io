package arrays.easy;

import java.util.Arrays;

/**
 * <p>
 * ----------------------------------------------------
 * <p>
 * 217. Contains Duplicate (Using HashSet Length Comparison)
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Array, HashSet, Streams
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
 * 1. Convert the input array `nums` into a stream.
 * 2. Use `distinct()` to filter out duplicate elements.
 * 3. Count the number of distinct elements in the stream.
 * 4. Compare the count of distinct elements with the length of the input array.
 *    - If the count of distinct elements is less than the length of the array,
 *      it means there are duplicates.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the input array.
 * - Creating a stream and filtering duplicates using `distinct()` is O(n).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(n), for storing the distinct elements internally during the stream operation.
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

public class ContainsDuplicateWithHashsetLength {

    /**
     * Checks if the array contains any duplicate values using streams.
     *
     * @param nums The input array of integers.
     * @return true if there are duplicates, false otherwise.
     */
    public boolean hasDuplicate(int[] nums) {
        // Use streams to filter distinct elements and compare their count with the array length
        return Arrays.stream(nums).distinct().count() < nums.length;
    }

    public static void main(String[] args) {
        ContainsDuplicateWithHashsetLength solution = new ContainsDuplicateWithHashsetLength();

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
