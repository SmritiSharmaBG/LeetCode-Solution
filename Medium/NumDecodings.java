class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        Integer[] mem = new Integer[n];
        return rec(0, s, n , mem); 
    }
    
    private int rec(int index, String s, int n, Integer[] mem) {
        if (index == n) return 1;
        
        if (mem[index] != null) return mem[index];
        
        int count = 0;
        
        // take single
        char ch = s.charAt(index);
        if(isValid(ch)) count = rec(index + 1, s, n, mem);
        
        // take double
        if(index + 1 < n) {
            String str = s.substring(index, index + 2);
            if(isValid(str)) count += rec(index + 2, s, n, mem);
        }
        
        return mem[index] = count;
    } 
    
    private boolean isValid(char ch) {
        return (ch >= '1' && ch <= '9');
    }
    
    private boolean isValid(String str) {
        if (str.charAt(0) == '0') return false;
        
        int i = Integer.parseInt(str);
        
        return (i >= 10 && i <= 26);
    }
}
