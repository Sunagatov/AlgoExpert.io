package arrays.medium;

import java.util.HashMap;
import java.util.Map;

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
 * - Each number is processed at most twice in the map operations.
 * <p>
 * Space Complexity:
 * O(n), where `n` is the length of the array.
 * - Space is used for the `HashMap` to store sequence boundaries.
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
 * Input: nums = [0,3,7,2,5,8,4,6,0,1]
 * Output: 9
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use a HashMap to store the length of consecutive sequences.
 * 2. Iterate through the input array:
 *    - For each number, check if it is already processed. If not:
 *      - Calculate the new sequence length by combining the left and right sequences adjacent to the current number.
 *      - Update the boundaries of the sequence in the map.
 *      - Track the maximum sequence length.
 * 3. Return the maximum sequence length.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Link to Task: <a href="https://leetcode.com/problems/longest-consecutive-sequence/">...</a>
 * ----------------------------------------------------
 */

public class LongestConsecutiveSeqWithMap {

    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        int res = 0;

        for (int num : nums) {
            if (mp.containsKey(num)) {
                continue;
            }
            int left = mp.getOrDefault(num - 1, 0);
            int right = mp.getOrDefault(num + 1, 0);
            int sequenceLength = left + right + 1;

            mp.put(num, sequenceLength);
            mp.put(num - left, sequenceLength);
            mp.put(num + right, sequenceLength);

            res = Math.max(res, sequenceLength);
        }
        return res;
    }

    public static void main(String[] args) {
        LongestConsecutiveSeqWithMap solution = new LongestConsecutiveSeqWithMap();

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
