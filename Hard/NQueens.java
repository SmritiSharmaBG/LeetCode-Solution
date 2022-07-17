class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        // APPROACH 1 :
        // List<List<String>> list = new ArrayList<>();
        // List<String> ds= new ArrayList<>();
        // char[][] chess = new char[n][n];
        // for(int i = 0; i < n; i++) {
        //     for(int j = 0; j < n; j ++) {
        //         chess[i][j] = '.';
        //     }
        // }
        // rec(0, list, n, chess);
        // return list;
        
        
        // APPROACH 2 : EFFICIENT BUT TRICKY!!
        List<List<String>> list = new ArrayList<>();
        List<String> ds= new ArrayList<>();
        int[] up = new int[n];
        int[] rightDiag = new int[(2*n) - 1];
        int[] leftDiag = new int[(2*n) - 1];
        char[][] chess = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j ++) {
                chess[i][j] = '.';
            }
        }
        rec(0, list, chess, up, rightDiag, leftDiag);
        return list;
    }
    
    void rec(int i, List<List<String>> list, char[][] chess, int[] up, int[] rightDiag, int[] leftDiag) {
        if(i == chess.length) {
            list.add(new ArrayList<>(getList(chess)));
            return;
        }
        for(int j = 0; j < chess.length; j ++) {
            if(up[j] == 0 && rightDiag[i+j] == 0 && leftDiag[chess.length - 1 + j - i] == 0) {
                up[j] = 1;
                rightDiag[i+j] = 1;
                leftDiag[chess.length - 1 + j - i] = 1;
                chess[i][j] = 'Q';
                rec(i + 1, list, chess, up, rightDiag, leftDiag);
                chess[i][j] = '.';
                up[j] = 0;
                rightDiag[i+j] = 0;
                leftDiag[chess.length - 1 + j - i] = 0;
            }
    }
    }
    
    
    
    
    
    // ALL FUNCTIONS FOR APPROACH 1
    void rec(int i, List<List<String>> list, int n,  char[][] chess) {
        if(i == n) {
            list.add(new ArrayList<>(getList(chess)));
            return;
        }
        
        for(int j = 0; j < n; j ++) {
            if(isSafe(i,j,chess)) {
                chess[i][j] = 'Q';
                rec(i + 1, list, n, chess);
                chess[i][j] = '.';
            }
        }
    }
    
    ArrayList<String> getList(char[][] chess) {
        ArrayList<String> al = new ArrayList<>();
        for(int i = 0; i < chess.length; i ++) {
            String str = new String(chess[i]);
            al.add(str);
        }
        return al;
    }
    
    
    boolean isSafe(int i, int j, char[][] chess) {
        
        int copyI = i;
        int copyJ = j;
        
        // check up :
        while(i >= 0) {
            if(chess[i][j] != '.') return false;
            i --;
        }
        
        // check diag 1 :
        i = copyI;
        while(i >= 0 && j>=0) {
            if(chess[i][j] != '.') return false;
            i --;
            j --;
        }
        
        // check diag 2 :
        i = copyI;
        j = copyJ;
        while(i >= 0 && j < chess.length) {
            if(chess[i][j] != '.') return false;
            i --;
            j ++;
        }
        
        return true;
    }
    
}
