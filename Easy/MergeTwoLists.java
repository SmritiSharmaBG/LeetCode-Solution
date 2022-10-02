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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //return bruteForce(list1, list2);
        
        return optimized(list1, list2);
    }
    
    private ListNode optimized(ListNode head1, ListNode head2) {
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        if(head2.val < head1.val) {
            ListNode temp = head1;
            head1 = head2;
            head2 = temp;
        }
        
        ListNode head = new ListNode(0);
        
        ListNode i = head;
        
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                i.next = head1;
                i = i.next;
                head1 = head1.next;
            } else {
                ListNode temp = head1;
                head1 = head2;
                head2 = temp;
            }
        }
        
        i.next = head2; 
        return head.next;
   } 
    
    private ListNode bruteForce(ListNode list1, ListNode list2) {
        ListNode list;
        if (list1 == null && list2 == null)  return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        ListNode head = new ListNode(0);
        list = head;
        while(list1 != null && list2 != null) {
            if(list1.val < list2.val) {
                list.next = new ListNode(list1.val);
                list = list.next;
                list1 = list1.next;
            } else {
                list.next = new ListNode(list2.val);
                list = list.next;
                list2 = list2.next;
            }
        }
        
        if(list1 != null) list.next = list1;
        
        if(list2 != null) list.next = list2;
        
        return head.next;
    }
}
