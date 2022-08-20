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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int k = lists.length;
        ListNode ans = null;
        int i = 0;
        while(pq.size() < k) {
            if(i >= lists.length) break;
            if(lists[i] == null) { 
                i ++; 
                continue;
            }
            pq.add(new Pair(i, lists[i], lists[i].val));
            i ++;
        }
      
        while(!pq.isEmpty()) {
            Pair p = pq.remove();
            ans = insertInList(ans, p.num);
            int index = p.i;
            ListNode j = p.j;
            if(j.next != null) pq.add(new Pair(index, j.next, j.next.val));
        }
        return ans;
    }
    
    private ListNode insertInList(ListNode ans, int num) {
        ListNode l = new ListNode(num);
        if(ans == null) {
            ans = l;
            return ans;
        }
        ListNode temp = ans;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = l;
        return ans;
    }
    
    private class Pair implements Comparable<Pair> {
        int i;
        ListNode j;
        int num;
         
        Pair(int i, ListNode j, int num) {
            this.i = i;
            this.j = j;
            this.num = num;
        }
        
        @Override
        public int compareTo(Pair p) { // top element should be smallest, Min-Heap
            return ((Integer)num).compareTo(p.num);
        }
    }
}
