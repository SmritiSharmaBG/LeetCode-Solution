package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaseballGameLC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line=br.readLine();
        String[] arr = line.substring(1,line.length()-1).trim().split("\",\"");
        int sum = calculateScore(arr);
        System.out.println(sum);
    }

    private static int calculateScore(String[] arr) {
        Stack<Integer> stack = new Stack<>();
        for (String s : arr) {
            if (s.equals("+")) {
                int last = stack.pop();
                int prev = stack.pop();
                int sum = last + prev;
                stack.push(prev);
                stack.push(last);
                stack.push(sum);
            } else if (s.equals("D")) {
                stack.push(stack.peek() * 2);
            } else if (s.equals("C")) {
                stack.pop();
            } else
                stack.push(Integer.parseInt(s));
        }
        int sum = 0;
        for (int i : stack)
            sum += i;
        return sum;
    }
}
