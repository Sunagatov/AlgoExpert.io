package two_pointers.medium;

/**
 * ----------------------------------------------------
 * 11. Container With Most Water
 * ----------------------------------------------------
 * <p>
 * Difficulty: Medium
 * ----------------------------------------------------
 * <p>
 * Topics: Two Pointers, Array
 * ----------------------------------------------------
 * <p>
 * Description:
 * You are given an integer array `heights` of length n. Each element represents the height of a vertical line drawn at a position on the x-axis. The task is to find two lines that together with the x-axis form a container, such that the container holds the most water.
 * <p>
 * You may not slant the container.
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the number of elements in the input array `heights`.
 * - The two-pointer approach ensures each element is processed at most once.
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), as we use a constant amount of space for variables and no extra data structures.
 * ----------------------------------------------------
 * <p>
 * Examples:
 * Example 1:
 * Input: heights = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The vertical lines at indices 1 and 8 (heights 8 and 7) form a container of width 7 and height 7.
 * <p>
 * Example 2:
 * Input: heights = [1,1]
 * Output: 1
 * Explanation: The only possible container has a width of 1 and a height of 1.
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Use two pointers, one starting at the beginning (`left`) and the other at the end (`right`) of the array.
 * 2. Calculate the area between the two lines at the pointers.
 * 3. Update the maximum area if the current area is greater.
 * 4. Move the pointer corresponding to the shorter line inward, as this may result in a taller container that could hold more water.
 * 5. Repeat until the two pointers meet.
 * ----------------------------------------------------
 * <p>
 * LeetCode Link: <a href="https://leetcode.com/problems/container-with-most-water/">Container With Most Water</a>
 * ----------------------------------------------------
 */

public class ContainerWithMostWaterWith2pointers {

    /**
     * Finds the maximum area of water that can be held by two lines.
     *
     * @param heights An array of integers representing the heights of vertical lines.
     * @return The maximum area of water that can be held.
     */
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int left = 0; // Pointer to the left line
        int right = heights.length - 1; // Pointer to the right line

        // Iterate while the two pointers do not cross
        while (left < right) {
            // Calculate the area using a separate method
            maxArea = Math.max(calculateArea(heights, left, right), maxArea);

            // Move the pointer corresponding to the shorter line inward
            if (heights[left] > heights[right]) {
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }

    /**
     * Calculates the area of water that can be held between two lines.
     *
     * @param heights The array of heights of the lines.
     * @param left    The index of the left line.
     * @param right   The index of the right line.
     * @return The area of water that can be held between the two lines.
     */
    private int calculateArea(int[] heights, int left, int right) {
        int height = Math.min(heights[left], heights[right]); // Shorter of the two lines determines the height
        int width = right - left; // Distance between the two lines determines the width
        return height * width;
    }

    public static void main(String[] args) {
        ContainerWithMostWaterWith2pointers solution = new ContainerWithMostWaterWith2pointers();

        // Test cases
        int[] heights1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Max Area (Test Case 1): " + solution.maxArea(heights1)); // Output: 49

        int[] heights2 = {1, 1};
        System.out.println("Max Area (Test Case 2): " + solution.maxArea(heights2)); // Output: 1

        int[] heights3 = {4, 3, 2, 1, 4};
        System.out.println("Max Area (Test Case 3): " + solution.maxArea(heights3)); // Output: 16

        int[] heights4 = {1, 2, 1};
        System.out.println("Max Area (Test Case 4): " + solution.maxArea(heights4)); // Output: 2
    }
}

