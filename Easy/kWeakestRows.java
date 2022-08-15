class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int rows = mat.length;
        int col = mat[0].length;
        PriorityQueue<NewPair> pq = new PriorityQueue<>();
        for (int i = 0; i < rows; i ++) {
            int sol = 0;
            for (int j = 0; j < col; j ++) {
                if(mat[i][j] == 1) sol ++;
                else break;
            }
            pq.add(new NewPair(i, sol));
        }
        int[] ans = new int[k];
        for(int i = 0; i < k; i ++) {
            NewPair np = pq.remove();
            ans[i] = np.getRowNum();
        }
        return ans;
    }
}

class NewPair implements Comparable<NewPair> {
    private int rowNum;
    private int count;
    NewPair(int rn, int count) {
        this.rowNum = rn;
        this.count = count;
    }
    @Override
    public int compareTo(NewPair pair) { // -1 will be at high priority than 1 and weak should be given more priority. Therefore weak -> -1
        if(pair.count < count) return 1; // strong
        if(pair.count > count) return -1; // weak
        if(rowNum < pair.rowNum) return -1; // weak
        return 1;
    }


    public int getRowNum() {
        return rowNum;
    }
}
