package com.dataStructure.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterLC {
    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        int[] ans = nextGreaterElement(nums1, nums2);
        for (int i : ans) {
            System.out.print(i + " ");
        }

    }

    // O(n^2)
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = nums2.length - 1; j >= 0; j--) {
                int res = -1;
                if (stack.isEmpty()) stack.push(nums2[j]);
                else if (stack.peek() > nums2[j]) {
                    res = stack.peek();
                    stack.push(nums2[j]);
                } else {
                    while (!stack.isEmpty() && stack.peek() < nums2[j]) stack.pop();
                    if (!stack.isEmpty() && stack.peek() > nums2[j]) res = stack.peek();
                    stack.push(nums2[j]);
                }
                if (nums2[j] == nums1[i]) ans[i] = res;
            }
        }
        return ans;
    }

    // O(n+m)
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int ans[] = new int[nums1.length];
        HashMap<Integer, Integer> hm = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int j = nums2.length - 1; j >= 0; j--) {
            if (stack.isEmpty()) {
                stack.push(nums2[j]);
                hm.put(nums2[j], -1);
            } else if (stack.peek() > nums2[j]) {
                hm.put(nums2[j], stack.peek());
                stack.push(nums2[j]);
            } else {
                while (!stack.isEmpty() && stack.peek() < nums2[j]) stack.pop();
                if (stack.isEmpty()) hm.put(nums2[j], -1);
                else if (stack.peek() > nums2[j]) hm.put(nums2[j], stack.peek());
                stack.push(nums2[j]);
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = hm.get(nums1[i]);
        }
        return ans;
    }
}
