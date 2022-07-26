class Solution {
    public int missingNumber(int[] nums) {
        // TIME COMPLEXITY : O(n)
        // SPACE COMPLEXITY : O(n)
        // HashSet<Integer> hs = new HashSet<>();
        // for (int i = 0; i < nums.length; i ++) {
        //     hs.add(nums[i]);
        // }
        // for(int i = 0; i <= nums.length; i++) {
        //     if(!hs.contains(i)) return i;
        // }
        // return -1;
        
        // TIME COMPLEXITY : O(n)
        // SPACE COMPLEXITY : O(1)
        int totalSum = (nums.length * (nums.length + 1)) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }      
        return totalSum - sum;
    }
}
