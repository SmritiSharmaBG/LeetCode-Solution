package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the string");
        String line = br.readLine();
        boolean ans = isValidParenthesis(line);
        System.out.print("the ans is = " + ans);
    }

    private static boolean isValidParenthesis(String line) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            } else if (c == '}') {
                if (!stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    return false;
            } else if (c == ']') {
                if (!stack.isEmpty() && stack.peek() == '[')
                    stack.pop();
                else
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
