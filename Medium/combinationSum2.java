class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> ds = new ArrayList<>();
        Arrays.sort(candidates);
        rec(0, target, ds, list, candidates);
      //  List<List<Integer>> ans = new ArrayList<>(list);
        return list;
    }
    
    void rec(int index, int target, ArrayList<Integer> ds, List<List<Integer>> list, int[] arr) {
        if(target == 0) {
            list.add(new ArrayList<>(ds));
            return;
        }
        for(int i = index; i < arr.length; i ++) {
            if(i > index && arr[i] == arr[i - 1]) continue;
            if(arr[i] > target) break;
            ds.add(arr[i]);
            rec(i + 1, target - arr[i], ds, list, arr);
            ds.remove(ds.size() - 1);
        }
    }
}
