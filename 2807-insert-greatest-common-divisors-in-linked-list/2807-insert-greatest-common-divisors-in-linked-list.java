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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode result = head;
        while (result.next != null) {
            int gcd = getGcd(result.val, result.next.val);
            ListNode node = new ListNode(gcd);
            node.next = result.next;
            result.next = node;
            result = result.next.next;
        }
        return head;
    }
    
    private int getGcd(int left, int right) {
        while (right != 0) {
            int t = right;
            right = left % right;
            left = t;
        }
        return left;
    }
}