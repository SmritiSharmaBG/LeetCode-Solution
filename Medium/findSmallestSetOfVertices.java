class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //return sol1(n, edges);
        
        List<Integer> ans = new ArrayList<>();
        
        int[] inc = new int[n];
        
        for (List<Integer> l : edges) {
            inc[l.get(1)] ++;
        }
        
        for (int i = 0; i < n; i ++) {
            if (inc[i] == 0) ans.add(i);
        }
        
        return ans;
    }
    
    private List<Integer> sol1(int n, List<List<Integer>> edges) {
        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < n; i ++) list.add(new ArrayList<>());
        
        for (List<Integer> e : edges) {
            int to = e.get(0);
            int from = e.get(1);
            list.get(to).add(from);
        }
        
        int[] inc = new int[n];
        
        for (List<Integer> l : list) {
            for (int i : l) {
                inc[i] ++;
            }   
        }
        
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i ++) {
            if (inc[i] == 0) ans.add(i);
        }
        
        return ans;
    }
}
