class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < weights.length; i ++) {
            int x = weights[i];
            if (x > max) max = x;
            sum += x;
        }

        int low = max;
        int high = sum;
        int mid = (low + high) / 2;
        int ans = Integer.MAX_VALUE;
        while (low <= high) {
            mid = (low + high) / 2;
            if (canShip(weights, mid, days)) {
                high = mid - 1;
                if (mid < ans) ans = mid;
            } else low = mid + 1;
        }
        return ans;
    }

    private boolean canShip(int[] weights, int cap, int days) {
        int d = 1;
        int wt = 0;
        for (int i = 0; i < weights.length; i ++) {
            if (wt + weights[i] <= cap) {
                wt += weights[i];
            } else {
                wt = weights[i];
                d ++;
            }
        }
        return d <= days;
    }
}
