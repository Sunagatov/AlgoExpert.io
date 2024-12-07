package string.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ----------------------------------------------------
 * 15. 3Sum
 * ----------------------------------------------------
 *
 * Difficulty: Medium
 *
 * ----------------------------------------------------
 *
 * Topics: Two Pointers, Sorting
 *
 * ----------------------------------------------------
 *
 * Leetcode: https://leetcode.com/problems/3sum/
 *
 * ----------------------------------------------------
 *
 * Time Complexity:
 * O(n^2), where n is the length of the input array.
 * - Sorting the array takes O(n log n).
 * - The nested loop with the two-pointer approach takes O(n^2) in the worst case.
 * - Therefore, the overall complexity is O(n^2).
 *
 * Space Complexity:
 * O(1) auxiliary space.
 * - Aside from the output list, no additional data structures are used.
 * - Sorting modifies the array in-place.
 *
 * ----------------------------------------------------
 *
 * Description:
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * The solution set must not contain duplicate triplets.
 *
 * ----------------------------------------------------
 *
 * Examples:
 *
 * Example 1:
 * Input: nums = [-1, 0, 1, 2, -1, -4]
 * Output: [[-1, -1, 2], [-1, 0, 1]]
 * Explanation: The two triplets that sum to zero are:
 * - [-1, -1, 2]
 * - [-1, 0, 1]
 *
 * Example 2:
 * Input: nums = [0, 1, 1]
 * Output: []
 * Explanation: There are no triplets that sum to zero.
 *
 * Example 3:
 * Input: nums = [0, 0, 0]
 * Output: [[0, 0, 0]]
 * Explanation: The only triplet that sums to zero is [0, 0, 0].
 *
 * ----------------------------------------------------
 *
 * Algorithm:
 * 1. Sort the input array.
 * 2. Use an outer loop to iterate through the array, treating each element as a candidate for the first
 *    element of the triplet.
 * 3. Use two pointers (left and right) to find pairs that sum to the negative of the first element.
 * 4. Skip duplicate elements in the array to avoid duplicate triplets.
 * 5. Add valid triplets to the result list.
 *
 * ----------------------------------------------------
 */

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1; // Left pointer
            int right = nums.length - 1; // Right pointer

            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                if (currentSum == 0) {
                    // Found a triplet
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate second elements
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    // Skip duplicate third elements
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move both pointers after finding a valid triplet
                    left++;
                    right--;
                } else if (currentSum < 0) {
                    // If the sum is too small, move the left pointer to the right
                    left++;
                } else {
                    // If the sum is too large, move the right pointer to the left
                    right--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test cases
        int[][] testCases = {
                {-1, 0, 1, 2, -1, -4}, // [[-1, -1, 2], [-1, 0, 1]]
                {0, 1, 1},             // []
                {0, 0, 0},             // [[0, 0, 0]]
                {-4, -2, 1, 2, 3, 0, 0, 4} // [[-4, 0, 4], [-4, 1, 3], [-2, -1, 3], [-2, 0, 2]]
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case #" + (i + 1));
            System.out.println("Input: " + Arrays.toString(testCases[i]));
            System.out.println("Output: " + threeSum(testCases[i]));
            System.out.println("------------------------------------");
        }
    }
}
