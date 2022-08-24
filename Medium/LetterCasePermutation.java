class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<>();
        rec(0, s, ans, "");
        return ans;
    }
    
//     private void rec(int i, String s, List<String> ans, String str) {
//         if (i == s.length()) {
//            // System.out.println(str);
//             ans.add(str);
//             return;
//         }
        
//         char ch = s.charAt(i);
//          //System.out.println(ch + ",");
//         if (ch >= 'a' && ch <= 'z') {
//             // not change
//             rec(i + 1, s, ans, str + ch);
//             // change
//             ch = Character.toUpperCase(ch);
//             rec(i + 1, s, ans, str + ch);
//         } else if (ch >= 'A' && ch <= 'Z') {
//             // not change
//             rec(i + 1, s, ans, str + ch);
//             // change
//             ch = Character.toLowerCase(ch);
//             rec(i + 1, s, ans, str + ch);
//         } else rec(i + 1, s, ans, str + ch);
//     }
    
    private void rec(int i, String s, List<String> ans, String str) {
        if (i == s.length()) {
           // System.out.println(str);
            ans.add(str);
            return;
        }
        
        char ch = s.charAt(i);
        if (ch >= '0' && ch <= '9') {
            rec(i + 1, s, ans, str + ch);
            return;
        }
        
        ch = Character.toUpperCase(ch);
        rec(i + 1, s, ans, str + ch);
        
        ch = Character.toLowerCase(ch);
        rec(i + 1, s, ans, str + ch);
    }
}
