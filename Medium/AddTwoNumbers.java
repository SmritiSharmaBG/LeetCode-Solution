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
//     public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//         long a = getNumber(l1, 0);
//         long b = getNumber(l2, 0);
//         long c = a + b;
//         return makeList(null, c);
//     }
//     long getNumber(ListNode l,long n) {
//         if(l == null) return -1;
//         n = getNumber(l.next, n);
//         n = n == -1 ? l.val : n*10 + l.val;
//         return n;
//     }
    
//     ListNode makeList(ListNode node, long c) {
//         if(c == 0 && node != null) return null;
//         long n = c % 10;
//         ListNode nxt = new ListNode((int)n);
//         if(c < 10) node = nxt;
//         nxt.next = makeList(node, c / 10); 
//         return nxt;
//     }
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return rec(l1, l2, 0, null);
    }
    ListNode rec(ListNode l1, ListNode l2, int carry, ListNode n) {
        if(l1 == null && l2 == null && carry == 0) return null;
        if(l1 == null) l1 = new ListNode(0);
        if(l2 == null) l2 = new ListNode(0);
        int sum = l1.val + l2.val + carry;
        if(sum > 9) {
            carry = sum / 10;
            sum = sum % 10;
        } else carry = 0;
        n = new ListNode(sum);
        n.next = rec(l1.next, l2.next, carry, n.next);
        return n;
    }
    
}
