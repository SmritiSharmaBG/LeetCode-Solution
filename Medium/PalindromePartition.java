class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        rec(0, s, path, ans);
        return ans;
    }
    
    void rec(int index, String s, List<String> path, List<List<String>> ans) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        
        for (int i = index; i < s.length(); i ++) {
            String str = s.substring(index, i + 1);
            if(isPalindrome(str)) {
                path.add(str);
                rec(i + 1, s, path, ans);
                path.remove(path.size() - 1);
            }
        }
    }
    
    boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            if(s.charAt(start ++) != s.charAt(end --)) return false;
        }
        return true;
    }
}
