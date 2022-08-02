class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int p = 1;
        ans[0] = 1;
        for (int i = 1; i < n; i++) {
            ans[i] = p * nums[i - 1];
            p = ans[i];
        }
        
        p = 1;
        for (int i = n - 1; i >= 0; i --) {
            ans[i] = p * ans[i];
            p = p * nums[i];
        }
        
        return ans;
    }
}
