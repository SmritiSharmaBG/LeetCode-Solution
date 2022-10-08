class Solution {
    public int threeSumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        int ans = arr[0];
        int diff = Integer.MAX_VALUE;
        int n = arr.length;
    
        for(int i = 0; i < n - 2; i ++) {
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                int d = Math.abs(target - sum);
                if (sum < target) left ++;
                else if(sum > target) right --;
                else return target;
                if(d < diff) {
                    diff = d;
                    ans = sum;
                }            
            }
        }
        return ans;
    }
}
