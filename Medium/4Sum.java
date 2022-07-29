class Solution {
    public List<List<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length - 1; i ++) {
            for(int j = i + 1; j < arr.length; j ++) {
                int left = j + 1;
                int right = arr.length - 1;
                long rem = k - (long)(arr[i] + arr[j]);
                while(left < right) {
                    long sum = arr[left] + arr[right];
                    if(sum == rem) { // one quad found. save it
                        List<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[left]);
                        quad.add(arr[right]);
                        ans.add(new ArrayList<>(quad));
                        
                        while(left < right && arr[left] == quad.get(quad.size() - 2)) {
                            left ++;
                        }
                        while(left < right && arr[right] == quad.get(quad.size() - 1)) {
                            right --;
                        }
                    }
                
                    else if(sum < rem) {
                      left ++;
                    }
                    
                    else {
                      right --;                     
                    }   
                } // while
                while(j + 1 < arr.length && arr[j] == arr[j + 1]) j++;
            } // j
            while(i + 1 < arr.length && arr[i] == arr[i + 1]) i++;
        } // i
        return ans;
    }
}
