package arrays.medium;

import java.util.HashSet;
import java.util.Set;

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
 * O(n), where `n` is the length of the array.
 * - Each number is processed at most once.
 * <p>
 * Space Complexity:
 * O(n), where `n` is the length of the array.
 * - Space is used for the `HashSet` to store unique numbers.
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
 * 1. Use a HashSet to store all numbers from the input array for O(1) lookups.
 * 2. Iterate through the input array:
 *    - For each number, count the length of the consecutive sequence starting at that number.
 *    - Track the maximum sequence length encountered.
 * 3. Return the maximum sequence length.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Link to Task: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">...</a>
 * ----------------------------------------------------
 */

public class LongestConsecutiveSeqWithSet {

    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> store = new HashSet<>();
        for (int num : nums) {
            store.add(num);
        }

        for (int num : nums) {
            if (!store.contains(num - 1)) { // Start of a new sequence
                int streak = 0, curr = num;
                while (store.contains(curr)) {
                    streak++;
                    curr++;
                }
                res = Math.max(res, streak);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSeqWithSet solution = new LongestConsecutiveSeqWithSet();

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

