class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        // APPRAOCH 1 - using HashSet 
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        ArrayList<Integer> ds = new ArrayList<>();
        Arrays.sort(nums);
        app1(0, hs, ds, nums);
        return new ArrayList<>(hs);   
        
        // APPROACH 2
        // List<List<Integer>> list = new ArrayList<>();
        // ArrayList<Integer> ds = new ArrayList<>();
        // Arrays.sort(nums);
        // app2(0, list, ds, nums);
        // return list;
    }
    
    APPRAOCH 1 - using HashSet
    void app1(int i, HashSet<ArrayList<Integer>> hs, ArrayList<Integer> ds, int[] nums) {
        if(i == nums.length) {
            hs.add(new ArrayList<>(ds));
            return;
        }
        app1(i + 1, hs, ds, nums);
        ds.add(nums[i]);
        app1(i + 1, hs, ds, nums);
        ds.remove(ds.size() - 1);
    }
    
    // // APPROACH 2 - EFFICIENT SOLUTION
    // void app2(int i, List<List<Integer>> list, ArrayList<Integer> ds, int[] nums) {
    //     list.add(new ArrayList<>(ds));
    //     for(int j = i; j < nums.length; j++) {
    //         if(j != i && nums[j] == nums[j - 1]) continue;
    //         ds.add(nums[j]);
    //         app2(i + 1, list, ds, nums);
    //         ds.remove(ds.size() - 1);
    //     }
    // }
}
