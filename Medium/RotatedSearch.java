class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int mid = (start + end) / 2;
        while(start <= end) {
            mid = (start + end) / 2;
            if(nums[mid] == target) return mid;
            if(nums[start] <= nums[mid]) { // LHS is sorted
                if(target <= nums[mid] && target >= nums[start]) { // target is in LHS
                    end = mid - 1;
                }
                else start = mid + 1;
            } 
            else if (nums[end] >= nums[mid]) {// RHS is sorted 
                if(target >= nums[mid] &&  target <= nums[end]) { // target is in RHS
                    start = mid + 1;
                }
                else end = mid - 1;
            }
        } //while
        return -1;
    }
}
