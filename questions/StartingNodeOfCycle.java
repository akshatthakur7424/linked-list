// 142. Linked List Cycle II
// https://leetcode.com/problems/linked-list-cycle-ii/description/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // detecting a loop
        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;

            // loop detected
            if ( slow == fast ) {
                slow = head;

                // reaching first node of the loop
                while ( slow != fast ) {
                    slow = slow.next;
                    fast = fast.next;
                }

                return slow; // first node of the loop 
            }
        }
        return null;
    }
}