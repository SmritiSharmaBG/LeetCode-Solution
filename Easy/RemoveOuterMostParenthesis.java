package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveOuterMostParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        char[] arr = line.trim().toCharArray();
        String ans = removeOuter(arr);
        System.out.print(ans);
    }

    private static String removeOuter(char[] arr) {
        Stack<Character> stack = new Stack<>();
        String temp = "";
        String ans = "";
        for (char c : arr) {
            temp = temp + c;
            if (c == '(') {
                stack.push(c);
            } else if (c == ')')
                stack.pop();
            if (stack.isEmpty()) {
                ans = ans + temp.substring(1, temp.length() - 1);
                temp = "";
            }
        }
        return ans;
    }
}
