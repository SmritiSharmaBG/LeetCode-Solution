class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        //return bruteForce(nums, k);
        
        // 1. Make a HashMap to store the remainder and its position 
        // (Position is important to check for size >= 2) 
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        // To handle the corner cases when (remainderSum % k) == 0
        hm.put(0, -1);
        int remainderSum = 0;
        int n = nums.length;
        
        for (int i = 0; i < n; i ++) {
            remainderSum += nums[i];
            remainderSum %= k;
            if (hm.containsKey(remainderSum)) {
                int pos = hm.get(remainderSum);
                // there should be gap of at-least 2 numbers
                if (i - pos > 1) return true;
            } else hm.put(remainderSum, i);
        }
        return false;
    }
    
    // TC : O(n^2) : TLE 
    // SC : O(1)
    private boolean bruteForce(int[] nums, int k) {
        int n = nums.length;
        
        for (int i = 0; i < n - 1; i ++) {
            int sum = nums[i];
            for (int j = i + 1; j < n; j ++) {
                sum += nums[j];
                if (sum % k == 0) return true;
            }
        }        
        return false;
    }
}
