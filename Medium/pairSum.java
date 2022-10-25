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
    public int pairSum(ListNode head) {
        // return bruteForce(head);
        return maxTwin(head);
    }
    
    // TC : O(n / 2) + O(n / 2) + O(n / 2) = O(n)
    // SC : O(n / 2) = O(n)
    private int maxTwin(ListNode head) {
        //  1. Get the middle element
        ListNode fast = head;
        ListNode slow = head;
        ListNode mid = head;
        while (fast != null) {
            fast = fast.next.next;
            mid = slow;
            slow = slow.next;
        }
        // Reverse the rest of the list
        mid.next = reverse(slow);
        // Traverse 1st and 2nd half parallely & keep track of maximum
        int max = Integer.MIN_VALUE;
        ListNode first = head;
        ListNode second = mid.next;
        while (second != null) {
            int sum = first.val + second.val;
            if (sum > max) max = sum;
            first = first.next;
            second = second.next;
        }
        return max;
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode rest = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return rest;
    }
    
    // TC : O(n) + O(n/2) + O(n/2) + O(n) = O(n)
    // SC : O(n/2) = O(n)
    private int bruteForce(ListNode head) {
        int n = getSize(head);
        int[] arr = new int[n / 2];
        int p = 0;
        ListNode temp = head;
        while (p < n / 2) {
            arr[p] = temp.val;
            p ++;
            temp = temp.next;
        }
        p --;
        while (temp != null) {
            arr[p] += temp.val;
            p --;
            temp = temp.next;
        }
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }
    
    private int getSize(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size ++;
            temp = temp.next;
        }
        return size;
    }
}
