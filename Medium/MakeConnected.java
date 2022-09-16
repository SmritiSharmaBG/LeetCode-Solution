class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n - 1) return -1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i < n; i ++) list.add(new ArrayList<Integer>());
        for(int[] i : connections) {
            int src = i[0];
            int des = i[1];
            list.get(src).add(des);
            list.get(des).add(src);
        }
        
        boolean[] vis = new boolean[n];
        int component = 0;
        for(int i = 0; i < n; i ++) {
            if(!vis[i]) {
                component ++;
                dfs(i, list, vis);
            }
        }
        return component - 1;
    }
    
    private void dfs(int i, ArrayList<ArrayList<Integer>> list, boolean[] vis) {
        vis[i] = true;
        for(int it : list.get(i)) {
            if(!vis[it])
                dfs(it, list, vis);
        }
    }
}
