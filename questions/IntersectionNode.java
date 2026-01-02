//  160. Intersection of Two Linked Lists
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/  
   
   /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // APPROACHes
 // Brute Force Approach : store each node of any linked list in tha hashmap and than while traversing to the another linked list look if the node already exists in the hashmap, if it exists that is the node where the linked list is intersecting.

 // Better Approach : move the pointer variable of the larger linkedlist upto the node such that it comes infront of the starting node of another linked list, than compare the nodes while moving 1 step forward in each linked list. 
public class Solution {
    // comparing elements and finding comman elemetn
    ListNode collisionElement(ListNode t1, ListNode t2, int d) {
        // taking t1 in the same level as t2
        while (d != 0) {
            d--;
            t2 = t2.next;
        }

        // finding colliding ( intersecting element ) 
        while (t1 != t2) {
            t1 = t1.next;
            t2 = t2.next;
        }

        // intersection node
        return t2;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        int n1 = 0;
        ListNode temp2 = headB;
        int n2 = 0;

        // counting first LL length
        while (temp1 != null) {
            n1++;
            temp1 = temp1.next;
        }
        // counting second LL length
        while (temp2 != null) {
            n2++;
            temp2 = temp2.next;
        }

        // finding similar element
        if (n1 > n2) {
            return collisionElement(headB, headA, n1 - n2);
        } else {
            return collisionElement(headA, headB, n2 - n1);
        }
    }
}

// Optimal Approach: 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode temp1 = headA;
        ListNode temp2 = headB;

        // handling edge cases
        if (headA == null || headB == null) {
            return null;
        }

        // bringing temp1 and temp2 infront of each other 
        while (temp1 != temp2) {
            temp1 = temp1.next;
            temp2 = temp2.next;

            // pointing variabels to opposite heads 
            if (temp1 == null) {
                temp1 = headB;
            }
            if (temp2 == null) {
                temp2 = headA;
            }

            // intersectin node found 
            if (temp1 == temp2) {
                return temp1;
            }

            // no intersection in linked list case
            if (temp1.next == null && temp2.next == null) {
                return null;
            }
        }
        return temp1;
    }
}