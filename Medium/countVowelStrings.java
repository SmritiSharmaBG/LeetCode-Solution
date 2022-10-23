static class Solution {
        public int countVowelStrings(int n) {
            Integer[][] dp = new Integer[5][n + 1];
            return rec(0, n, 0, dp);
        }

        // aaa, aae, aai, aao, aau, aee, aei, aeo, aeu
        private int rec(int index, int n, int len, Integer[][] dp) {
            if (len == n) return 1;
            if (dp[index][len] != null) return dp[index][len];
            int count = 0;
            for (int i = index; i < 5; i++) {
                count = count + rec(i, n, len + 1, dp);
            }
            return dp[index][len] = count;
        }
    }
