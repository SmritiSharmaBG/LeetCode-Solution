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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode prev = null;
        ListNode curr = head;
        if (curr == null) return curr;
        ListNode nxt = curr.next;
        int c = 0;
        if (!isReversible(head, k)) return head;
        while(curr != null && c < k) {
            curr.next = prev;
            prev = curr;
            curr = nxt;
            if(curr != null) nxt = curr.next;
            c ++;
        }
        
        if(head != null) head.next = reverseKGroup(curr, k);
        
        return prev;
    }
    
    private boolean isReversible(ListNode head, int k) {
        ListNode temp = head;
        while(-- k >= 0) {
            if(temp == null) return false;
            temp = temp.next;
        }
        return true; 
    }
}
