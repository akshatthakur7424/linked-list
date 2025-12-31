// 2095. Delete the Middle Node of a Linked List
// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // handling edge case 
        if ( head == null || head.next == null ) {
            return null;
        }

        // skipping one step of slow - to reach one node before middle node 
        fast = fast.next.next;

        // taking slow before middle node 
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // deleting middle node 
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode = null;

        return head;
    }
}