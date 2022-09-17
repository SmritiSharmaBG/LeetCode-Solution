class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                int x = grid[i][j];
                if(x == '0' || x == '2') continue;
                else if (x == '1') ans += bfs(grid, i, j, m, n);
            }
        }
        return ans;
    }
    
    private int bfs(char[][] grid, int it, int jt, int m, int n) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{it, jt});
        grid[it][jt] = 2;
        while(!q.isEmpty()) {
            int[] temp = q.remove();
            
            // 8 directions
            // int[] x = {-1, 0, 1, -1, 1, -1, 0, 1};
            // int[] y = {-1, -1, -1, 0, 0, 1, 1, 1};
            
            // 4 directions
            int[] x = {0, -1, 1, 0};
            int[] y = {-1, 0, 0, 1};
            for(int i = 0; i < 4; i ++) {
                int r = temp[0] + x[i];
                int c = temp[1] + y[i];
                if(isValid(r, c, m, n) && grid[r][c] == '1') {
                    grid[r][c] = '2';
                    q.add(new int[]{r, c});
                }
            }
        }
        return 1;
    }
    
    private boolean isValid(int i, int j, int m, int n) {
        return (i >= 0 && i < m && j >= 0 && j < n);
    }
}
