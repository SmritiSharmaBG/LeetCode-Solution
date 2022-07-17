class Solution {
    public void solveSudoku(char[][] board) {
        rec(board);
    }
    
    boolean rec(char[][] board) {
        for(int i = 0; i < 9; i ++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    
                    for(int fill = 1; fill <= 9; fill ++) {
                        if(isValid(fill, board, i, j)) {
                            board[i][j] = (char)(fill+48);
                            if(rec(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    boolean isValid(int f, char[][] board, int i, int j) {
        char fill = (char)(f+48);
        for(int it = 0; it < 9; it ++) {
            // horizontal row check
            if(board[i][it] == fill) return false;
            
            // vertical col check
            if(board[it][j] == fill) return false;
            
            // box check
            if(board[((i / 3) * 3) + (it / 3)][((j / 3) * 3) + (it % 3)] == fill) return false;
        }
        return true;
    }
    
}
