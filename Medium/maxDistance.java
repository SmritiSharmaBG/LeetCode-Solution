class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        int low = 1;
        int high = position[n - 1] - position[0];
        int ans = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(canPlace(position, m, n, mid)) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        return ans;
    }
    
    boolean canPlace(int[] position, int m, int n, int dis) {
        int occIndex = position[0];
        int placedBall = 1;
        for(int i = 1; i < n; i ++) {
            if(position[i] - occIndex >= dis) {
                occIndex = position[i];
                placedBall ++;
            }
            if(placedBall == m) return true;
        }
        return false;
    }
}
