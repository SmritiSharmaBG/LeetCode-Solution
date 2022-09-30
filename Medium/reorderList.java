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
    public void reorderList(ListNode head) {
        rec(head);
    }
    
    private void rec(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode last = getLast(head);
        last.next = head.next;
        head.next = last;
        rec(head.next.next);
    }
    
    private ListNode getLast(ListNode head) {
        if(head.next == null) return head;
        while(head.next.next != null) head = head.next;
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }
}
