class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<Integer>());
        for(int[] i : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        boolean[] vis = new boolean[n];
        return dfs(source, destination, adj, false, vis);
    }
    
    boolean dfs(int source, int destination, ArrayList<ArrayList<Integer>> adj, boolean res, boolean[] vis) {
        vis[source] = true;
        if(source == destination) return true;
        for(int it : adj.get(source)) {
            if(!vis[it]) res = dfs(it, destination, adj, res, vis);
        }
        return res;
    }
}
