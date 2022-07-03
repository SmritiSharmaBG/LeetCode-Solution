class Solution {
    public void reverseString(char[] s) {;
        rec(s, 0, s.length-1);
    }
    void rec(char[] s, int swap1, int swap2) {
        if (swap1 >= swap2) return;
        char temp = s[swap1]; 
        s[swap1] = s[swap2];
        s[swap2] = temp;
        rec(s, ++swap1, --swap2);        
    }
}
