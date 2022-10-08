class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] vis = new boolean[n];
        vis[0] = true;
        rec(rooms.get(0), rooms, vis);
        for(boolean b : vis) {
            if(!b) return false;
        }
        return true;
    }
    
    private void rec(List<Integer> ds, List<List<Integer>> rooms, boolean[] vis) {
        for(int it : ds) {
            if(!vis[it]) {
                vis[it] = true;
                rec(rooms.get(it), rooms, vis);
            }
        }
    }
}
