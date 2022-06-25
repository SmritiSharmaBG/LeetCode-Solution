class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i ++) adj.add(new ArrayList<Integer>());
        for(int i = 0; i < dislikes.length; i++) {
            adj.get(dislikes[i][0]).add(dislikes[i][1]);
            adj.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] col = new int[n+1];
        for(int i = 0; i <= n; i++) col[i] = -1;
        for(int i = 1; i <= n; i++) {
            if(col[i] == -1) {
                col[i] = 0;
                if(!isBipartite(adj, col, i)) return false;
            }
        }
        return true;
    }
    
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj, int[] colour, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int element = queue.remove();
            int elementCol = colour[element];
            for (int it : adj.get(element)) {
                if (colour[it] == -1) {
                    colour[it] = elementCol == 0 ? 1 : 0;
                    queue.add(it);
                } else if (colour[it] == elementCol) return false;
            }
        }
        return true;
    }
}
