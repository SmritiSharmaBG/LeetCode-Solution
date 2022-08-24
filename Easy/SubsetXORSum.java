class Solution {
    int sum;
    public int subsetXORSum(int[] nums) {
        sum = 0;
        rec(0, nums, 0);
        return sum;
    }
    
    void rec(int i, int[] nums, int s) {
        if(i == nums.length) {
            sum += s;
            return;
        }
        
        // not take
        rec(i + 1, nums, s);
        
        // take
        s = s ^ nums[i];
        rec(i + 1, nums, s);
    }
}
