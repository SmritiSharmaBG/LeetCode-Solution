class Solution {
    public int maxLength(List<String> arr) {
        return rec(0, arr, arr.size(), "");
    }
    
    int rec(int index, List<String> arr, int n, String str) {
        if (index == n) {
            return str.length();
        }
        
        int take = 0;
        int notTake = 0;
        
        notTake = rec(index + 1, arr, n, str);
        
        
        if (canConcat(str, arr.get(index))) {
            str = str + arr.get(index);
            take = rec(index + 1, arr, n, str);
        }
        
        return Math.max(take, notTake);            
    }
    
    boolean canConcat(String a, String b) {
        boolean[] vis = new boolean[26];
        
        for (int i = 0; i < a.length(); i ++) {
            char ch = a.charAt(i);
            if (vis[ch - 'a']) return false;
            vis[ch - 'a'] = true;
        }
        
        for (int i = 0; i < b.length(); i ++) {
            char ch = b.charAt(i);
            if (vis[ch - 'a']) return false;
            vis[ch - 'a'] = true;
        }
        
        return true;
    }
}
