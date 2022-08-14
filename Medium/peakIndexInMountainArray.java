class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int n = arr.length;
        int high = n - 1;
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1 < n && mid - 1 >= 0 && arr[mid] > arr[mid + 1] && arr[mid] > arr[mid - 1])
                return mid;
            if (mid - 1 >= 0 && arr[mid] > arr[mid - 1]) low = mid + 1;
            else high = mid;
        }
        return ans;
    }
}
