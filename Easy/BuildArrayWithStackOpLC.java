package com.dataStructure.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BuildArrayWithStackOpLC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().trim().split(",");
        int[] target = new int[line.length];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < line.length; i++)
            target[i] = Integer.parseInt(line[i]);
        List<String> result = buildArray(target, n);
        for (String s : result)
            System.out.print(s + " ");
    }

    private static List<String> buildArray(int[] target, int n) {
        List<String> list = new ArrayList<>();
        int number=1;
        int pos=0;
        for(int i = 1; i <= target[target.length-1];i++)
        {
            if(target[pos]==i) {
                list.add("Push");
                pos++;
            } else {
                list.add("Push");
                list.add("Pop");
            }
        }
        return list;
    }
}
