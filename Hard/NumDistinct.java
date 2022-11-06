class Solution {
    public int numDistinct(String s, String t) {
        int l1 = s.length();
        int l2 = t.length();
        
        int[][] dp = new int[l1][l2];
        
        // BASE CONDITION
        if (s.charAt(0) == t.charAt(0)) dp[0][0] = 1;
        
        for (int i = 1; i < l1; i ++) {
            if (s.charAt(i) == t.charAt(0)) dp[i][0] = dp[i - 1][0] + 1;
            else dp[i][0] = dp[i - 1][0];
        }

        for (int i = 1; i < l1; i ++) {
            for (int j = 1; j < l2; j ++) {
                int match = 0;
                int unmatch = 0;
                
                char c1 = s.charAt(i);
                char c2 = t.charAt(j);

                if (c1 == c2) match = dp[i - 1][j - 1];
                unmatch = dp[i - 1][j];

                dp[i][j] = match + unmatch;
            }
        }
        return dp[l1 - 1][l2 - 1];
    }
}
