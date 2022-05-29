package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class MaximumNestingDepthOfParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] arr = line.trim().toCharArray();
        int ans = findMaximumDepth(arr);
        System.out.print(ans);
    }

    private static int findMaximumDepth(char[] arr) {
        Stack<Character> stack = new Stack<>();
        int max = 0;
        for (char c : arr) {
            if (c == '(') {
                stack.push(c);
                if (max < stack.size())
                    max = stack.size();
            } else if (c == ')') {
                stack.pop();
            }
        }
        return max;
    }
}
