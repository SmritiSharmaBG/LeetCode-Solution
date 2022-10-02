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
    
    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head.next;
        ListNode ans = head;
        int sum = 0;
        while(temp != null) {
            if(temp.val != 0) {
                sum += temp.val;
                temp = temp.next;
            } else {
                ListNode n = new ListNode(sum);
                n.next = temp.next;
                head.next = n;
                sum = 0;
                temp = temp.next;
                head = head.next;
            }
        }
        return ans.next;
    }
}
