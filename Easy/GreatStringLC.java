package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class GreatStringLC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the string");
        String line = br.readLine();
        String ans = makeGreat(line);
        System.out.print("the good string is = " + ans);
    }

    private static String makeGreat(String line) {
        Stack<Character> stack = new Stack<>();
        String ans = "";
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (stack.isEmpty())
                stack.push(c);
            else {
                if (stack.peek() - c == 32 || c - stack.peek() == 32)
                    stack.pop();
                else
                    stack.push(c);
            }
        }
        for (char c : stack)
            ans += c;
        return ans;
    }
}
