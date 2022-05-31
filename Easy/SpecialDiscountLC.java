package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SpecialDiscountLC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the prices");
        String[] line = br.readLine().trim().split(",");
        int[] arr = new int[line.length];
        for (int i = 0; i < line.length; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        int[] ans = findDiscountedPrice(arr);
        for (int i : ans)
            System.out.print(i+" ");
    }

    private static int[] findDiscountedPrice(int[] price) {
        Stack<Integer> stack = new Stack<>();
        int[] finalPrice = new int[price.length];
        for (int i = price.length - 1; i >= 0; i--) {
            int p = price[i];
            while (!stack.isEmpty() && stack.peek() > p) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                finalPrice[i] = p;
            } else if (stack.peek() < p) {
                finalPrice[i] = p - stack.peek();
            }
            stack.push(p);
        }
        return finalPrice;
    }
}
