class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n][target + 1];
        return rec(0, n, k, target, 0, dp) % ((int) (Math.pow(10, 9)) + 7);
    }
    
    private int rec(int index, int n, int k, int target, int sum, Integer[][] dp) {
        if(index == n) {
            if(sum == target) {
                return 1;
            }
            return 0;
        }
        if (sum > target) return 0;
        if (dp[index][sum] != null) return dp[index][sum];
        int count = 0;
        for(int i = 1; i <= k; i ++) {
            count += rec(index + 1, n, k, target, sum + i, dp);
            count = count % ((int) (Math.pow(10, 9)) + 7);
        }
        return dp[index][sum] = count;
    }
}
