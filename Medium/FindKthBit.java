class Solution {
  // THIS SOLUTION IS LOGICALLY CORRECT BUT GIVES TLE FOR LARGER INPUT
//     int len;
//     public char findKthBit(int n, int k) {
//         len = k;
//         String s = rec("0", n-1);
//        // System.out.println(s);
//         return s.charAt(k-1);
//     }
    
//     String rec(String s, int n) {
//         if(n == 0) return s;
//         if(s.length() > len) return s;
//         String str = s + "1";
//         s = revInv(s);
//         str += s;
//         return rec(str, n - 1);
//     }
//     String revInv(String s) {
//         int n = s.length();
//         if(n == 0) return s;
//         char c = s.charAt(n-1);
//         return (c == '1' ? '0' : '1') + revInv(s.substring(0, n - 1));
//     }
    
    /*
    Observations :
    1. The first half of S(i) = S(i-1)
    2. The middle element is always 1
    3. The second half can also be calculated using first half
    4. The length is always odd
    length pattern :
    1 - 1
    2 - 3
    3 - 7
    4 - 15
              0111001 6 5 4  0
    0111001 1 0110001 8 9 10 15
    mid = 7 15-7 k-1-mid
    2^(n-1) - 1
    
    */
    
    
    public char findKthBit(int n, int k) { 
         return rec(n, k - 1);
     }
    
    char rec(int n, int k) {
        int len = (int)Math.pow(2, n) - 1;
        int mid = len / 2;
        if(len == 1) return '0';
        if(k == mid) return '1';
        if(k < mid) return rec(n-1, k);
        int index = mid - (k - mid - 1);
        char ch = rec(n-1, index - 1);
        return ch == '0' ? '1' : '0';
    }
}
