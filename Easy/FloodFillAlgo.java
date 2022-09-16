class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{sr, sc});
        int og = image[sr][sc];
        image[sr][sc] = color;
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        vis[sr][sc] = true;
        
        while(!queue.isEmpty()) {
            int[] temp = queue.remove();
            sr = temp[0];
            sc = temp[1];
            
            // move up
            int r = sr - 1;
            int c = sc;
            if(isValid(r, c, m, n) && isSame(og, r, c, image) && !vis[r][c]) {
                image[r][c] = color;
                queue.add(new int[]{r, c});
                vis[r][c] = true;
            }
                
            
            // move down
            r = sr + 1;
            c = sc;
            if(isValid(r, c, m, n) && isSame(og, r, c, image) && !vis[r][c]) {
                image[r][c] = color;
                queue.add(new int[]{r, c});
                vis[r][c] = true;
            }
            
            // move left
            r = sr;
            c = sc - 1;
            if(isValid(r, c, m, n) && isSame(og, r, c, image) && !vis[r][c]) {
                image[r][c] = color;
                queue.add(new int[]{r, c});
                vis[r][c] = true;
            }
            
            // move right
            r = sr;
            c = sc + 1;
            if(isValid(r, c, m, n) && isSame(og, r, c, image) && !vis[r][c]) {
                image[r][c] = color;
                queue.add(new int[]{r, c});
                vis[r][c] = true;
            }
               
        }
        return image;
    }
    
    private boolean isValid(int r, int c, int m, int n) {
        return (r >= 0 && r < m && c >= 0 && c < n);
    }
    
    private boolean isSame(int og, int r, int c, int[][] image) {
        return (image[r][c] == og);
    }
}
