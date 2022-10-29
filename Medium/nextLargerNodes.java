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
    public int[] nextLargerNodes(ListNode head) {
        return bruteForceUsingStack(head);
    }
    
    int[] bruteForceUsingStack(ListNode head) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        rec(head, arrayList, stack);
        int[] arr = new int[arrayList.size()];
        int pos = arrayList.size() - 1;
        for (int i : arrayList) {
            arr[pos] = i;
            pos --;
        }
        return arr;
    }
    
    private void rec(ListNode head, ArrayList<Integer> list, Stack<Integer> stack) {
        if (head == null) return;
        rec(head.next, list, stack);
        if (stack.isEmpty()) list.add(0);
        else {
            while (!stack.isEmpty() && stack.peek() <= head.val) {
                stack.pop();
            }
            if (stack.isEmpty()) list.add(0);
            else if (head.val < stack.peek()) {
                list.add(stack.peek());
            }
        }
        stack.push(head.val);
    }
}
