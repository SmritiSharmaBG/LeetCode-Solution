class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row - 1;
        int mid = (start + end) / 2;
        while(start <= end) {
            mid = (start + end) / 2;
            int ele = matrix[mid][col - 1];
            if (target == ele) return true;
            if (target < ele) end = mid - 1;
            else start = mid + 1;
        }
        int r = start;
        if (r >= row) return false;
        start = 0;
        end = col - 1;
        while(start <= end) {
            mid = (start + end) / 2;
            int ele = matrix[r][mid];
            if (target == ele) return true;
            if (target < ele) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}
