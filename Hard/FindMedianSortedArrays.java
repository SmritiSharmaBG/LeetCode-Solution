class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1 > n2) return findMedianSortedArrays(nums2, nums1);
        int start = 0;
        int end = n1;
        int half = (n1 + n2 + 1) / 2;
        double median = 0.0d;
        while(start <= end) {
            int cut1 = (start + end) / 2;
            int cut2 = half - cut1;
            
            int left1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int left2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int right1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int right2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];
            
            if(left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) { // even no of elements
                    median = (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                }
                else {
                    median = Math.max(left1, left2);
                }
                return median;
            }
            
            else if(left1 > right2) {
                end = cut1 - 1;
            }
            
            else {
                start = cut1 + 1;
            }
        } // while
        return median;
    }
}
