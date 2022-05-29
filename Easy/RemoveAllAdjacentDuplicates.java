package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveAllAdjacentDuplicates {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String ans = removeDuplicate(line);
        System.out.print(ans);
    }

    private static String removeDuplicate(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        String st = "";
        while (!stack.isEmpty())
            st = st + stack.pop();
        String res = "";
        for (int i = st.length() - 1; i >= 0; i--)
            res = res + st.charAt(i);
        return res;
    }
}
