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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode right = head;
        ListNode left = head;
        
        while (right != null && right.next != null) {
            right = right.next.next;
            left = left.next;
        }
        
        if (right != null) {
            left = left.next;
        }
        
        ListNode reverse = null;
        while(left != null) {
            ListNode temp = left.next;
            left.next = reverse;
            reverse = left;
            left = temp;
        }
        
        left = reverse;
        while (left != null) {
            if (head.val != left.val) {
                return false;
            }
            left = left.next;
            head = head.next;
        }
        return true;
    }
}