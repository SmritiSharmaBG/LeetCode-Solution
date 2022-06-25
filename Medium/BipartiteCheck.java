class Solution {
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++) color[i] = -1;
        for(int i = 0; i < graph.length; i++) {
            if(color[i] == -1) if(!check(i, graph, color)) return false;
        }
        return true;
    }
    public boolean check(int start, int[][] graph, int[] color) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        color[start] = 0;
        while(!queue.isEmpty()) {
            int element = queue.remove();
             for(int it : graph[element]) {
                if(color[it] == -1) {
                    color[it] = color[element] == 1 ? 0 : 1;
                    queue.add(it);
                } else if(color[it] == color[element]) return false;
            }
        }
        return true;
    }
}
