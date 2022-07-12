class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> a = new ArrayList<>();
        rec(candidates, target, 0, list, a);
        return list;
    }
    // void rec(int[] candidates, int target, int i, List<List<Integer>> list, ArrayList<Integer> a) {
    //     if(target < 0) {
    //         if(target == 0) {
    //             list.add(new ArrayList<>(a));
    //         }
    //         return;
    //     }
    //     a.add(candidates[i]);
    //     rec(candidates, target - candidates[i], i, list, a);
    //     target += a.get(a.size() - 1); 
    //     a.remove(a.size() - 1);
    //     if(i + 1 >= candidates.length) return;
    //     rec(candidates, target - candidates[i + 1], i + 1, list, a);
    //     return;
    // }
    
    void rec(int[] candidates, int target, int i, List<List<Integer>> list, ArrayList<Integer> a) {
        if(i == candidates.length) {
            if(target == 0) list.add(new ArrayList<>(a));
            return;
        }
        if(candidates[i] <= target) {
            a.add(candidates[i]);
            rec(candidates, target - candidates[i], i, list, a);
            a.remove(a.size() - 1);
        }
        rec(candidates, target, i + 1, list, a);
    }
}
