class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) return "";
        StringBuilder s = new StringBuilder(palindrome);
        for(int i = 0; i < n/2; i ++) {
            char ch = palindrome.charAt(i);
            if(ch != 'a') {
                s.setCharAt(i, 'a');
                return s.toString();
            }
        }
        if(palindrome.charAt(n - 1) == 'a') s.setCharAt(n - 1, 'b'); 
        return s.toString();
    }
}
