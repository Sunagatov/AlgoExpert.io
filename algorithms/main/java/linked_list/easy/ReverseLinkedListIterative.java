package linked_list.easy;

/**
 * Reverse Linked List
 * <p>
 * ----------------------------------------------------
 * <p>
 * Difficulty: Easy
 * <p>
 * ----------------------------------------------------
 * <p>
 * Topics: Linked List, Iterative Approach
 * <p>
 * ----------------------------------------------------
 * <p>
 * LeetCode: <a href="https://leetcode.com/problems/reverse-linked-list/">https://leetcode.com/problems/reverse-linked-list/</a>
 * <p>
 * ----------------------------------------------------
 * <p>
 * Description:
 * Given the head of a singly linked list, reverse the list and return its head.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Algorithm:
 * 1. Initialize three pointers:
 *    - `previousNode` to track the reversed portion of the list (initially null).
 *    - `currentNode` to traverse the list (initially the head).
 *    - `nextNode` to temporarily store the next node (to prevent breaking the chain).
 * 2. While the `currentNode` is not null:
 *    - Store the next node in `nextNode`.
 *    - Reverse the current node's pointer by pointing it to `previousNode`.
 *    - Move `previousNode` to the current node.
 *    - Move `currentNode` to the next node (stored in `nextNode`).
 * 3. Once the traversal is complete, `previousNode` will point to the new head of the reversed list.
 * 4. Return `previousNode`.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Time Complexity:
 * O(n), where `n` is the number of nodes in the linked list.
 * - Each node is visited once during the traversal.
 * <p>
 * ----------------------------------------------------
 * <p>
 * Space Complexity:
 * O(1), constant space is used for the three pointers (`previousNode`, `currentNode`, and `nextNode`).
 * <p>
 * ----------------------------------------------------
 * <p>
 * Test Cases:
 * 1. Input: [1, 2, 3, 4, 5]
 *    Output: [5, 4, 3, 2, 1]
 * 2. Input: [1, 2]
 *    Output: [2, 1]
 * 3. Input: [1]
 *    Output: [1]
 * 4. Input: []
 *    Output: []
 * <p>
 * ----------------------------------------------------
 * <p>
 * Edge Cases:
 * - Empty list (null head).
 * - Single-node list.
 * - Already reversed list.
 * <p>
 * ----------------------------------------------------
 */

public class ReverseLinkedListIterative {

    /**
     * Reverses a singly linked list.
     *
     * @param head The head of the linked list.
     * @return The head of the reversed linked list.
     */
    public ListNode reverseList(ListNode head) {
        ListNode previousNode = null; // Tracks the reversed portion of the list
        ListNode currentNode = head; // Tracks the node being processed

        while (currentNode != null) {
            // Temporarily store the next node
            ListNode nextNode = currentNode.next;

            // Reverse the current node's pointer
            currentNode.next = previousNode;

            // Move pointers forward
            previousNode = currentNode;
            currentNode = nextNode;
        }

        // At the end, previousNode is the new head
        return previousNode;
    }

    public static void main(String[] args) {
        // Test case 1: [1, 2, 3, 4, 5]
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ReverseLinkedListIterative solution = new ReverseLinkedListIterative();
        ListNode reversedHead1 = solution.reverseList(head1);
        printList(reversedHead1); // Expected Output: 5 -> 4 -> 3 -> 2 -> 1

        // Test case 2: [1]
        ListNode head2 = new ListNode(1);
        ListNode reversedHead2 = solution.reverseList(head2);
        printList(reversedHead2); // Expected Output: 1

        // Test case 3: []
        ListNode head3 = null;
        ListNode reversedHead3 = solution.reverseList(head3);
        printList(reversedHead3); // Expected Output: []

        // Test case 4: [1, 2]
        ListNode head4 = new ListNode(1);
        head4.next = new ListNode(2);
        ListNode reversedHead4 = solution.reverseList(head4);
        printList(reversedHead4); // Expected Output: 2 -> 1
    }

    /**
     * Helper function to print a linked list.
     *
     * @param head The head of the linked list.
     */
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
