package two_pointers.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * ----------------------------------------------------
 * 19. Remove Nth Node From End of List
 * ----------------------------------------------------
 *
 * Difficulty: Medium
 *
 * ----------------------------------------------------
 *
 * Topics: Linked List, Two Pointers
 *
 * ----------------------------------------------------
 *
 * LeetCode: https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
 *
 * ----------------------------------------------------
 *
 * Time Complexity:
 * O(n), where n is the length of the linked list.
 * - We traverse the list at most twice: once to advance the fast pointer and once to move both slow and fast.
 *
 * Space Complexity:
 * O(1) auxiliary space.
 * - We only use a few pointers, no extra data structures.
 *
 * ----------------------------------------------------
 *
 * Description:
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 *
 * ----------------------------------------------------
 *
 * Idea of the Approach:
 * 1. Use two pointers: a fast pointer and a slow pointer.
 * 2. Advance the fast pointer by n steps. By doing this, the gap between fast and slow will be n.
 * 3. Move both slow and fast pointers together until fast reaches the end. At this point, slow will be at the node
 *    just before the target node.
 * 4. Remove the target node by changing the next pointer of the slow node.
 *
 * This approach ensures we only make one pass through the list (after the initial setup), resulting in O(n) time.
 *
 * ----------------------------------------------------
 *
 * Possible Follow-ups:
 * - If we need to remove multiple nodes, we can repeat the same procedure or consider a single pass approach that
 *   removes all specified nodes in one traversal.
 * - Consider edge cases like removing the head node itself or when the list has only one node.
 * - For a doubly linked list, the approach is similar, but updating pointers might be slightly different.
 *
 * ----------------------------------------------------
 *
 * Examples / Test Cases:
 *
 * 1. Input: head = [1,2,3,4,5], n = 2
 *    Output: [1,2,3,5]
 *    Explanation: The node "4" is the second from last. Removing it yields [1,2,3,5].
 *
 * 2. Input: head = [1], n = 1
 *    Output: []
 *    Explanation: Removing the only node results in an empty list.
 *
 * 3. Input: head = [1,2], n = 1
 *    Output: [1]
 *    Explanation: Removing the last node (2) results in [1].
 *
 * Edge Cases:
 * - Removing the head node (e.g., n equals the length of the list).
 * - The list has only one node.
 * - The value of n is always valid as per the problem statement, but if not, handle invalid inputs gracefully.
 *
 * ----------------------------------------------------
 *
 * Algorithm:
 * 1. Create a dummy node that points to head to simplify edge cases.
 * 2. Set slow and fast pointers to the dummy node.
 * 3. Advance fast pointer n+1 times so that there is a gap of n nodes between slow and fast.
 * 4. Move slow and fast together until fast reaches the end.
 * 5. Remove the node after slow by adjusting slow.next.
 * 6. Return dummy.next as the new head.
 *
 * ----------------------------------------------------
 */

public class RemoveNthLastNode {

    public static LinkedListNode removeNthLastNode(LinkedListNode head, int n) {
        // Create a dummy node to handle edge cases (e.g., removing head)
        LinkedListNode dummy = new LinkedListNode(0);
        dummy.next = head;

        LinkedListNode slow = dummy;
        LinkedListNode fast = head;

        // Move fast pointer n+1 steps ahead so that there's an n-node gap
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Now slow is at the node before the one to remove
        slow.next = slow.next.next;

        return dummy.next;
    }

    public static void main(String[] args) {
        // Test Case 1: [1,2,3,4,5], n=2 => [1,2,3,5]
        LinkedListNode head1 = buildLinkedList(new int[]{1,2,3,4,5});
        head1 = removeNthLastNode(head1, 2);
        System.out.println("After removing 2nd last from [1,2,3,4,5]: " + linkedListToString(head1));

        // Test Case 2: [1], n=1 => []
        LinkedListNode head2 = buildLinkedList(new int[]{1});
        head2 = removeNthLastNode(head2, 1);
        System.out.println("After removing 1st last from [1]: " + linkedListToString(head2));

        // Test Case 3: [1,2], n=1 => [1]
        LinkedListNode head3 = buildLinkedList(new int[]{1,2});
        head3 = removeNthLastNode(head3, 1);
        System.out.println("After removing 1st last from [1,2]: " + linkedListToString(head3));

        // Additional Test: Removing the head node
        // Input: [1,2,3], n=3 => [2,3]
        LinkedListNode head4 = buildLinkedList(new int[]{1,2,3});
        head4 = removeNthLastNode(head4, 3);
        System.out.println("After removing 3rd last from [1,2,3]: " + linkedListToString(head4));
    }

    private static LinkedListNode buildLinkedList(int[] values) {
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode current = dummy;
        for (int val : values) {
            current.next = new LinkedListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    private static String linkedListToString(LinkedListNode head) {
        List<Integer> vals = new ArrayList<>();
        while (head != null) {
            vals.add(head.val);
            head = head.next;
        }
        return vals.toString();
    }

    public static class LinkedListNode {
        int val;
        LinkedListNode next;
        LinkedListNode(int x) { val = x; }
    }
}

