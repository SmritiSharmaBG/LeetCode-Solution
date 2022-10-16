class Solution {
    
    // RECURSIVE SOLUTION
    public int minCostClimbingStairsRECURSIVE(int[] cost) {
        int n = cost.length;
        return Math.min(rec(n - 1, n, cost), rec(n - 2, n, cost));
    }
    
    // top down recursion
    private int rec(int index, int n, int[] cost) {
        if (index == 0) return cost[0];
        if (index == 1) return cost[1];
        
        // go back 1 step
        int step1 = cost[index] + rec(index - 1, n, cost);
        
        // go back 2 step
        int step2 = cost[index] + rec(index - 2, n, cost);
        
        return Math.min(step1, step2);
    }
    
    
            
    // TOP DOWN SOLUTION : MEMOIZATION
    public int minCostClimbingStairsMEMO(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n];
        return Math.min(rec(n - 1, n, cost, dp), rec(n - 2, n, cost, dp));
    }
    
    private int rec(int index, int n, int[] cost, Integer[] dp) {
        if (index == 0) return cost[0];
        if (index == 1) return cost[1];
        
        if (dp[index] != null) return dp[index];
        
        // go back 1 step
        int step1 = cost[index] + rec(index - 1, n, cost, dp);
        
        // go back 2 step
        int step2 = cost[index] + rec(index - 2, n, cost, dp);
        
        return dp[index] = Math.min(step1, step2);
    }
    
    
    
    // BOTTOM UP SOLUTION : TABULATION
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        Integer[] dp = new Integer[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int index = 2; index < n; index ++) {
            int step1 = cost[index] + dp[index - 1];
        
            int step2 = cost[index] + dp[index - 2];

            dp[index] = Math.min(step1, step2);
        }
        
        return Math.min(dp[n - 1], dp[n - 2]);
    }
}
