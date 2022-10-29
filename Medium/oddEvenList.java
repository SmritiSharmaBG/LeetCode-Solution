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
    public ListNode oddEvenList(ListNode head) {
        // return sol1(head);
        
        return sol2(head);
    }
    
    // BETTER SOLUTION
    private ListNode sol2(ListNode head) {
        if (head == null) return null;
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        
        /* 
        accumulate evens and odds together. This while loop makes the linked list branched  
        Example : 1 -> 3 -> 4 -> 5 and 2 -> 4 -> 5 together.
        
        But it accumulates evens and odds together. 
        At the end, we just need to connect the end of odd to the start of even
        */
        while (even !=null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        
        // connect the end of odd to the start of even
        odd.next = evenHead;
        
        return head;
    }
    
  
  // COMPLICATED SOLUTION
    private ListNode sol1(ListNode head) {
        if (head == null) return null;
        ListNode o1 = head;
        ListNode o2, e1;
        o2 = e1 = null;
        if (head.next != null) o2 = head.next.next;
        else return head;
        if (head.next.next != null) e1 = o2.next;
        else return head;
        ListNode evenEnd = head.next;
        while(true) {
            ListNode temp = o1.next;
            o1.next = o2;
            o2.next = temp;
            evenEnd.next = e1;
            o1 = o1.next;
            if (e1 == null || e1.next == null) return head;
            evenEnd = evenEnd.next;
            o2 = e1.next;
            e1 = o2.next;            
        }
    }
}
