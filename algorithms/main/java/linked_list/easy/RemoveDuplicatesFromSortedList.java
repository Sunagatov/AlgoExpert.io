package linked_list.easy;

/**
 * ----------------------------------------------------
 * Remove Duplicates From Linked List
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * ----------------------------------------------------
 * <p>
 * Topics: Linked List, Iteration
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given a sorted linked list, remove all duplicate nodes such that each element appears only once.
 * The linked list is guaranteed to be sorted, which allows us to compare consecutive nodes directly.
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where n is the number of nodes in the linked list.
 * - We traverse each node exactly once.
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1)
 * - No additional data structures are used; the solution works in-place.
 * ----------------------------------------------------
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * Input:
 * LinkedList: 1 -> 1 -> 2
 * Output:
 * LinkedList: 1 -> 2
 * <p>
 * Example 2:
 * Input:
 * LinkedList: 1 -> 1 -> 2 -> 3 -> 3
 * Output:
 * LinkedList: 1 -> 2 -> 3
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * - Start with the head of the linked list.
 * - Iterate through the linked list while the current node and the next node are not null:
 *   - If the value of the current node equals the value of the next node, skip the next node.
 *   - Otherwise, move to the next node.
 * - Return the modified linked list.
 * ----------------------------------------------------
 * <p>
 * LeetCode Link: <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-list/">Remove Duplicates From Sorted List</a>
 * ----------------------------------------------------
 */

public class RemoveDuplicatesFromSortedList {

    /**
     * Removes duplicates from a sorted linked list.
     *
     * @param linkedList The head of the sorted linked list.
     * @return The modified linked list with duplicates removed.
     */
    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList currentNode = linkedList;

        // Traverse the linked list
        while (currentNode != null && currentNode.next != null) {
            // If the current node's value equals the next node's value, skip the next node
            if (currentNode.value == currentNode.next.value) {
                currentNode.next = currentNode.next.next;
            } else {
                // Otherwise, move to the next node
                currentNode = currentNode.next;
            }
        }

        return linkedList;
    }

    // Input class for the linked list
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        // Create test linked list: 1 -> 1 -> 2 -> 3 -> 3
        LinkedList head = new LinkedList(1);
        head.next = new LinkedList(1);
        head.next.next = new LinkedList(2);
        head.next.next.next = new LinkedList(3);
        head.next.next.next.next = new LinkedList(3);

        // Create the program instance
        RemoveDuplicatesFromSortedList program = new RemoveDuplicatesFromSortedList();

        // Remove duplicates
        LinkedList result = program.removeDuplicatesFromLinkedList(head);

        // Print the modified linked list
        System.out.print("Modified Linked List: ");
        printLinkedList(result);
    }

    /**
     * Helper method to print the linked list.
     *
     * @param head The head of the linked list to be printed.
     */
    private static void printLinkedList(LinkedList head) {
        LinkedList currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " -> ");
            currentNode = currentNode.next;
        }
        System.out.println("null");
    }
}
