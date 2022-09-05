class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        rec(0, ans, ds, nums);
        return ans;
    }
    
    private void rec(int index, List<List<Integer>> ans, List<Integer> ds, int[] nums) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(ds));
            return;
        }
        
        // not take
        rec(index + 1, ans, ds, nums);
        ds.add(nums[index]);
        rec(index + 1, ans, ds, nums);
        ds.remove(ds.size() - 1);
    }
}
