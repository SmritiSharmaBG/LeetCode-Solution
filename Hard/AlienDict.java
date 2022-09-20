class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < k; i ++) graph.add(new ArrayList<>());
        for (int i = 0; i < n - 1; i ++) {
            String a = dict[i];
            String b = dict[i + 1];
            makeGraph(a, b, graph);
        }
        Stack<Integer> stack = new Stack<>();
        boolean[] vis = new boolean[k];
        for(int i = 0; i < k; i ++) {
            if(!vis[i]) topo(i, graph, vis, stack);
        }
        
        StringBuilder ans = new StringBuilder();
         for(int i = 0; i < k; i ++) {
             char c = (char)(stack.pop() + 'a');
             ans.append((c));
         }
       // System.out.println(ans.toString());
        return ans.toString();
    }
    
    private static void topo(int i, ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> stack) {
        vis[i] = true;
        for(int it : graph.get(i)) {
            if(!vis[it]) topo(it, graph, vis, stack);
        }
        stack.push(i); // first element will have outDegree = 0; will come last by LIFO
    }
    
    private static void makeGraph(String a, String b, ArrayList<ArrayList<Integer>> graph) {
        int len = a.length() < b.length() ? a.length() : b.length();
        for(int i = 0; i < len; i ++) {
            char cA = a.charAt(i);
            char cB = b.charAt(i);
            if(cA != cB) {
               // System.out.println("1. " + (cA - 'a') + " 2. " +(cB - 'a'));
                graph.get(cA - 'a').add(cB - 'a');
                break;
            }
        }
    }
}
