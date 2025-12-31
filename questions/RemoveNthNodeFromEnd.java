// 19. Remove Nth Node From End of List 
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/

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
    // brute force approach
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //  traversing and counting the length of the linkedlist
        int count = 0;
        ListNode temp = head;
        
        while ( temp != null ) {
            count++;
            temp = temp.next;
        }

        // calculating node number before deletion node
        int res = count - n;
        temp = head;

        // reaching res node
        while ( res > 1 ) {
            res--;
            temp = temp.next;
        }

        // deleting the node asked for
        // handling edge case 
        if ( temp == null || temp.next == null ) {
            head = null;
            return head;
        }
        
        ListNode delNode = temp.next;
        temp.next = temp.next.next;
        delNode.next = null;

        return head;
    }


    // optimal approach
     public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode slow = head;
        ListNode fast = head;
        int count = n;

        // taking fast n steps forward
        while (count > 0) {
            fast = fast.next;
            count--;
        }

        // handling edge case - first node deletion
        if (fast == null) {
            head = head.next;
            return head;
        }

        // taking slow before deletion node 
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // deleting nth node 
        ListNode delNode = slow.next;
        slow.next = slow.next.next;
        delNode.next = null;

        return head;
    }
}