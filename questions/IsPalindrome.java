// 234. Palindrome Linked List
// https://leetcode.com/problems/palindrome-linked-list/description/

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
    ListNode reverse(ListNode curr) {
        ListNode prev = null;
        ListNode next = null;

        // handling edge cases
        if (curr == null || curr.next == null) {
            return curr;
        }

        // reversing the order
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // identifying middle of the linked list - tortoise & hare algorithm
        // handling edge case
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reversing second half of linked list
        ListNode newHead = reverse(slow.next);

        // comparing both the hafls ( palindrome condition check ) 
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead); // linked list back to original
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(newHead); // linked list back to original
        return true;
    }
}