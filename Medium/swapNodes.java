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
    // TC : O(n) 
    // SC : O(1)
    public ListNode swapNodes(ListNode head, int k) {
        ListNode fast = head;
        
        for (int i = 1; i < k; i ++) {
            fast = fast.next;
        }
        
        ListNode a = fast;
        
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        ListNode b = slow;
        
        int x = a.val;
        a.val = b.val;
        b.val = x;
        
        return head;
    }
}
