class Solution {
    public List<List<Integer>> permute(int[] nums) {
        
        // APPROACH 1
        // ArrayList<Integer> ds = new ArrayList<>();
        // List<List<Integer>> list = new ArrayList<>();
        // boolean[] occ = new boolean[nums.length];
        // rec(0, ds, nums, list, occ);
        // return list;
        
        // APPROACH 2 - efficient 
        List<List<Integer>> list = new ArrayList<>();
        rec(0, nums, list);
        return list;
        
    }
    
    void rec(int i, int[] nums, List<List<Integer>> list) {
        if(i == nums.length) {
            ArrayList<Integer> ds = new ArrayList<>();
            for(int it : nums) ds.add(it);
            list.add(ds);
            return;
        }
        
        for(int j = i; j < nums.length; j++) {
            swap(i, j, nums);
            rec(i + 1, nums, list);
            swap(i, j, nums);
        }
    }
    
    void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
}
    void rec(int i, ArrayList<Integer> ds ,int[] nums, List<List<Integer>> list, boolean[] occ) {
        if(i == nums.length) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int j = 0; j < nums.length; j++) {
            if(!occ[j]) {
                occ[j] = true;
                ds.add(nums[j]);
                rec(i + 1, ds, nums, list, occ);
                ds.remove(ds.size() - 1);
                occ[j] = false;
            }
        }
    }
}
