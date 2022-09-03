class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if(digits.length() == 0) return ans;
            String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
            rec(0, digits, ans, map, "");
            return ans;
    }
    
    private void rec(int index, String digits, List<String> ans, String[] map, String str) {
            if (index == digits.length()) {
                ans.add(str);
                return;
            }
            int in = (int) (digits.charAt(index) - '0') - 2;
            String parent = map[in];
            for (int i = 0; i < parent.length(); i++) {
                char ch = parent.charAt(i);
                rec(index + 1, digits, ans, map, str + ch);
            }
        }
}
