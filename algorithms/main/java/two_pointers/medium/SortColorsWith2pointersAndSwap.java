package two_pointers.medium;

import java.util.Arrays;

/**
 * ----------------------------------------------------
 * 75. Sort Colors
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Two Pointers, Sorting
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/sort-colors/">link</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the length of the array.
 * - We make a single pass through the array, swapping elements into place.
 * <p>
 * Space Complexity:
 * O(1) auxiliary space.
 * - Sorting is done in-place using pointers, requiring no extra data structures.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given an array `nums` with n objects colored red (0), white (1), or blue (2),
 * sort them in-place so that objects of the same color are adjacent, with the order
 * red (0), white (1), and blue (2).
 * <p>
 * You must solve this problem without using the library's sort function.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input: nums = [2,0,2,1,1,0]
 * Output: [0,0,1,1,2,2]
 * <p>
 * Example 2:
 * Input: nums = [2,0,1]
 * Output: [0,1,2]
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * This is a classic "Dutch National Flag" problem:
 * 1. Maintain three pointers: low, mid, and high.
 *    - low tracks the boundary of where 0s should be placed.
 *    - mid is the current element under consideration.
 *    - high tracks the boundary of where 2s should be placed.
 * <p>
 * 2. Initially, low = mid = 0 and high = nums.length - 1.
 * <p>
 * 3. While mid <= high:
 *    - If nums[mid] == 0: swap nums[low] and nums[mid], increment low and mid.
 *    - If nums[mid] == 1: just increment mid (it's in correct place).
 *    - If nums[mid] == 2: swap nums[mid] and nums[high], decrement high (don't increment mid yet, as we need to check the swapped element).
 * <p>
 * 4. After one pass, the array is partitioned such that all 0s, then all 1s, and all 2s are grouped.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Possible Follow-ups:
 * - What if we have more than three colors? The approach can be extended to multiple buckets, but complexity rises.
 * - Could we do this with a single pass without using extra checks? Yes, the given approach is already one-pass.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Mixed colors: [2,0,2,1,1,0] -> [0,0,1,1,2,2]
 * 2. Already sorted: [0,0,1,1,2,2] -> [0,0,1,1,2,2]
 * 3. Reverse sorted: [2,2,1,1,0,0] -> [0,0,1,1,2,2]
 * 4. All same color: [0,0,0] -> [0,0,0]
 * 5. Single element: [1] -> [1]
 * <p>
 * Edge Cases:
 * - Array of length 1 (just return as is).
 * - All elements are the same color.
 * - No 0s, no 1s, or no 2s in the array.
 * <p>
 * ----------------------------------------------------
 */

public class SortColorsWith2pointersAndSwap {

    public static void sortColors(int[] nums) {
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;

        while (mid <= high) {
            if (nums[mid] == 0) { //Red
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) { //White
                mid++;
            } else { // nums[mid] == 2, Blue
                swap(nums, mid, high);
                high--;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test1 = {2,0,2,1,1,0};
        sortColors(test1);
        System.out.println("After sorting: " + Arrays.toString(test1)); // [0,0,1,1,2,2]

        int[] test2 = {2,0,1};
        sortColors(test2);
        System.out.println("After sorting: " + Arrays.toString(test2)); // [0,1,2]

        int[] test3 = {0};
        sortColors(test3);
        System.out.println("After sorting: " + Arrays.toString(test3)); // [0]

        int[] test4 = {1,1,1};
        sortColors(test4);
        System.out.println("After sorting: " + Arrays.toString(test4)); // [1,1,1]

        int[] test5 = {2,2,0,0,1,1};
        sortColors(test5);
        System.out.println("After sorting: " + Arrays.toString(test5)); // [0,0,1,1,2,2]
    }
}
