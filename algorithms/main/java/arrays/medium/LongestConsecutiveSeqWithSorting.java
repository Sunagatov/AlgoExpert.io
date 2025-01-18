package arrays.medium;

import java.util.Arrays;

/**
 * ----------------------------------------------------
 * Longest Consecutive Sequence
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.
 * You must write an algorithm that runs in O(n) time.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n log n), where `n` is the length of the array.
 * - Sorting the array takes O(n log n).
 * - Iterating through the array is O(n).
 * <p>
 * Space Complexity:
 * O(1) additional space, assuming the sorting operation is in-place.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: nums = [100, 4, 200, 1, 3, 2]
 * Output: 4
 * Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 * <p>
 * Example 2:
 * Input: nums = [0, 3, 7, 2, 5, 8, 4, 6, 0, 1]
 * Output: 9
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Sort the array to bring consecutive elements together.
 * 2. Iterate through the array to count the length of consecutive sequences.
 *    - Skip duplicate elements.
 *    - Count streaks for consecutive elements.
 * 3. Track the maximum streak length.
 * 4. Return the maximum streak length.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Link to Task: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">...</a>
 * ----------------------------------------------------
 */

public class LongestConsecutiveSeqWithSorting {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int res = 0, curr = nums[0], streak = 0, i = 0;

        while (i < nums.length) {

            // It means the current value is different from the previous one,
            // so reset the streak to 0 and update curr
            if (curr != nums[i]) {
                curr = nums[i];
                streak = 0;
            }

            // Skip Duplicates
            while (i < nums.length && nums[i] == curr) {
                i++;
            }

            streak++;
            curr++;
            res = Math.max(res, streak);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSeqWithSorting solution = new LongestConsecutiveSeqWithSorting();

        // Test case 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println("Test Case 1: " + solution.longestConsecutive(nums1)); // Expected: 4

        // Test case 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println("Test Case 2: " + solution.longestConsecutive(nums2)); // Expected: 9

        // Test case 3
        int[] nums3 = {};
        System.out.println("Test Case 3: " + solution.longestConsecutive(nums3)); // Expected: 0

        // Test case 4
        int[] nums4 = {1, 2, 0, 1};
        System.out.println("Test Case 4: " + solution.longestConsecutive(nums4)); // Expected: 3

        // Test case 5
        int[] nums5 = {9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6};
        System.out.println("Test Case 5: " + solution.longestConsecutive(nums5)); // Expected: 7
    }
}
